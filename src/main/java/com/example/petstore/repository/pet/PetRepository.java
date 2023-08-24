package com.example.petstore.repository.pet;

import com.example.petstore.entity.PetEntity;
import com.example.petstore.factory.header.RequestFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
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
    public PetEntity getPetByID(int petID) throws Exception {
        String newURl = baseURL + "/pet/" + petID;
        RequestEntity req = RequestFactory.shared.createRequest(HttpMethod.GET, newURl, null);

        return new PetEntity(

        );
    }

    @Override
    public PetEntity insertNewPet(PetEntity pet)  throws Exception {
        return null;
    }
}
