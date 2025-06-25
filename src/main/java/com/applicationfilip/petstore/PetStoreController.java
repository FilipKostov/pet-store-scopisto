package com.applicationfilip.petstore;

import com.applicationfilip.petstore.model.BuyLogEntry;
import org.springframework.web.bind.annotation.*;
import com.applicationfilip.petstore.service.PetStoreService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PetStoreController
{
    private final PetStoreService service;

    public PetStoreController(PetStoreService service)
    {
        this.service = service;
    }

    @PostMapping("/create-users")
    public void createUsers()
    {
        service.createRandomUsers();
    }

    @PostMapping("/create-pets")
    public void createPets()
    {
        service.createRandomPets();
    }

    @GetMapping("/list-users")
    public List<?> listUsers()
    {
        return service.listUsers();
    }

    @GetMapping("/list-pets")
    public List<?> listPets()
    {
        return service.listPets();
    }

    @PostMapping("/buy")
    public void buyPets()
    {
        service.buyPets();
    }
    @GetMapping("/buy-history")
    public List<BuyLogEntry> getBuyHistory() {
        return service.getBuyLogs();
    }
}

