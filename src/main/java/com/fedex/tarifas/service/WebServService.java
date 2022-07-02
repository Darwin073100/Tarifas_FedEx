package com.fedex.tarifas.service;
import com.fedex.tarifas.entity.QuoteParams;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class WebServService{
    @Autowired
    private ResponseService responseService;
    public JSONArray  request(QuoteParams quoteParams){
        final String xml = "<RateRequest xmlns=\"http://fedex.com/ws/rate/v13\">"+
                "<WebAuthenticationDetail>"+
                "<UserCredential>"+
                "<Key>bkjIgUhxdghtLw9L</Key>"+
                "<Password>6p8oOccHmDwuJZCyJs44wQ0Iw</Password>"+
                "</UserCredential>"+
                "</WebAuthenticationDetail>"+
                "<ClientDetail>"+
                "<AccountNumber>510087720</AccountNumber>"+
                "<MeterNumber>119238439</MeterNumber>"+
                "<Localization>"+
                "<LanguageCode>es</LanguageCode>"+
                "<LocaleCode>mx</LocaleCode>"+
                "</Localization>"+
                "</ClientDetail>"+
                "<Version>"+
                "<ServiceId>crs</ServiceId>"+
                "<Major>13</Major>"+
                " <Intermediate>0</Intermediate>"+
                "<Minor>0</Minor>"+
                " </Version>"+
                " <ReturnTransitAndCommit>true</ReturnTransitAndCommit>"+
                "<RequestedShipment>"+
                " <DropoffType>REGULAR_PICKUP</DropoffType>"+
                " <PackagingType>YOUR_PACKAGING</PackagingType>"+
                "<Shipper>"+
                "<Address>"+
                " <StreetLines></StreetLines>"+
                "<City></City>"+
                "<StateOrProvinceCode>XX</StateOrProvinceCode>"+
                "<PostalCode>"+quoteParams.getAddressFrom().getZip()+"</PostalCode>"+
                "<CountryCode>"+quoteParams.getAddressFrom().getCountry()+"</CountryCode>"+
                "</Address>"+
                "</Shipper>"+
                "<Recipient>"+
                "<Address>"+
                "<StreetLines></StreetLines>"+
                "<City></City>"+
                " <StateOrProvinceCode>XX</StateOrProvinceCode>"+
                "<PostalCode>"+quoteParams.getAddressTo().getZip()+"</PostalCode>"+
                "<CountryCode>"+quoteParams.getAddressTo().getCountry()+"</CountryCode>"+
                "<Residential>false</Residential>"+
                "</Address>"+
                "</Recipient>"+
                "<ShippingChargesPayment>"+
                "<PaymentType>SENDER</PaymentType>"+
                "</ShippingChargesPayment>"+
                "<RateRequestTypes>ACCOUNT</RateRequestTypes>"+
                "<PackageCount>1</PackageCount>"+
                "<RequestedPackageLineItems>"+
                "<GroupPackageCount>1</GroupPackageCount>"+
                "<Weight>"+
                " <Units>"+quoteParams.getParcel().getMassUnit()+"</Units>"+
                "<Value>"+quoteParams.getParcel().getWeigth()+"</Value>"+
                "</Weight>"+
                "<Dimensions>"+
                "<Length>"+quoteParams.getParcel().getLength()+"</Length>"+
                "<Width>"+quoteParams.getParcel().getWidth()+"</Width>"+
                "<Height>"+quoteParams.getParcel().getHeigth()+"</Height>"+
                "<Units>"+quoteParams.getParcel().getDistanceUnit()+"</Units>"+
                "</Dimensions>"+
                "</RequestedPackageLineItems>"+
                "</RequestedShipment>"+
                "</RateRequest>";

        try {
            String url = "https://wsbeta.fedex.com:443/xml";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            String body = xml.toString();
            wr.writeBytes(body);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject json = XML.toJSONObject(response.toString());
            return responseService.llenarTarifa(json);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
