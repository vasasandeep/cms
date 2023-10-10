package com.aeo.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.context.annotation.Primary;

@Entity(name = "propertyeditor")
public class PropertyEditor {

    @Id
    String id;
    String type;
    String editor;
    String isMultipleApplicable;
}

