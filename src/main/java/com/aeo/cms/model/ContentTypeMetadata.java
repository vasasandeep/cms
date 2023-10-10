package com.aeo.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "ContentTypeMetadata")
public class ContentTypeMetadata {
    @Id
    String id;
    String type;
    String propertyeditor;
    String isReadOnly;
}
