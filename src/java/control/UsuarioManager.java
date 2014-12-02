/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name = "usuarioManager")
@SessionScoped
public class UsuarioManager {
    
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
        
    /**
     * 
     * @return retorna o objeto usuario para a tela
     */
    public Usuario getUsuario() {
        
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
        //usuario = new Usuario();
        return "principal";
    }
    
}
