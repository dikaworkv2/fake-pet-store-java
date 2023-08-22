package com.example.petstore.repository.pet;

import com.example.petstore.entity.PetEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public final class PetRepository implements PetRepositoryInterface {
    private final String baseURL = "https://petstore.swagger.io/v2";
    private final RestTemplate restTemplate;

    public PetRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PetEntity getPetByID(int petID) {
        return null;
    }

    @Override
    public PetEntity insertNewPet(PetEntity pet) {
        return null;
    }
}
