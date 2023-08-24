package com.example.petstore.repository.pet;

import com.example.petstore.entity.PetEntity;

public interface PetRepositoryInterface {
    PetEntity getPetByID(int petID)  throws Exception;
    PetEntity insertNewPet(PetEntity pet)  throws Exception;
}
