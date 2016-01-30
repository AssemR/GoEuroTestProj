/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.business;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import test.beans.Locations;

/**
 *
 * @author aragab
 */
public class CitiesCSVWriter {

    String writeProcessResult;
    String outputFileName;
   // Making props parameter static would allow reading values once from the property file
    // but this compete the value out of making the service URL read from the property file to allow changing it at runtime
    // without the need of recompile or redeploy
    ResourceBundle props;

    public String writeCSVCities(List<Locations> locations) {

        try {
            props =  ResourceBundle.getBundle ("test.properties.DynamicProperties");
            outputFileName = props.getString("outputFileName");
            boolean alreadyExists = new File(outputFileName).exists();

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFileName, true), ',');

            if (!alreadyExists) {
                csvOutput.write("Id");
                csvOutput.write("Name");
                csvOutput.write("Type");
                csvOutput.write("Latitude");
                csvOutput.write("Longitude");
                csvOutput.endRecord();
            }
            for (Locations location : locations) {

                System.out.println(location.get_id());
                csvOutput.write(location.get_id());
                System.out.println(location.getName());
                csvOutput.write(location.getName());
                System.out.println(location.getType());
                csvOutput.write(location.getType());
                System.out.println(location.getGeo_position().getLatitude());
                csvOutput.write(location.getGeo_position().getLatitude());
                System.out.println(location.getGeo_position().getLongitude());
                csvOutput.write(location.getGeo_position().getLongitude());
                csvOutput.endRecord();

            }

            csvOutput.close();
            return "Success, find the output file at the same directory your run the JAR from!";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Failed!";
    }

}
