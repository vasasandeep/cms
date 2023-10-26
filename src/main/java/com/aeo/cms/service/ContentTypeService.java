package com.aeo.cms.service;

import com.aeo.cms.db.ContentTypeCustomPropertiesRepo;
import com.aeo.cms.db.ContentTypeMetadataRepo;
import com.aeo.cms.model.ContentTypeCustomProperties;
import com.aeo.cms.model.ContentTypeMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentTypeService {

    @Autowired
    ContentTypeCustomPropertiesRepo customPropertiesRepo;

    @Autowired
    ContentTypeMetadataRepo metadataRepo;
    public String createCustomProperties(ContentTypeCustomProperties props){
        customPropertiesRepo.save(props);
        return props.toString();
    }

    public String createMetadataProperties(ContentTypeMetadata metadata){
        metadataRepo.save(metadata);
        return metadata.toString();
    }

    public void deleteCustomProp(String id){
        customPropertiesRepo.deleteById(id);
    }

    public void  deleteMetada(String id){
        metadataRepo.deleteById(id);
    }
}
