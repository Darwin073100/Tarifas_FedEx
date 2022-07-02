package com.fedex.tarifas.service;

import com.fedex.tarifas.entity.Tarifa;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResponseService {
    private Tarifa tarifa;
    public JSONArray llenarTarifa(JSONObject json){
       float DOLLAR = 20.26f;
       JSONArray arr = json.getJSONObject("RateReply").getJSONArray("RateReplyDetails");
       String OP1= "FEDEX_EXPRESS_SAVER";
       String OP2= "STANDARD_OVERNIGHT";
       String name1 = null;
        String name2 = null;
        JSONArray array = new JSONArray();
       JSONObject resp = new JSONObject();
        JSONObject resp1 = new JSONObject();
        JSONObject servLev1 = new JSONObject();
        JSONObject servLev2 = new JSONObject();
        String token1;
        String token2;
        JSONArray arrPrice1;
        JSONArray arrPrice2;

           token1 = arr.getJSONObject(1).getString("ServiceType");
           token2 = arr.getJSONObject(2).getString("ServiceType");
           arrPrice1 = arr.getJSONObject(0).getJSONArray("RatedShipmentDetails");
        arrPrice2 = arr.getJSONObject(1).getJSONArray("RatedShipmentDetails");
           float price1 = DOLLAR * ((float) arrPrice1.getJSONObject(0).getJSONObject("ShipmentRateDetail").getJSONObject("TotalBaseCharge")
                   .getDouble("Amount"));
        float price2 = DOLLAR * ((float) arrPrice2.getJSONObject(0).getJSONObject("ShipmentRateDetail").getJSONObject("TotalBaseCharge")
                .getDouble("Amount"));
           String currency = "MXN";
           String jsonn = json.toString();
           System.out.println(name1 + " " + token1 + " " + price1 + " " + currency+ " ");
               name1 = "Fedex Express Saver";
               name2 = "Standard Overnight";


               servLev1.put("name",name1);
               servLev1.put("token",token1);
               resp.put("price",price1);
               resp.put("currency",currency);
               resp.put("service_level",servLev1);
               array.put(resp);
               servLev2.put("name",name2);
               servLev2.put("token",token2);
               resp1.put("price",price2);
               resp1.put("currency",currency);
               resp1.put("service_level",servLev2);
               array.put(1,resp1);

        System.out.println(array.toString());
       return array;
   }
}
