/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author vinicius.lemos
 */

@ManagedBean(name = "menuManager")
@SessionScoped
public class MenuManager {
    
    final static Logger logger = Logger.getLogger(MenuManager.class);
    
    /**
     *
     * @return para Saida do Programa
     */
    public String logout(){
        return "/index.xhtml";
    }
    
    /**
     *
     * @return Chama o Menu de Usuario
     */
    public String menuUsuario(){
        logger.info("chamou o menuUsuario");
        return "/restrito/usuario.xhtml";
    }
    
    /**
     *
     * @return Chama o Menu do Grupo
     */
    public String menuGrupo(){
        logger.info("chamou o menuGrupo");
        return "/restrito/grupo.xhtml";
    }
    
}
