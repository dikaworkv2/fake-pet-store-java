package com.example.petstore.controller.pet;
import com.example.petstore.entity.PetEntity;
import com.example.petstore.factory.header.RequestFactory;
import com.example.petstore.repository.pet.PetRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public final class PetController {

    private final RestTemplate restTemplate;
    private final PetRepositoryInterface petrepo;

    private final String baseURL = "https://petstore.swagger.io/v2";
    private static final Logger logger = LoggerFactory.getLogger(PetController.class);

    @Autowired
    public PetController(RestTemplate restTemplate, PetRepositoryInterface petrepo) {
        this.restTemplate = restTemplate;
        this.petrepo = petrepo;
    }

    @GetMapping("/hello")
    public String GetHello() {
        return "hello, world!";
    }

    @GetMapping("/pet/{petID}")
    public ResponseEntity<PetEntity> getPetByID(@PathVariable long petID) {
        String newURl = baseURL + "/pet/" + petID;
        RequestEntity req = RequestFactory.shared.createRequest(HttpMethod.GET, newURl, null);
        try {
            ResponseEntity resp = restTemplate.exchange(req, PetEntity.class);
            logger.info("pet found");
            return resp;
        } catch (RestClientException e) {
            logger.warn("Error while making the API request: " + e.getMessage());
            throw new PetNotFoundException("pet not found");
        } catch (Exception e) {
            logger.error("Error : " + e.getMessage());
            throw new BadRequestException("Bad request");
        }
    }

    @PostMapping("/pet")
    public ResponseEntity<PetEntity> AddNewPet(@RequestBody PetEntity reqBody) {
        String newURl = baseURL + "/pet";
        RequestEntity req = RequestFactory.shared.createRequest(HttpMethod.POST, newURl, reqBody);
        try {
            ResponseEntity resp = restTemplate.exchange(req, PetEntity.class);
            logger.info("success add pet");
            return  resp;
        } catch (RestClientException e) {
            logger.warn("Error while making the API request: " + e.getMessage());
            throw new PetIsNotInserted("cannot insert pet");
        } catch (Exception e) {
            logger.error("Error : " + e.getMessage());
            throw new BadRequestException("Bad request");
        }
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

    @ExceptionHandler(PetIsNotInserted.class)
    public ResponseEntity<String> handlePetIsNotInsertedExecption(PetIsNotInserted ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    public static class PetIsNotInserted extends  RuntimeException {
        public PetIsNotInserted(String message) { super(message);}
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> BadRequestExceptionHandler(PetIsNotInserted ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }
}
