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

    public SessionFactory factory;
    public Transaction transaction;
    public Session sessao;

    public void abreConexao() {
        factory = HibernateUtil.getSessionFactory(); //Abrindo uma sessão
        sessao = factory.openSession();
        transaction = sessao.beginTransaction();
        
    }

    public void fechaConexao() {
        transaction = null;
        sessao.close();
       // factory.close(); não fecha esta porra senão da ruim!!!!! 
    }
    
}
