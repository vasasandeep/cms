package com.aeo.cms.controller;

import com.aeo.cms.model.PropertyEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property-editor/")
public class PropertyEditorController {

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody PropertyEditor propEditor){

        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }
    @DeleteMapping("/delete")
    public String Delete(){
        return "success";
    }
}
