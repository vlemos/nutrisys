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
public enum Situacao {

    /**
     * Retorna a ATIVO
     */
    ATIVO("ATIVO"),

    /**
     * Retorna INATIVO
     */
    INATIVO("INATIVO");
    private final String situacao;
    
    /**
     * Retorna a Situação escolhida
     * @return
     */
    public String getLabel(){
        return situacao;
    }
    Situacao(String situacao){
        this.situacao = situacao;
    }
            
            
    
}
