package model;
// Generated 30/10/2014 12:13:30 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idusuario;
     private String login;
     private byte[] senha;
     private String situacao;

    public Usuario() {
    }

    public Usuario(int idusuario, String login, byte[] senha, String situacao) {
       this.idusuario = idusuario;
       this.login = login;
       this.senha = senha;
       this.situacao = situacao;
    }
   
    public int getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public byte[] getSenha() {
        return this.senha;
    }
    
    public void setSenha(byte[] senha) {
        this.senha = senha;
    }
    public String getSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }




}


