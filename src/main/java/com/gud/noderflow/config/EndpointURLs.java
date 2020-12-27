package com.gud.noderflow.config;

public class EndpointURLs {

    //Versioning
    public static final String VERSION_1 = "/v1";
    public static final String CURRENT_VERSION = VERSION_1;

    //Root
    public static final String ROOT = "/api";
    public static final String BULK = "/bulk-create";

    //Endpoints
    public static final String USERS = ROOT + "/users";
    public static final String BALANCES = ROOT + "/balances";
    public static final String FLOW = ROOT + "/flow";
    public static final String START = "/start";
    public static final String STOP = "/stop";
    public static final String BULK_CREATE_USERS = ROOT + BULK + "/users";


    public static String getUrls(){
        return String.join("\n",
                USERS,
                BULK_CREATE_USERS
        );
    }

}
