/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.Conn;
import dao.util.GenericDao;
import java.util.List;
import model.Grupo;


/**
 *
 * @author vinicius.lemos
 */
public class GrupoDao extends Conn {
    
    private  static GrupoDao instancia;    
    private final GenericDao<Grupo> dao;

    
    private GrupoDao(){ dao = new GenericDao<>(); }
    
    /**
     *
     * @return Singleton da Classe Dao
     */
    public static GrupoDao getInstance() {
        if (instancia == null) {
            instancia = new GrupoDao();
        }
        return instancia;
    } 
  
    /**
     *
     * @param u
     * @return retorna String informando o objeto Salvo ou não
     */
    public String salvar(Grupo u){
      return dao.salvar(u);
      
  }
  
    /**
     *
     * @return retorna toda Lista de grupos da Base de dados
     */
    public List<Grupo> listaTodos(){
      return dao.listarTodos("from Grupo");
  }

   
 
}
  