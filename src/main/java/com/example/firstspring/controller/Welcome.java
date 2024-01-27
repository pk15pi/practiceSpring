package com.example.firstspring.controller;


import netscape.javascript.JSObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("")
public class Welcome {

    @GetMapping("/hello")
    public String s(){
        return "Hello, How Are You?";
    }

    @GetMapping("/hello/1")
    public ResponseEntity<String> first(){
        return ResponseEntity.ok("returning 200 ok");
    }

    @GetMapping("/hello/2")
    public ResponseEntity<Object> second(){
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
