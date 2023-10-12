package com.aeo.cms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content-type/")
public class ContentTypeController {

    @PostMapping("/create")
    public ResponseEntity<String> create(){
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }

    @DeleteMapping("/delete")
    public String Delete(){
        return "success";
    }
}
