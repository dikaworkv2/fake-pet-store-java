package com.example.petstore.controller.spawner;

public class SpawnerRepo {
    public static SpawnerRepo shared = new SpawnerRepo();

    public String getMessage() {
        double desrtoy = 0/0;
        return "Hello Destroy!";
    }
}
