/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Proyecto;

import DAO.ConexionDAO;
import DAO.ConsultasDAO;
import DTO.DatosDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_LUsuario")
public class Usuarios implements Serializable {
    private int id;
       private String nombreUsuario;
    private String FechaNacimiento;
    private String GradoAcademico;
    private String direccion;
    private String estado;
    private String Usuario;
    private String Contraseña;
    private List<DatosDTO> lista;
     ConsultasDAO consulta = new ConsultasDAO();
     
             //Actualizar clientes a la base de datos
    public void ActualizarClientes() {
        try {
         consulta.actualizarDatos(getId(), getNombreUsuario(), getFechaNacimiento(), getGradoAcademico(), getDireccion(), getEstado(), getUsuario() ,getContraseña());
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @PostConstruct
    public void init() {
        ConexionDAO con = new ConexionDAO();
        try {
            lista = consulta.findAllCliente();
        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);
        }
    }
     
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
