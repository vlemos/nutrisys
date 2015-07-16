/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;

/**
 *
 * @author vinicius.lemos
 */
public class teste {
    
    public static void main(String args[]){
        Usuario usu = new Usuario();
        usu.setLogin("Vinicius");
        //usu.setSenha("123");
        System.out.print(UsuarioDao.getInstance().salvar(usu));
    }
    
}
