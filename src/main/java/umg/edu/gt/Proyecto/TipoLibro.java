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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 * @author DEBORA GARCIA
 */

@ManagedBean(name = "selecLibro")
public class TipoLibro implements Serializable {
    
    private List<DatosDTO> lista;
    private int Id;
    private String nombre;
    private String categoria;
    private String año_publicacion;
    private String editorial;
    private String nombre_autor;
    private String estado_libro;
    ConsultasDAO consulta = new ConsultasDAO();
    ConexionDAO con = new ConexionDAO();
    
   

    public List<DatosDTO> getLista() {
        return lista;
    }

    public void setLista(List<DatosDTO> lista) {
        this.lista = lista;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(String año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getEstado_libro() {
        return estado_libro;
    }

    public void setEstado_libro(String estado_libro) {
        this.estado_libro = estado_libro;
    }

     
}
