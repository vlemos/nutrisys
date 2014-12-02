/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.GenericDao;
import model.Usuario;


/**
 *
 * @author vinicius.lemos
 */
public class UsuarioDao {
    
    private  static UsuarioDao instancia;    

    
    
    public static UsuarioDao getInstance(){
        if(instancia ==null)
            instancia = new UsuarioDao();
            return instancia;
    }    
  
  public String salvar(Usuario u){
      GenericDao<Usuario> dao = new GenericDao();
      return dao.salvar(u);
      
  }
 
}
