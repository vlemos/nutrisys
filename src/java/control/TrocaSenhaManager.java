/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuario;
import org.apache.log4j.Logger;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name ="trocaSenhaManager")
@SessionScoped
public class TrocaSenhaManager implements Serializable{
    
    final static Logger logger = Logger.getLogger(TrocaSenhaManager.class);
    private Usuario usuario;
    private String senhaAtual;
    private String senhaNova;
    private String senhaNovaConfirma;
    
    
       public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String trocarSenha(){
       
        /*
          1 -> verifica se todos os campos foram preenchidos
          2 -> verifica se a senha atual corresponde a gravada no banco
          3 -> verifica se a senha nova bate com a confirmação
          4 -> altera a senha.
        */
        
        if (todosCamposPreenchidos() == false){
            addMessage("", "Favor preencher Todos os campos para continuar");
            return "/restrito/trocarSenha.xhtml";
        } 
                
        
        return "/restrito/principal.xhtml";
    }
    
    public Usuario getUsuario(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        setUsuario((Usuario) session.getAttribute("usuario"));
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public String retorno(){
        return "/restrito/principal.xhtml";
    }

    /**
     * @return the senhaAtual
     */
    public String getSenhaAtual() {
        return senhaAtual;
    }

    /**
     * @param senhaAtual the senhaAtual to set
     */
    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    /**
     * @return the senhaNova
     */
    public String getSenhaNova() {
        return senhaNova;
    }

    /**
     * @param senhaNova the senhaNova to set
     */
    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    /**
     * @return the senhaNovaConfirma
     */
    public String getSenhaNovaConfirma() {
        return senhaNovaConfirma;
    }

    /**
     * @param senhaNovaConfirma the senhaNovaConfirma to set
     */
    public void setSenhaNovaConfirma(String senhaNovaConfirma) {
        this.senhaNovaConfirma = senhaNovaConfirma;
    }

    
    
    private boolean todosCamposPreenchidos() {
        System.out.println(getSenhaAtual());
        System.out.println(getSenhaNova());
        System.out.println(getSenhaNovaConfirma());
        return (!getSenhaAtual().trim().equals("")) && (!getSenhaNova().trim().equals("")) && (!getSenhaNovaConfirma().trim().equals(""));
    }
    
    
    
}
