package com.aeo.cms.service;

import com.aeo.cms.db.PropertyEditorRepo;
import com.aeo.cms.model.PropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyEditorService {

    @Autowired
    PropertyEditorRepo PropEditorRepo;
    public String createUpdate(PropertyEditor propEditor){
        PropertyEditor propertyEditor = PropEditorRepo.save(propEditor);
        return propertyEditor.toString();
    }

    public void delete(String Id){
        PropEditorRepo.deleteById(Id);
    }

}
