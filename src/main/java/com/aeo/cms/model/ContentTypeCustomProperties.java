package com.aeo.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "ContentTypeCustomProperties")
public class ContentTypeCustomProperties {
    @Id
    String id;
    @ManyToOne
    @JoinColumn(name="contenttypeId", referencedColumnName = "id")
    ContentTypeMetadata contenttypeId;
    String fieldSequence;
    String fieldName;
    String fieldEditor;
    boolean isRequired;
    boolean isMultiple;
}
