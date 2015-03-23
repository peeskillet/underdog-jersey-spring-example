/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.underdog.jersey.spring.example.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author PaulSamsotha
 */
@Component
@Profile("production")
public class UnderdogHeaderService implements HeaderService {

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Powered-By", "Underdog");
        return headers;
    }  
}
