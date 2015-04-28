/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.GrupoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Grupo;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name = "grupoManager")
@SessionScoped
public class GrupoManager implements Serializable {

    private Grupo grupo;
    private List<Grupo> grupos;
    final static Logger logger = Logger.getLogger(GrupoManager.class);
    private String acao = "";
    

    /**
     *
     * @return retorna o objeto grupo para a tela
     */
    public Grupo getGrupo() {
        return this.grupo;
    }

    /**
     *
     * @param grupo Passa o obejto grupo para o controle
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    /**
     *
     * @return chama a tela GrupoManter
     */
    public String novo(){
        acao = "novo";
        grupo = new Grupo();
        return "/restrito/grupoManter.xhtml";
    }

    /**
     *
     * @return retorna um objeto do tipo List contendo todos os grupos do
     * Banco de Dados
     */
    public List<Grupo> getGrupos() {
        // aqui entrarar a consulta ao Banco de dados para buscar os grupos cadastrados
        grupos = new ArrayList<>();
        grupos = GrupoDao.getInstance().listaTodos();
        return grupos;
    }

    /**
     *
     * @param grupos Passa de volta para o controle uma lista de grupos
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    /**
     *
     * @param event
     * verifica o Grupo Selecionado na tela
     */
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Grupo Selecionado", ((Grupo) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    /**
     *
     * @param event
     * verifica o Grupo não Selecionado
     */
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Usuário não Selecionado", ((Grupo) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     /**
     *
     * Remove a seleção atual
     * @return Retorna a propria pagina
     */
    public String remover() {
        if (grupo != null ) {
            logger.info("grupo selecionado para ser removido " + grupo.getNome());
            if (grupo.getNome().equals("admin")) {
                logger.info("não pode remover admin");
                addMessage("Atenção", "O Grupo admin não pode ser removido");
            } else {
                logger.info("chama o remover do dao de Grupo");
                addMessage("Remover", GrupoDao.getInstance().remover(grupo));
            }
          
        }else{
            addMessage("", "Favor Selecionar um Grupo");
        }
        return "/restrito/grupo.xhtml";
    }
    
    /**
     *
     * @return Pagina de Manter grupo
     */
    public String atualizar() {
        if (grupo != null) {
            if (grupo.getNome().equals("admin")) {
                logger.info("Nao pode alterar o Admin");
                addMessage("Atenção", "Grupo Admin não pode ser alterado");
                return "/restrito/grupo.xhtml";
            } else {
                acao = "atualizar";
                return "/restrito/grupoManter.xhtml";
            }

        } else {
            addMessage("", "Favor selecionar um Grupo");
            return "/restrito/grupo.xhtml";
        }

    }

    /**
     * Gerador de Mensagem pra tela
     * @param summary
     * @param detail
     */
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
        /**
     * Grava o grupo ( Atualiza ou Inclui um Novo )
     *
     * @return Retorna para a pagina de Manutenção ou de lista de grupos.
     */
    public String gravar() {

        System.out.println("Entrou no menu gravar");
        logger.info("Chamou o Menu Gravar");
        if (acao.equals("novo")) {
            logger.info("acao novo encontrado");
            addMessage("", GrupoDao.getInstance().salvar(grupo));
            return "/restrito/grupo.xhtml";
        } else {
            if (acao.equals("atualizar")) {
                logger.info("Acao atualizar encontrado");
                logger.info("preencheu os requisitos... chama o DAO para Atualizar");
                addMessage("", GrupoDao.getInstance().atualizar(grupo));
                return "/restrito/grupo.xhtml";
            } else {
                return "/restrito/grupo.xhtml";
            }
        }
    }
         
}