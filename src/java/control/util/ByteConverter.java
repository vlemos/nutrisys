/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.util;

import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author vinicius.lemos
 * Classe para converter a String recebida da tela em bytes[] para as classes JSF.
 */


@RequestScoped  
@FacesConverter("byteconverter")  
public class ByteConverter implements Converter{

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return retorna Objeto convertido.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value.getBytes();
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return retorna Objeto convertido.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return  value.toString();
    }
    
}
