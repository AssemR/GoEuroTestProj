/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.main;

import static java.lang.System.exit;
import java.util.List;
import test.beans.Locations;
import test.business.CitiesCSVWriter;
import test.business.LocationServiceConsumer;

/**
 *
 * @author aragab
 */
public class CitiyQueryMain {

    public static void main(String[] args) {

        String cityInQuestion = args[0];
        //String cityInQuestion = "Cairo";
        if (cityInQuestion == null || cityInQuestion.trim().isEmpty() || cityInQuestion.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Correct the city name, it should contain characters only!");
            exit(1);
        }
        LocationServiceConsumer service = new LocationServiceConsumer();
        CitiesCSVWriter cityWriter = new CitiesCSVWriter();
        List<Locations> locations = service.readLocations(cityInQuestion);
        if (!locations.isEmpty()) {
            String writingResult = cityWriter.writeCSVCities(locations);
            System.out.println(writingResult);
        } else {
            System.out.println("There is no city found with this name.");
        }

    }

}
