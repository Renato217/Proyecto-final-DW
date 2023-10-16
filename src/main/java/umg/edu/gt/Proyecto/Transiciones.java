/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Proyecto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_ventana")
@RequestScoped
public class Transiciones {
    //nos permite ir a la ventana de clientes

    public void VentanaCrear() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/CrearCuenta.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void VentanaAutores() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/LAutores.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
     public void VentanaTiposLibros() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/TipoLibro.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaLogin() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/Login.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaAquilar() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/Prestar.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaPrestar() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/Devolucion.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaHomeAlquiler() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/HomeAlquier.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaIngresoLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/IngresarLibro.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaHomeLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/HomeLibros.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaActuLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/ActualizarLibro.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaMostrarusuario() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/LUsuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaActualizarusuario() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/AUsuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VentanaHome() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/Home.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HomeUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/Proyectofinal/Pages/HomeUsuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Transiciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
