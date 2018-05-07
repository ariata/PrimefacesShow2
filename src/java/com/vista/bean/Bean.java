/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista.bean;

import com.model.dao.PrimeDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrador
 */
class Bean implements Serializable {

    protected PrimeDAO dao = new PrimeDAO();
    protected String mensaje;
    private static Logger log = Logger.getLogger(Bean.class);

    public void addMessage(String summary, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void logInfo(String mensaje) {
        if (log == null) {
            log = Logger.getLogger(getClass());
        }
        log.info(mensaje);
    }

    public void logWarn(String mensaje) {
        if (log == null) {
            log = Logger.getLogger(getClass());
        }
        log.warn(mensaje);
    }

    public void logError(String mensaje) {
        if (log == null) {
            log = Logger.getLogger(getClass());
        }
        log.error(mensaje);
    }

    public void logError(String mensaje, Exception e) {
        if (log == null) {
            log = Logger.getLogger(getClass());
        }
        log.error(mensaje, e);
    }
}
