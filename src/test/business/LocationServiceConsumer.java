/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.business;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.beans.Locations;

/**
 *
 * @author aragab
 */
public class LocationServiceConsumer {

    TypeReference<ArrayList<Locations>> typeRef;
    URL serviceContent;
    // Making props parameter static would allow reading values once from the property file
    // but this compete the value out of making the service URL read from the property file to allow changing it at runtime
    // without the need of recompile or redeploy
    ResourceBundle props;

    public List<Locations> readLocations(String city) {

        typeRef = new TypeReference<ArrayList<Locations>>() {
        };

        try {

             props =  ResourceBundle.getBundle ("test.properties.DynamicProperties");
           
            
            String serviceURL = props.getString("locationSerivce");
            serviceURL = serviceURL.concat(city);

            serviceContent = new URL(serviceURL);
            List<Locations> cities = new ObjectMapper().readValue(serviceContent, typeRef);
            

            return cities;
        } catch (MalformedURLException ex) {
            Logger.getLogger(LocationServiceConsumer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(LocationServiceConsumer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return null;
    }

}
