package com.gud.noderflow.util.fabricator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserDataFabricator {

    ArrayList<String> namesFirst ;
    ArrayList<String> namesSecond ;
    Random rand ;

    public String getFirstName(boolean complex){
        if(complex){
            return namesFirst.get(rand.nextInt(99)) + RandomStringUtils.random(10);
        }
        return namesFirst.get(rand.nextInt(99));
    }
    public String getLastName(boolean complex){

        if(complex){
            return namesSecond.get(rand.nextInt(99)) + RandomStringUtils.random(10);
        }
        return namesSecond.get(rand.nextInt(99));

    }

    @PostConstruct
    private void init(){
        try {
            namesFirst = getFileAsString("/rawdata/namesFirst.txt");
            namesSecond = getFileAsString("/rawdata/namesSecond.txt");
        }catch (IOException e){
            log.error("rawdata files namesFirst.txt or namesSecond.txt cannot be read.");
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


