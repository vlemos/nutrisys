/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

/**
 *
 * @author vinicius.lemos
 */
public interface IBaseEntity {
 
    /**
     * Chave principal para as classe de Modelo para realizar a comparação do
     * metodo Equals e HashCode
     * @return
     */
    public Long getId(); 
}
