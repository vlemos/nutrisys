/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vinicius.lemos
 */
public class Conn {

    SessionFactory sessao;
    Transaction transaction;

    public void abreConexao() {
        sessao = HibernateUtil.getSessionFactory(); //Abrindo uma sessão
        transaction = sessao.getCurrentSession().beginTransaction();
    }

    public void fechaConexao() {
        sessao.close();
        transaction = null;
    }
    
}
