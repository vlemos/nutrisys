/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vinicius.lemos
 */

@ManagedBean(name = "menuManager")
@SessionScoped
public class MenuManager {
    
    public String logout(){
        return "/index.xhtml";
    }
    
    public String menuUsuario(){
        System.out.println("chamou o menuUsuario");
        return "/restrito/usuario.xhtml";
    }
    
}
