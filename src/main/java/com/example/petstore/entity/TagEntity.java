package com.example.petstore.entity;

import lombok.Data;

@Data
public final class TagEntity { // Create a new DTO class for the tags
    private long id;
    private String name;
}
