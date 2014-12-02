/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;



/**
 *
 * @author vinicius.lemos
 * @param <T>
 */
public class GenericDao<T> extends Conn implements IDao,Serializable {
    
 
    

    @Override
    public String salvar(Object t) {
        
        try {
            abreConexao();
            sessao.getCurrentSession().save(t);
            sessao.getCurrentSession().flush();
            transaction.commit();
            fechaConexao();
            return "Salvo com sucesso";
        } catch (HibernateException e) {
            return "Erro ao salvar!" + e.getMessage();
        } finally {
            fechaConexao();
        }

    }

    @Override
    public String atualizar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remover(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodosSituacao(String situacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
