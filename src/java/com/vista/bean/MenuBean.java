/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "menuBean")
@RequestScoped
public class MenuBean extends Bean {

    private int seleccion = -1;

    public MenuBean() {

    }
    
    public void onTabChange(ActionEvent actionEvent) {
        String title = (String) actionEvent.getComponent().getAttributes().get("seleccion");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext external = fc.getExternalContext();
        try {
            switch (title) {
                case "tablas":
                    this.seleccion = 1;
                    external.redirect("/PrimefacesShow/faces/pages/tablas.xhtml");
                    break;
                case "botones":
                    this.seleccion = 2;
                    external.redirect("/PrimefacesShow/faces/pages/botones.xhtml");
                    break;
                case "dialogos":
                    external.redirect("/PrimefacesShow/faces/pages/dialogos.xhtml");
                    break;
                case "imageges":
                    external.redirect("/PrimefacesShow/faces/pages/imagenes.xhtml");
                    break;
            }
        } catch (IOException ex) {
            logError("Error en menú", ex);
        }
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public int getSeleccion() {
        return this.seleccion;
    }

}
