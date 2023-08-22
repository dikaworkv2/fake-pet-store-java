package com.example.petstore.controller.pet;
import com.example.petstore.entity.PetEntity;
import com.example.petstore.repository.pet.PetRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public final class PetController {
    private final PetRepositoryInterface petRepo;

    public PetController( PetRepositoryInterface petRepo) {
        this.petRepo = petRepo;
    }

    @GetMapping("/hello")
    public String GetHello() {
        return "hello, world!";
    }

    @GetMapping("/pet/{petID}")
    public String getPetByID(@PathVariable int petID) {
        return "berhasil bro";
    }

    @PostMapping("/pet")
    public String AddNewPet(@RequestBody PetEntity pet) {
        PetEntity newPet = this.petRepo.insertNewPet(pet);
        return "";
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<String> handlePetNotFoundException(PetNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    public static class PetNotFoundException extends RuntimeException {
        public PetNotFoundException(String message) {
            super(message);
        }
    }
}
