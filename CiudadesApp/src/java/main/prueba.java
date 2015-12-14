package main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author inftel08
 */
public class prueba {
    
    
    
    public static void main (String[] args) {
        OpenWeatherMap oc = new OpenWeatherMap("");
        
        oc.setApiKey("d05638724c60088ab81382441f4e8586");
        oc.setUnits(OpenWeatherMap.Units.METRIC);
        oc.setLang(OpenWeatherMap.Language.SPANISH);
        
        try {
            
            CurrentWeather y = oc.currentWeatherByCityName("Nueva York");

            System.out.println(y.getCityName() + " " + y.getMainInstance().getTemperature() + " " + y.getMainInstance().getHumidity() );
        } catch (IOException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
