/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.Conn;
import dao.util.GenericDao;
import model.Usuario;
import org.hibernate.HibernateException;


/**
 *
 * @author vinicius.lemos
 */
public class UsuarioDao extends Conn {
    
    private  static UsuarioDao instancia;    

    
    
    public static UsuarioDao getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDao();
        }
        return instancia;
    } 
  
  public String salvar(Usuario u){
      GenericDao<Usuario> dao = new GenericDao();
      return dao.salvar(u);
      
  }

    public Usuario buscarPorNomeAtivo(String login) {
        Usuario usuario = null;
        try {
            abreConexao();
            
            //System.out.println("Fez a consulta do Usuario");
            usuario = (Usuario) sessao.createQuery("from Usuario usu where usu.login=?")
                    //.setString(0, "ATIVO")
                    .setString(0, login)
                    .uniqueResult();
            fechaConexao();
        } catch (HibernateException e) {
            System.out.println("Erro na consulta " + e.getMessage());
            fechaConexao();
        } 
        return usuario;
    }
 
}
  