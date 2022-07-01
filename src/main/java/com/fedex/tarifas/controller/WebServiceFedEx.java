package com.fedex.tarifas.controller;

import com.fedex.tarifas.entity.QuoteParams;
import com.fedex.tarifas.service.WebServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping("/arifas")
public class WebServiceFedEx {
    @Autowired
    private WebServService webServService;
    @PostMapping("/request")
    public ResponseEntity<String> request(@RequestBody QuoteParams quoteParams){
        return new ResponseEntity<>(webServService.request(quoteParams), HttpStatus.OK);
    }
}
