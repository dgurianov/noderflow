package com.gud.noderflow.fabricator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Component("address-data-fabricator")
public class AddressDataFabricator {

    ArrayList<String> cities ;
    ArrayList<String> countries ;
    ArrayList<String> streets ;
    Random rand ;

    public String getCity(){
        return cities.get(rand.nextInt(99));
    }

    public String getCountry(){
        return countries.get(rand.nextInt(99)) ;
    }
    public String getStreet(){
        return streets.get(rand.nextInt(1031));
    }

    public String getApartment(){
        return Integer.toString(rand.nextInt(50));
    }

    @PostConstruct
    private void init(){
        try {
            cities = getFileAsString("/rawdata/cities.txt");
            countries = getFileAsString("/rawdata/countries.txt");
            streets = getFileAsString("/rawdata/streets.txt");
        }catch (IOException e){
            log.error("rawdata files cities.txt or countries.txt streets.txt cannot be read.");
        }
        rand = new Random();
    }

    private ArrayList<String> getFileAsString(String name) throws IOException {
        try (final BufferedReader inputData = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream(name)))) {
            return new ArrayList<String>(inputData.lines().collect(Collectors.toList()));
        }
    }

}
