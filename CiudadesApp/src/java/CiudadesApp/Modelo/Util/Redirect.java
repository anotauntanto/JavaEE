/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inftel08
 */
public class Redirect {
    
    public void redirect (HttpServletRequest request, HttpServletResponse response, String des) throws ServletException, IOException {
        
        request.getRequestDispatcher(des).forward(request, response);
        
    }
    
}
