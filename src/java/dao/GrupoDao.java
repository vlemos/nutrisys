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
import org.apache.log4j.Logger;

/**
 *
 * @author vinicius.lemos
 */
public class GrupoDao extends Conn {

    final static Logger logger = Logger.getLogger(GrupoDao.class);
    private static GrupoDao instancia;
    private final GenericDao<Grupo> dao;

    private GrupoDao() {
        dao = new GenericDao<>();
    }

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
    public String salvar(Grupo u) {
        logger.info("Salvar Grupo....");
        return dao.salvar(u);

    }

    /**
     *
     * @return retorna toda Lista de grupos da Base de dados
     */
    public List<Grupo> listaTodos() {
        return dao.listarTodos("from Grupo g order by g.nome");
    }
    
    /**
     * Remove o Grupo
     * @param grupo
     * @return
     */
    public String remover(Grupo grupo) {
        logger.info("Inicia a remoção do grupo... passa a responsabilidade para o GenericDao");
        return dao.remover(grupo);
    }

    /**
     * Atualiza o Grupo
     * @param grupo
     * @return
     */
    public String atualizar(Grupo grupo) {
        logger.info("Inicia a atualização... passa para o GenericDao");
        return dao.atualizar(grupo);
    }

}
