/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.util.Situacao;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.apache.log4j.Logger;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name = "usuarioManager")
@SessionScoped
public class UsuarioManager implements Serializable {
   final static Logger logger = Logger.getLogger(UsuarioManager.class);
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private String acao = "";
    
    /**
     *
     * @return Busca as situações do ENUM
     */
    public Situacao[] getSituacoes(){
        return Situacao.values();
    }
    

    /**
     *
     * @return retorna o objeto usuario para a tela
     */
    public Usuario getUsuario() {
        //usuario = new Usuario();
        return this.usuario;
    }

    /**
     *
     * @param usuario Passa o obejto usuario para o controle
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return retorna um objeto do tipo List contendo todos os usuarios do
     * Banco de Dados
     */
    public List<Usuario> getUsuarios() {
        // aqui entrarar a consulta ao Banco de dados para buscar os usuarios cadastrados
        usuarios = new ArrayList<>();
        usuarios = UsuarioDao.getInstance().listaTodos();
        return usuarios;
    }

    /**
     *
     * @param usuarios Passa de volta para o controle uma lista de usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    /**
     *
     * @return Chama a tela UsuarioManter
     */
    public String novo(){
        acao = "novo";
        usuario = new Usuario();
        return "/restrito/usuarioManter.xhtml";
    }
    
    /**
     * Grava o usuario ( Atualiza ou Inclui um Novo )
     * @return Retorna para a pagina de Manutenção ou de lista de usuarios.
     */
    public String gravar() {
        String retorno = "";
        //usuario = new Usuario();
       System.out.println("Entrou no menu gravar");
       logger.info("Chamou o Menu Gravar");
        if (acao.equals("novo")) {
            logger.info("acao novo encontrado");
            if ((usuario.getLogin().equals("")) || (Arrays.toString(usuario.getSenha()).equals("")) || ((usuario.getGrupo() == null)) || (usuario.getSituacao().equals(""))) {
                logger.info("não preencheu os requisitos.... envia msg de erro");
                FacesMessage msg = new FacesMessage("ERROR", "Favor preencher todos os campos");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/restrito/usuarioManter.xhtml";
            } else {
                logger.info("preencheu os requisitos... chama o DAO para Salvar");
                usuario.setTrocasenha("N");
                FacesMessage msg = new FacesMessage("",UsuarioDao.getInstance().salvar(usuario));
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/restrito/usuario.xhtml";
            }
        } else {
            return "/restrito/usuarioManter.xhtml";
        }

    }
    
    /**
     *
     * @param event
     *  Verifica o Usuario Selecionado
     */
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Usuario Selecionado", ((Usuario) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    /**
     *
     * @param event
     * Verifica o Usuario Não Selecionado
     */
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Usuário não Selecionado", ((Usuario) event.getObject()).getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *
     * @return Retorna se o Login do Usuario no sistema teve sucesso ou não
     */
    public String logar() {
        Usuario usuarioLogado;
        usuarioLogado = UsuarioDao.getInstance().buscarPorNomeAtivo(usuario.getLogin());
        System.out.println(usuario.getLogin());
        if ((usuarioLogado != null)) {
            // Encontrou o usuario.... então valida a senha
            String senhaLogado = Arrays.toString(usuarioLogado.getSenha());
            String senhaTela = Arrays.toString(usuario.getSenha());
            System.out.println(senhaLogado);
            System.out.println(senhaTela);
            if (senhaLogado.equals(senhaTela)) {
                // senha confere.. acessa o sistema
                return "/restrito/principal.xhtml";
            } else {
                // senha não confere.... retorna msg de erro
                FacesContext.getCurrentInstance().addMessage("Login", new FacesMessage("Usuario/senha Inválido"));
                System.out.println("Usuario/senha Inválido");
                return "index.xhtml";

            }

        } else {
            FacesContext.getCurrentInstance().addMessage("Login", new FacesMessage("Usuario não encontrado ou Inativo"));
            System.out.println("Usuario não encontrado ou Inativo");
            return "index.xhtml";
        }
    }
}
