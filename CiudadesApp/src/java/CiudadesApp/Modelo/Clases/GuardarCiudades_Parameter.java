/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Clases;

import CiudadesApp.Servlets.GuardarCiudad;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

    
    
    public GuardarCiudades_Parameter(HttpServletRequest request, ServletContext context) {
        
        try {
            
            FileItemFactory factory = new DiskFileItemFactory();
            File repository = (File)context.getAttribute("javax.servlet.context.tempdir");
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            byte[] img = null;
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    //System.out.println(item.getString());
                    img = item.get();
        
                    

                }
            }
            
            foto = img;
            nombreCiudad = "Nombre";
            descripcion = "Descripcion";
            
            
            
        } catch (FileUploadException ex) {
            Logger.getLogger(GuardarCiudades_Parameter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
}
