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
    ATIVO("ATIVO"), INATIVO("INATIVO");
    private final String situacao;
    
    public String getLabel(){
        return situacao;
    }
    Situacao(String situacao){
        this.situacao = situacao;
    }
            
            
    
}
