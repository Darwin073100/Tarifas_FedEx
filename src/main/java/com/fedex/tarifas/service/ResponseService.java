package com.fedex.tarifas.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;

@Service
public class ResponseService {

    public JSONArray llenarTarifa(JSONObject json){
       float DOLLAR = 20.26f;
       JSONArray arr = json.getJSONObject("RateReply").getJSONArray("RateReplyDetails");
       String OP1= "FEDEX_EXPRESS_SAVER";
       String OP2= "STANDARD_OVERNIGHT";
       String name = null;
        JSONArray array = new JSONArray();
       JSONObject resp = new JSONObject();
        JSONObject servLev = new JSONObject();
        String token;
        JSONArray arrPrice;
       for ( int i = 0; i < arr.length(); i++) {
           token = arr.getJSONObject(i).getString("ServiceType");

           arrPrice = arr.getJSONObject(i).getJSONArray("RatedShipmentDetails");
           float price = DOLLAR * ((float) arrPrice.getJSONObject(0).getJSONObject("ShipmentRateDetail").getJSONObject("TotalBaseCharge")
                   .getDouble("Amount"));
           String currency = "MXN";
           String jsonn = json.toString();
           System.out.println(name + " " + token + " " + price + " " + currency+ " " +i);
           if (token.equals(OP1)) {
               name = "Fedex Express Saver";
           } else if (token.equals(OP2)) {
               name = "Standard Overnight";
           }

           servLev.put("name",name);
           servLev.put("token",token);
           resp.put("price",price);
           resp.put("currency",currency);
           resp.put("service_level",servLev);
           array.put(i,resp);

           System.out.println(array.toString());
       }
        System.out.println(array.toString());
       return array;
   }
}
