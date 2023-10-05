package com.example.petstore.controller.spawner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SpawnerController {
    private static final Logger logger = LoggerFactory.getLogger(SpawnerController.class);

    @GetMapping("/spawn/info")
    public String spawnLogInfo() {
        logger.info("spawn info");
        return "success";
    }

    @GetMapping("/spawn/warn")
    public String spawnLogWarn() {
        logger.warn("spawn warn");
        return "success";
    }

    @GetMapping("/spawn/error")
    public String spawnLogError() {
        logger.error("spawn error");
        return "success";
    }

    @GetMapping("/spawn/debug")
    public String spawnLogDebug() {
        logger.debug("spawn debug");
        return "success";
    }

    @GetMapping("/spawn/destroy")
    public String spawnDestroy() {
       return SpawnerRepo.shared.getMessage();
    }
}
