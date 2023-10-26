package com.aeo.cms.controller;

import com.aeo.cms.model.ContentTypeCustomProperties;
import com.aeo.cms.model.ContentTypeMetadata;
import com.aeo.cms.service.ContentTypeService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content-type/")
public class ContentTypeController {

    @Autowired
    ContentTypeService contentTypeService;
    @PostMapping("/create/custom-property")
    public ResponseEntity<ContentTypeCustomProperties> create(@RequestBody ContentTypeCustomProperties props){
        String contentTypeCustomProperties = contentTypeService.createCustomProperties(props);
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }

    @DeleteMapping("/delete/custom-property/{id}")
    public String deleteCustomProp(@PathVariable String id){
        contentTypeService.deleteCustomProp(id);
        return "success";
    }

    @PostMapping("/create/metadata-property")
    public ResponseEntity<String> createMetadataProp(@RequestBody ContentTypeMetadata metadata){
        contentTypeService.createMetadataProperties(metadata);
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }

    @DeleteMapping("/delete/metadata-property/{id}")
    public String deleteMetadataProp(@PathVariable String id){
        contentTypeService.deleteMetada(id);
        return "success";
    }
}
