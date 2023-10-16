/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DatosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wilmer de Mata
 */
public class ConsultasDAO {
    ConexionDAO con = new ConexionDAO();
     //metodo para enviar libros a la BD
    
    public void ingresarLibros(long idl, String nombrel, String categorial, String aniol, 
            String editoriall, String nombreAutorl, String estado) throws Exception {

        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO Libro (id,nombre, categoria, Año_publicacion,"
                + " editorial, nombre_autor, estado_libro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                //PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
                //preparedStatement.setString(1, "");      
                preparedStatement.setLong(1, idl);
                preparedStatement.setString(2, nombrel);
                preparedStatement.setString(3, categorial);
                preparedStatement.setString(4, aniol);
                preparedStatement.setString(5, editoriall);
                preparedStatement.setString(6, nombreAutorl);
                preparedStatement.setString(7, estado);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
    
      //mandar a llamar los libros
    public List<DatosDTO> findAllLibros() {
        List<DatosDTO> ListaLibros = new ArrayList<DatosDTO>();

        try {
            String query = "SELECT id, nombre, categoria, Año_publicacion, editorial, nombre_autor, estado_libro FROM Libro";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setIdl(r.getLong("id"));
                dato.setNombrel(r.getString("nombre"));
                dato.setCategorial(r.getString("categoria"));
                dato.setAniol(r.getString("Año_publicacion"));
                dato.setEditoriall(r.getString("editorial"));
                dato.setNombreAutorl(r.getString("nombre_autor"));
                dato.setOpcionSeleccionada(r.getString("estado_libro"));
                ListaLibros.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta"+e);
        }

        System.out.println("El tamaño de la lista es" + ListaLibros.size());
        //System.out.println("nombre lista );
        return ListaLibros;
    }
    
        //metodo para actualizar usuarios a bd
    public void actualizarLibros(long id, String nombre, String categoria, String Año_publicacion, String editorial, String nombre_autor, String estado_libro) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        StringBuilder consultaSQL = new StringBuilder("UPDATE libro SET ");
        if (conexion != null) {
            try {
                // Verifica y agrega campos a la consulta SQL si se proporciona un valor no nulo o no vacío
                if (nombre != null && !nombre.isEmpty()) {
                    consultaSQL.append("nombre = ?, ");
                }
                if (categoria != null && !categoria.isEmpty()) {
                    consultaSQL.append("categoria = ?, ");
                }
                if (Año_publicacion != null && !Año_publicacion.isEmpty()) {
                    consultaSQL.append("Año_publicacion = ?, ");
                }
                if (editorial != null && !editorial.isEmpty()) {
                    consultaSQL.append("editorial = ?, ");
                }
                if (nombre_autor != null && !nombre_autor.isEmpty()) {
                    consultaSQL.append("nombre_autor = ?, ");
                }
                if (estado_libro != null && !estado_libro.isEmpty()) {
                    consultaSQL.append("estado_libro = ?, ");
                }

                // Elimina la coma final y agrega la condición WHERE
                consultaSQL.delete(consultaSQL.length() - 2, consultaSQL.length()).append(" WHERE id = ?");
                preparedStatement = conexion.prepareStatement(consultaSQL.toString());
                int parametroIndex = 1;

                // Establece los parámetros en la consulta SQL según los valores no nulos o no vacíos proporcionados
                if (nombre != null && !nombre.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, nombre);
                }
                if (categoria != null && !categoria.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, categoria);
                }
                if (Año_publicacion != null && !Año_publicacion.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Año_publicacion);
                }
                if (editorial != null && !editorial.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, editorial);
                }
                if (nombre_autor != null && !nombre_autor.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, nombre_autor);
                }
                if (estado_libro != null && !estado_libro.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, estado_libro);
                }

                preparedStatement.setLong(parametroIndex, id);
                preparedStatement.executeUpdate();
                System.out.println("Datos actualizados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //metodo para actualizar usuarios a bd
    public void actualizarDatos(int id, String Nombre, String Fecha_Nacimiento, String Grado_Academico, String direccion, String Estado, String Usuario, String Contraseña) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        StringBuilder consultaSQL = new StringBuilder("UPDATE usuarios SET ");
        if (conexion != null) {
            try {
                // Verifica y agrega campos a la consulta SQL si se proporciona un valor no nulo o no vacío
                if (Nombre != null && !Nombre.isEmpty()) {
                    consultaSQL.append("Nombre = ?, ");
                }
                if (Fecha_Nacimiento != null && !Fecha_Nacimiento.isEmpty()) {
                    consultaSQL.append("Fecha_Nacimiento = ?, ");
                }
                if (Grado_Academico != null && !Grado_Academico.isEmpty()) {
                    consultaSQL.append("Grado_Academico = ?, ");
                }
                if (direccion != null && !direccion.isEmpty()) {
                    consultaSQL.append("direccion = ?, ");
                }
                if (Estado != null && !Estado.isEmpty()) {
                    consultaSQL.append("Estado = ?, ");
                }
                if (Usuario != null && !Usuario.isEmpty()) {
                    consultaSQL.append("Usuario = ?, ");
                }
                if (Contraseña != null && !Contraseña.isEmpty()) {
                    consultaSQL.append("Contraseña = ?, ");
                }

                // Elimina la coma final y agrega la condición WHERE
                consultaSQL.delete(consultaSQL.length() - 2, consultaSQL.length()).append(" WHERE id = ?");
                preparedStatement = conexion.prepareStatement(consultaSQL.toString());
                int parametroIndex = 1;

                // Establece los parámetros en la consulta SQL según los valores no nulos o no vacíos proporcionados
                if (Nombre != null && !Nombre.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Nombre);
                }
                if (Fecha_Nacimiento != null && !Fecha_Nacimiento.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Fecha_Nacimiento);
                }
                if (Grado_Academico != null && !Grado_Academico.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Grado_Academico);
                }
                if (direccion != null && !direccion.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, direccion);
                }
                if (Estado != null && !Estado.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Estado);
                }
                if (Usuario != null && !Usuario.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Usuario);
                }
                if (Contraseña != null && !Contraseña.isEmpty()) {
                    preparedStatement.setString(parametroIndex++, Contraseña);
                }

                preparedStatement.setInt(parametroIndex, id);
                preparedStatement.executeUpdate();
                System.out.println("Datos actualizados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
        //metodo para consultar usuarios de la base de datos
    public List<DatosDTO> findAllCliente() {
        List<DatosDTO> Lista = new ArrayList<DatosDTO>();
        try {
            String query = "SELECT id, Nombre, Fecha_Nacimiento, Grado_Academico, direccion, Estado, Usuario, Contraseña FROM usuarios";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setId(r.getLong("id"));
                dato.setNombreUsuario(r.getString("Nombre"));
                dato.setFechaNacimiento(r.getString("Fecha_Nacimiento"));
                dato.setGradoAcademico(r.getString("Grado_Academico"));
                dato.setDireccion(r.getString("direccion"));
                dato.setEstado(r.getString("Estado"));
                dato.setUsuario(r.getString("Usuario"));
                dato.setContraseña(r.getString("Contraseña"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + Lista.size());
        //System.out.println("nombre lista );
        return Lista;
    }
    
        //metodo para consultar prestamos de la base de datos
    public List<DatosDTO> findAllPrestamo() {
        List<DatosDTO> Lista = new ArrayList<DatosDTO>();
        try {
            String query = "SELECT id, Usuario_id, Libro_id  FROM alquiler_libros";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DatosDTO dato = new DatosDTO();
                dato.setIdPrestamo(r.getLong("id"));
                dato.setId(r.getLong("Usuario_id"));
                dato.setIdl(r.getLong("Libro_id"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + Lista.size());
        //System.out.println("nombre lista );
        return Lista;
    }
     //metodo para crear un nuevo estudiante
    public void ingresarUsers(String nombre, String FechaNa, String Estudios, String direccion, String estado, String user , String contraseña ) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO usuarios (Nombre, Fecha_Nacimiento, Grado_Academico, direccion,Estado,Usuario,Contraseña) VALUES (?,?,?,?,?,?,?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, FechaNa);
                preparedStatement.setString(3, Estudios);
                preparedStatement.setString(4, direccion);
                preparedStatement.setString(5, estado);
                preparedStatement.setString(6, user);
                preparedStatement.setString(7, contraseña);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
    
        //metodo para agregar un nuevo prestamo
    public void ingresarPrestamo(int Usuario_id , long Libro_id) throws Exception {
        Connection conexion = con.conexionMysql();
        PreparedStatement preparedStatement = null;
        String consultaSQL = "INSERT INTO alquiler_libros (Usuario_id, Libro_id) VALUES (?,?)";
        if (conexion != null) {
            try {
                preparedStatement = conexion.prepareStatement(consultaSQL);
                preparedStatement.setInt(1, Usuario_id);
                preparedStatement.setLong(2, Libro_id);
                preparedStatement.executeUpdate();
                System.out.println("Datos ingresados correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
    
    //actualizar libro
    public void actualizarEstadoLibro(long id, String estado_libro) throws Exception {
    Connection conexion = con.conexionMysql();
    PreparedStatement preparedStatement = null;
    String consultaSQL = "UPDATE libro SET estado_libro = ? WHERE id = ?";
    if (conexion != null) {
        try {
            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, estado_libro);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Datos actualizados correctamente.");
        } catch (SQLException e) {
            System.out.println("no se actulizo libro");
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        System.out.println("No se pudo establecer la conexión.");
    }
}
}
