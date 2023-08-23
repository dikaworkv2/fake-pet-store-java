package com.example.petstore.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PetEntity {
    private long id;
    private CategoryEntity category;
    private String name;
    private String[] photoUrls;
    private TagEntity[] tags;
    private String status;
}
