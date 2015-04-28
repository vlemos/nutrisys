/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.UsuarioManager;
import dao.util.Conn;
import dao.util.GenericDao;
import java.util.List;
import model.Usuario;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;


/**
 *
 * @author vinicius.lemos
 */
public class UsuarioDao extends Conn {
   final static Logger logger = Logger.getLogger(UsuarioDao.class); 
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
       logger.info("Salvar do usuario....");
      return dao.salvar(u);
      
  }
  
    /**
     *
     * @return retorna lista de todos os usuarios
     */
    public List<Usuario> listaTodos(){
      return dao.listarTodos("from Usuario usu ORDER BY usu.login");
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
            usuario = (Usuario) sessao.createQuery("from Usuario usu where usu.situacao=? and usu.login=? ORDER BY usu.login desc")
                    .setString(0, "ATIVO")
                    .setString(1, login)
                    .uniqueResult();
            fechaConexao();
        } catch (HibernateException e) {
            logger.info("Erro na consulta " + e.getMessage());
            fechaConexao();
        } 
        return usuario;
    }

    /**
     * Remover o usuario
     * @param usuario
     * @return
     */
    public String remover(Usuario usuario) {
        logger.info("Inicia a remoção do usuario... passa a responsabilidade para o GenericDao");
        return dao.remover(usuario);
    }

    /**
     * Busca o Usuario pelo ID
     * @param usuario
     * @return
     */
    public String buscarPorId(Usuario usuario) {
        Usuario usuarioAtual = null;
        logger.info("Inicia a busca por ID... passa a responsabilidade para o GenericDao");
        try {
            abreConexao();
            usuarioAtual = (Usuario) sessao.createQuery("from Usuario usu where usu.idusuario=?")
                    .setInteger(0, usuario.getIdusuario())
                    .uniqueResult();
            fechaConexao();
            return usuarioAtual.getLogin();
        } catch (HibernateException e) {
            logger.error("Erro na Consulta " + e.getMessage());
            return null;
        }
    }

    /**
     * Atualiza o Usuario
     * @param usuario
     * @return
     */
    public String atualizar(Usuario usuario) {
        logger.info("Inicia a atualização... passa para o GenericDao");
        return dao.atualizar(usuario);
    }
 
}
  