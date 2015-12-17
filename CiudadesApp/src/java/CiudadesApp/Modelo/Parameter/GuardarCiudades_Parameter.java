/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Parameter;

import CiudadesApp.Servlets.GuardarCiudad;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author inftel06
 */
public class GuardarCiudades_Parameter {

    String descripcion;
    String nombreCiudad;
    byte[] foto;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public GuardarCiudades_Parameter(HttpServletRequest request) {

        try {
            request.setCharacterEncoding("UTF-8");
            
            nombreCiudad = (String) request.getParameter("nombreCiudad");
            descripcion = (String) request.getParameter("descripcion");
            Part filePart = request.getPart("fileName");
            InputStream in = filePart.getInputStream();
            foto = IOUtils.toByteArray(in);
            
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GuardarCiudades_Parameter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GuardarCiudades_Parameter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(GuardarCiudades_Parameter.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
