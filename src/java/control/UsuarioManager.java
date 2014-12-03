/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioDao;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name = "usuarioManager")
@SessionScoped
public class UsuarioManager implements Serializable{
    
    private Usuario usuario  = new Usuario();
    private List<Usuario> usuarios;
        
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
     * @param usuario 
     * Passa o obejto usuario para o controle
     */
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    
    /**
     * 
     * @return retorna um objeto do tipo List contendo todos os usuarios do Banco de Dados
     */
    public List<Usuario> getUsuarios(){
        // aqui entrarar a consulta ao Banco de dados para buscar os usuarios cadastrados
        return usuarios;
    }
    
    /**
     * 
     * @param usuarios 
     * Passa de volta para o controle uma lista de usuarios
     */
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    } 
    
    public String logar(){
        
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
