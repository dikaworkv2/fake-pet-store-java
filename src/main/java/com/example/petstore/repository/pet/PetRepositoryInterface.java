package com.example.petstore.repository.pet;

import com.example.petstore.entity.PetEntity;

public interface PetRepositoryInterface {
    PetEntity getPetByID(int petID);
    PetEntity insertNewPet(PetEntity pet);
}
