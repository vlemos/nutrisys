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
    
    public static void main(String args[]) {

        byte[] b = "123".getBytes();
        Usuario usu = new Usuario();
        usu.setSituacao("ATIVO");
        usu.setLogin("Vinicius");
        usu.setSenha(b);
        System.out.println(b);
        System.out.println(UsuarioDao.getInstance().salvar(usu));

    }
    
}
