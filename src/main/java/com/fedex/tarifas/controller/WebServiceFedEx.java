package com.fedex.tarifas.controller;

import com.fedex.tarifas.entity.QuoteParams;
import com.fedex.tarifas.service.ResponseService;
import com.fedex.tarifas.service.WebServService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarifas")
public class WebServiceFedEx {
    @Autowired
    private WebServService webServService;
    @Autowired
    private ResponseService responseService;
    @PostMapping("/request")
    public ResponseEntity<String> request(@RequestBody QuoteParams quoteParams){
        JSONArray array = webServService.request(quoteParams);
        String arrayString = array.toString();
        return new ResponseEntity<>(arrayString,HttpStatus.OK);
    }
}
