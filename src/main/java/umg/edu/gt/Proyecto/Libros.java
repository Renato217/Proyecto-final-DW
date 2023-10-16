/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Proyecto;

import DAO.ConexionDAO;
import DAO.ConsultasDAO;
import DTO.DatosDTO;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_ingresaLibro")
public class Libros implements Serializable {

    private long idl;
    private long idPrestamo;
    private int idUser;
    private String nombrel;
    private String categorial;
    private String aniol;
    private String editoriall;
    private String nombreAutorl;
    private String estadol;
    private String opcionSeleccionada;
    private List<DatosDTO> lista;
    private List<DatosDTO> listas;
    private List<DatosDTO> listaa;
    private String Eslibro = "disponible";

    ConsultasDAO consulta = new ConsultasDAO();

    public Libros() {

    }
    public void ActualizarLibros() {
        try {
         consulta.actualizarLibros(getIdl(), getNombrel(), getCategorial(), getAniol(), getEditoriall(), getNombreAutorl(), getEstadol());
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //se ingresan nuevos libros
    public void enviarLibros() {
        try {
            consulta.ingresarLibros(getIdl(), getNombrel(), getCategorial(), getAniol(), getEditoriall(),
                    getNombreAutorl(), getOpcionSeleccionada());
        } catch (Exception e) {
            System.out.println("fallo en envio de libro a consultasDao error--> " + e);
        }
    }

    //se ingresa un prestamo de libro
    public void PrestarLibro() {

        lista = consulta.findAllLibros();

        // Buscar el usuario en la base de datos
        boolean usuarioEncontrado = false;
        int i = 0;
        while (!usuarioEncontrado && i < lista.size()) {
            if (lista.get(i).getIdl() == (getIdl()) && lista.get(i).getOpcionSeleccionada().equals(getEslibro())) {
                usuarioEncontrado = true;
            } else {
                i++;
            }
        }
        // if (lista.get(i).getIdl().equals(getIdl()) && lista.get(i).getOpcionSeleccionada().equals(getEslibro())) {

        // Si el usuario existe, redireccionar a la página principal
        if (usuarioEncontrado) {
            try {
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                consulta.ingresarPrestamo(getIdUser(), getIdl());
                consulta.actualizarEstadoLibro(getIdl(), "alquilado");
                System.out.println("si se ingreso");
            } catch (Exception ex) {
                Logger.getLogger(Libros.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
        } else {
            System.out.println("no ingreso");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Libro no esta disponible"));
        }
    }

    //se ingresa un devolver de libro
    public void devolverLibro() {
        listaa = consulta.findAllLibros();
        lista = consulta.findAllPrestamo();

        // Buscar el usuario en la base de datos
        boolean Devolver = false;
        int i = 0;
        while (!Devolver && i < lista.size()) {
            if (lista.get(i).getIdPrestamo() == (getIdPrestamo())) {
                Devolver = true;

            } else {
                i++;
            }
        }
        // if (lista.get(i).getIdl().equals(getIdl()) && lista.get(i).getOpcionSeleccionada().equals(getEslibro())) {

        // Si el usuario existe, redireccionar a la página principal
        if (Devolver) {
            try {
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                consulta.actualizarEstadoLibro(lista.get(i).getIdl(), "disponible");
                System.out.println("si se ingreso");
            } catch (Exception ex) {
                Logger.getLogger(Libros.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
        } else {

            System.out.println("no ingreso");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Libro no se encuentra prestado"));
        }
    }
     
    //se consultan los libros
    @PostConstruct
    public void init() {
        try {
            lista = consulta.findAllLibros();
        } catch (Exception ex) {
            System.out.println("Error de la conexion" + ex);  
        }
    }
    
     public void TiposLibros() {
                listaa = lista.stream()
                .filter(DatosDTO -> DatosDTO.getCategorial().equals(getCategorial()))
                .collect(Collectors.toList()); 
                
         System.out.println("entre");
    }
     
       public void Autores() {
                listaa = lista.stream()
                .filter(DatosDTO -> DatosDTO.getNombreAutorl().equals(getNombreAutorl()))
                .collect(Collectors.toList()); 
                
         System.out.println("entre");
    }
    
     public void sTiposLibros() {
    Set<String> categoriasUnicas = new HashSet<>();
    listas = lista.stream()
            .filter(DatosDTO -> DatosDTO.getCategorial().equals(getCategorial()))
            .filter(DatosDTO -> categoriasUnicas.add(DatosDTO.getCategorial()))
            .collect(Collectors.toList());
}
 


    /**
     * @return the idPrestamo
     */
    public long getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
    
    /**
     * @return the listas
     */
    public List<DatosDTO> getListas() {
        return listas;
    }

    /**
     * @param listas the listas to set
     */
    public void setListas(List<DatosDTO> listas) {
        this.listas = listas;
    }

    /**
     * @return the listaa
     */
    public List<DatosDTO> getListaa() {
        return listaa;
    }

    /**
     * @param listaa the listaa to set
     */
    public void setListaa(List<DatosDTO> listaa) {
        this.listaa = listaa;
    }


    /**
     * @return the idl
     */
    public long getIdl() {
        return idl;
    }

    /**
     * @param idl the idl to set
     */
    public void setIdl(long idl) {
        this.idl = idl;
    }

    /**
     * @return the Eslibro
     */
    public String getEslibro() {
        return Eslibro;
    }

    /**
     * @param Eslibro the Eslibro to set
     */
    public void setEslibro(String Eslibro) {
        this.Eslibro = Eslibro;
    }

    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<DatosDTO> getLista() {
        return lista;
    }

    public void setLista(List<DatosDTO> lista) {
        this.lista = lista;
    }

    /**
     * @return the idl
     */
    /**
     * @return the nombrel
     */
    public String getNombrel() {
        return nombrel;
    }

    /**
     * @param nombrel the nombrel to set
     */
    public void setNombrel(String nombrel) {
        this.nombrel = nombrel;
    }

    /**
     * @return the categorial
     */
    public String getCategorial() {
        return categorial;
    }

    /**
     * @param categorial the categorial to set
     */
    public void setCategorial(String categorial) {
        this.categorial = categorial;
    }

    /**
     * @return the aniol
     */
    public String getAniol() {
        return aniol;
    }

    /**
     * @param aniol the aniol to set
     */
    public void setAniol(String aniol) {
        this.aniol = aniol;
    }

    /**
     * @return the editoriall
     */
    public String getEditoriall() {
        return editoriall;
    }

    /**
     * @param editoriall the editoriall to set
     */
    public void setEditoriall(String editoriall) {
        this.editoriall = editoriall;
    }

    /**
     * @return the nombreAutorl
     */
    public String getNombreAutorl() {
        return nombreAutorl;
    }

    /**
     * @param nombreAutorl the nombreAutorl to set
     */
    public void setNombreAutorl(String nombreAutorl) {
        this.nombreAutorl = nombreAutorl;
    }

    /**
     * @return the estadol
     */
    public String getEstadol() {
        return estadol;
    }

    /**
     * @param estadol the estadol to set
     */
    public void setEstadol(String estadol) {
        this.estadol = estadol;
    }
}
