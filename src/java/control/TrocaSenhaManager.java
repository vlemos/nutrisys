/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioDao;
import java.io.Serializable;
import java.util.Arrays;

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
    private byte[] senhaAtual;
    private byte[] senhaNova;
    private byte[] senhaNovaConfirma;
    
    
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
        
        //verifica se senha atual digitada confere coma senha atual do banco
        String senhaAtuals = Arrays.toString(usuario.getSenha());
        String confereSenhaAtual = Arrays.toString(senhaAtual);
        
        if(!senhaAtuals.equals(confereSenhaAtual)){
            addMessage("", "Senha atual não confere!");
            return "/restrito/trocarSenha.xhtml";
        }
        
        //verifica se a nova senha bate com a confirmação digitada.
        String senhaNovas = Arrays.toString(getSenhaNova());
        String senhaConfirmaNovas = Arrays.toString(getSenhaNovaConfirma());
        
        if(!senhaNovas.equals(senhaConfirmaNovas)){
            addMessage("","Confirmação da Nova senha não bate com a Nova senha escolhida");
            return "/restrito/trocarSenha";
        }
                
        // estando tudo certo, então atualiza a nova senha do usuario
        Usuario usu = UsuarioDao.getInstance().buscarPorNomeAtivo(usuario.getLogin());
        usu.setSenha(senhaNova);
        //System.out.println(usu.getIdusuario());
        
        addMessage("",UsuarioDao.getInstance().atualizar(usu));
        
        return "/restrito/trocarSenha.xhtml";
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
    public byte[] getSenhaAtual() {
        return senhaAtual;
    }

    /**
     * @param senhaAtual the senhaAtual to set
     */
    public void setSenhaAtual(byte[] senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    /**
     * @return the senhaNova
     */
    public byte[] getSenhaNova() {
        return senhaNova;
    }

    /**
     * @param senhaNova the senhaNova to set
     */
    public void setSenhaNova(byte[] senhaNova) {
        this.senhaNova = senhaNova;
    }

    /**
     * @return the senhaNovaConfirma
     */
    public byte[] getSenhaNovaConfirma() {
        return senhaNovaConfirma;
    }

    /**
     * @param senhaNovaConfirma the senhaNovaConfirma to set
     */
    public void setSenhaNovaConfirma(byte[] senhaNovaConfirma) {
        this.senhaNovaConfirma = senhaNovaConfirma;
    }

    
    
    private boolean todosCamposPreenchidos() {
        System.out.println(getSenhaAtual());
        System.out.println(getSenhaNova());
        System.out.println(getSenhaNovaConfirma());
        
        String senhaAtuals = Arrays.toString(getSenhaAtual());
        String senhaNovas = Arrays.toString(getSenhaNova());
        String senhaNovaConfirmas = Arrays.toString(getSenhaNovaConfirma());
        
        System.out.println(senhaAtuals);
        System.out.println(senhaNovas);
        System.out.println(senhaNovaConfirmas);
        
      // senao não preencheu algum campo, então dá erro.... senão retorna true caso tenha sido tudo preenchido
        if ((senhaAtuals.trim().equals("[]")) || (senhaNovas.trim().equals("[]")) || (senhaNovaConfirmas.trim().equals("[]"))) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
}
