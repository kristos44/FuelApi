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
        return getFileContent(feedFileStatic);
    }

    @GetMapping(path = "/dynamic/{countryCode}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getDynamicResponse(@PathVariable String countryCode) {
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
}
