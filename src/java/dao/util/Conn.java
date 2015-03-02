/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vinicius.lemos 
 */
public class Conn {

    /**
     * Fabrica de Conexos
     */
    public SessionFactory factory;

    /**
     * Transaction das operaçõe de Banco
     */
    public Transaction transaction;

    /**
     * Sessao do Banco
     */
    public Session sessao;

    /**
     * Abre conexão com o Banco
     */
    public void abreConexao() {
        factory = HibernateUtil.getSessionFactory(); //Abrindo uma sessão
        sessao = factory.openSession();
        transaction = sessao.beginTransaction();
        
    }

    /**
     * Fecha conexão com o Banco
     */
    public void fechaConexao() {
        transaction = null;
        sessao.close();
       // factory.close(); não fecha esta porra senão da ruim!!!!! 
    }
    
}
