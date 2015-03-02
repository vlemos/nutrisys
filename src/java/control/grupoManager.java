/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.GrupoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Grupo;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author vinicius.lemos
 */
@ManagedBean(name = "grupoManager")
@SessionScoped
public class grupoManager implements Serializable {

    private Grupo grupo;
    private List<Grupo> grupos;

    /**
     *
     * @return retorna o objeto usuario para a tela
     */
    public Grupo getGrupo() {
        //usuario = new Usuario();
        return this.grupo;
    }

    /**
     *
     * @param grupo Passa o obejto usuario para o controle
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    /**
     *
     * @return chama a tela GrupoManter
     */
    public String novo(){
        
        grupo = new Grupo();
        return "/restrito/grupoManter.xhtml";
    }

    /**
     *
     * @return retorna um objeto do tipo List contendo todos os usuarios do
     * Banco de Dados
     */
    public List<Grupo> getGrupos() {
        // aqui entrarar a consulta ao Banco de dados para buscar os usuarios cadastrados
        grupos = new ArrayList<>();
        return GrupoDao.getInstance().listaTodos();
    }

    /**
     *
     * @param grupos Passa de volta para o controle uma lista de usuarios
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    /**
     *
     * @param event
     * verifica o Grupo Selecionado na tela
     */
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Grupo Selecionado", ((Grupo) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    /**
     *
     * @param event
     * verifica o Grupo não Selecionado
     */
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Usuário não Selecionado", ((Grupo) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    
}
