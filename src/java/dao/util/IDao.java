/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;


import java.util.List;

/**
 *
 * @author vinicius.lemos
 * @param <T>
 */
public interface IDao<T> {
           
    String salvar(T t);
    String atualizar(T t);
    String remover(T t);
    List<T> listarTodos();
    List<T> listarTodosSituacao(String situacao);
            
    
}
