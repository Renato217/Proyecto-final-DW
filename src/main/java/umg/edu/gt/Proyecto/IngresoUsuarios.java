/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Proyecto;

import DAO.ConsultasDAO;
import DTO.DatosDTO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_Users")
public class IngresoUsuarios implements Serializable {

    private String nombreUsuario;
    private String FechaNacimiento;
    private String GradoAcademico;
    private String direccion;
    private String estado = "activo";
    private String Usuario;
    private String Contraseña;
    private List<DatosDTO> lista;
    ConsultasDAO consulta = new ConsultasDAO();

public void AgregarUsers() {
    lista = consulta.findAllCliente();

    // Buscar el usuario en la base de datos
    boolean usuarioEncontrado = false;
    int i = 0;
    while (!usuarioEncontrado && i < lista.size()) {
        if (lista.get(i).getUsuario().equals(getUsuario())) {
            usuarioEncontrado = true;
        } else {
            i++;
        }
    }

    // Si el usuario no existe, ingresar los datos
    if (!usuarioEncontrado) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            consulta.ingresarUsers(getNombreUsuario(), getFechaNacimiento(), getGradoAcademico(), getDireccion(), "Activo", getUsuario(), getContraseña());

        } catch (Exception ex) {
            Logger.getLogger(IngresoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario ya existe"));
    }
}

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the FechaNacimiento
     */
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    /**
     * @param FechaNacimiento the FechaNacimiento to set
     */
    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    /**
     * @return the GradoAcademico
     */
    public String getGradoAcademico() {
        return GradoAcademico;
    }

    /**
     * @param GradoAcademico the GradoAcademico to set
     */
    public void setGradoAcademico(String GradoAcademico) {
        this.GradoAcademico = GradoAcademico;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the lista
     */
    public List<DatosDTO> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<DatosDTO> lista) {
        this.lista = lista;
    }

}
