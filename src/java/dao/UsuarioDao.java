/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.Conn;
import dao.util.GenericDao;
import java.util.List;
import model.Usuario;
import org.hibernate.HibernateException;


/**
 *
 * @author vinicius.lemos
 */
public class UsuarioDao extends Conn {
    
    private  static UsuarioDao instancia;    
    private final GenericDao<Usuario> dao;

    
    private UsuarioDao(){ dao = new GenericDao<>(); }
    
    /**
     *
     * @return Singleton da classe UsuarioDao
     */
    public static UsuarioDao getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDao();
        }
        return instancia;
    } 
  
    /**
     *
     * @param u
     * @return retorna String informando se o objeto foi salvo ou não
     */
    public String salvar(Usuario u){
      return dao.salvar(u);
      
  }
  
    /**
     *
     * @return retorna lista de todos os usuarios
     */
    public List<Usuario> listaTodos(){
      return dao.listarTodos("from Usuario");
  }

    /**
     *
     * @param login
     * @return Busca usuario por Nome com situação ATIVO
     */
    public Usuario buscarPorNomeAtivo(String login) {
        Usuario usuario = null;
        try {
            abreConexao();
            
            //System.out.println("Fez a consulta do Usuario");
            usuario = (Usuario) sessao.createQuery("from Usuario usu where usu.situacao=? and usu.login=?")
                    .setString(0, "ATIVO")
                    .setString(1, login)
                    .uniqueResult();
            fechaConexao();
        } catch (HibernateException e) {
            System.out.println("Erro na consulta " + e.getMessage());
            fechaConexao();
        } 
        return usuario;
    }
 
}
  