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
           
    /**
     *
     * @param t
     * @return 
     * Interface do metodo salvar
     */
    String salvar(T t);

    /**
     *
     * @param t
     * @return
     * Interface do metodo Atualizar
     */
    String atualizar(T t);

    /**
     *
     * @param t
     * @return
     * Interface do metodo remover
     */
    String remover(T t);

    /**
     *
     * @param t
     * @return
     * Interface do metodo listarTodos
     */
    List<T> listarTodos(T t);

    /**
     *
     * @param situacao
     * @return
     * Interface do metodo listarTodosSituacao
     */
    List<T> listarTodosSituacao(String situacao);
    
   
            
    
}
