package com.gud.noderflow.fabricator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component("contacts-data-fabricator")
public class UserContactsFabricator {

        public String getPhone(){
            return "+"+ RandomStringUtils.randomNumeric(3)+" "+RandomStringUtils.randomNumeric(7);
        }
        public String getSocialNetworkProfile(){
            return "http://fakebook.mom/userID?"+RandomStringUtils.randomNumeric(6);
        }

    }

