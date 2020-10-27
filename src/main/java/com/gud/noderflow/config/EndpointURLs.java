package com.gud.noderflow.config;

public class EndpointURLs {

    //Versioning
    public static final String VERSION_1 = "/v1";
    public static final String CURRENT_VERSION = VERSION_1;

    //Root
    public static final String ROOT = "/api";

    //Endpoints
    public static final String USERS = ROOT + "/users";
//    public static final String TEMPLATE_ENTITIES = TEMPLATE + "/template-entities";

    public static String getUrls(){
        return String.join("\n",
                USERS
        );
    }

}
