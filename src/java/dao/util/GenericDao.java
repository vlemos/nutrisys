/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;



/**
 *
 * @author vinicius.lemos
 * @param <T>
 */
public class GenericDao<T> extends Conn implements IDao,Serializable {
    final static Logger logger = Logger.getLogger(GenericDao.class); 
    /**
     *
     * @param t
     * @return String informando se foi salvo ou não
     * Metodo Salvar genérico para todas as classes
     */
    @Override
    public String salvar(Object t) {
       logger.info("Entrou no genericDao .."); 
        try {
            logger.info("Abrindo Conexao"); 
            abreConexao();
            logger.info("Salvando Objeto"); 
            sessao.save(t);
            transaction.commit();
            sessao.flush();
            fechaConexao();
            return "Salvo com sucesso";
        } catch (ConstraintViolationException e){
            return "O registro já existe na base ";
        } catch (Exception e) {
            return "Erro ao salvar!" + e.getMessage();
        } 
          
    }

    /**
     *
     * @param t
     * @return string informando se a classe foi atualizada ou não
     * Metodo Atualizar genérico para todas as classes
     */
    @Override
    public String atualizar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param t
     * @return retorna String informando se o Objeto foi removido ou não
     * Metodo remover genérico para todas as classes
     */
    @Override
    public String remover(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param t
     * @return retorna Lista de todos os objetos consultados
     * Metodo Listar Todos genérico para todas as classes
     */
    @Override
    public List listarTodos(Object t) {
        List retorno = null;
        try {
            abreConexao();
            retorno = sessao.createQuery((String) t).list();
            fechaConexao();
        } catch (Exception e) {
            System.out.println("Erro ao pegar todos " + t + " " + e.getMessage());
        }
        
        return retorno;
    }

    /**
     *
     * @param situacao
     * @return retorna Lista de Todos os Objetos por uma situação especifica
     * Metodo ListarTodos genérico para todas as classes
     */
    @Override
    public List listarTodosSituacao(String situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
