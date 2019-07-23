package com.example.ttapiplaceholder.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/fuel/v1.0/bulk")
public class PlaceholderController {
    @Value("${feedFile.static}")
    private String feedFileStatic;
    @Value("${feedFile.dynamic}")
    private String feedFileDynamic;

    @GetMapping(path = "/static/{countryCode}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getStaticResponse(@PathVariable String countryCode) {
//        String file ="/home/krzysztof/zadanie_tt/StaticFeed-" + countryCode + ".json";
//
//        return readFromFile(file);

//        String staticResponse = "";
//
//
//        try {
//            staticResponse = IOUtils.toString(
//                    this.getClass().getResourceAsStream(feedFileStatic), "UTF-8"
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return staticResponse;

        return getFileContent(feedFileStatic);
    }

    @GetMapping(path = "/dynamic/{countryCode}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getDynamicResponse(@PathVariable String countryCode) {
//        String file ="/home/krzysztof/zadanie_tt/DynamicFeed-" + countryCode + ".json";
//
//        return readFromFile(file);
//        String dynamicResponse = "";
//
//        try {
//            dynamicResponse = IOUtils.toString(
//                    this.getClass().getResourceAsStream(feedFileDynamic), "UTF-8"
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return dynamicResponse;

        return getFileContent(feedFileDynamic);
    }

    private String getFileContent(String file) {
        String response = "";

        try {
            response = IOUtils.toString(
                    this.getClass().getResourceAsStream(file), "UTF-8"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

//    private String readFromFile(String file) {
//        String result = "";
//
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            StringBuilder builder = new StringBuilder();
//            String currentLine = reader.readLine();
//            while (currentLine != null) {
//                builder.append(currentLine);
//                currentLine = reader.readLine();
//            }
//
//            result = builder.toString();
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
}
