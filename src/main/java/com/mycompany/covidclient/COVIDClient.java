/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covidclient;

import com.google.gson.Gson;

/**
 *
 * @author did
 */
public class COVIDClient {
    
    String baseURL = "https://coronavirus-19-api.herokuapp.com/countries/";
    Gson gson = new Gson();
    COVIDOp cOp = new COVIDOp ();
    //Inner Class
    public class Covid {
        String country;
        int cases;
        int todayCases;
        int deaths;
        int todayDeaths;
        int recovered;
        int active;
        int critical;
        int totalTests;
    }
    //URL birleştirici
    public Covid getCovid(String countryName){
     String queryURL = baseURL + countryName;
     String json = cOp.readUrl(queryURL);
     Covid covid = gson.fromJson(json,Covid.class);
     return covid;
    }
    
}
