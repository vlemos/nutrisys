/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import model.util.IBaseEntity;

/**
 *
 * @author vinicius.lemos
 */
public class Converte implements Converter {

    /**
     * Adiciona o Atributos basicos na classe Converte
     * @param component
     * @param o
     */
    protected void addAttribute(UIComponent component, IBaseEntity o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso  
        this.getAttributesFrom(component).put(key, o);
    }

    /**
     * Pega os atributos da Classe
     * @param component
     * @return
     */
    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

    /**
     * Pega o Objeto
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    /**
     * Pega o Objeto e retorna a String
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {

            IBaseEntity entity = (IBaseEntity) value;

            // adiciona item como atributo do componente  
            this.addAttribute(component, entity);

            Long codigo = entity.getId();
            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }

}
