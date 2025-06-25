package com.applicationfilip.petstore.service;

import com.applicationfilip.petstore.model.*;
import com.applicationfilip.petstore.repository.PetRepository;
import com.applicationfilip.petstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetStoreService
{
    private final UserRepository userRepo;
    private final PetRepository petRepo;

    // ✅ Bonus: Track history log
    private final List<BuyLogEntry> buyLogs = new ArrayList<>();

    public PetStoreService(UserRepository userRepo, PetRepository petRepo)
    {
        this.userRepo = userRepo;
        this.petRepo = petRepo;
    }

    public void createRandomUsers()
    {
        for (int i = 0; i < 10; i++)
        {
            User user = new User("First Name " + i, "Last Name " + i, "email" + i + "@mail.com", 5 + i);
            userRepo.save(user);
        }
    }

    public void createRandomPets()
    {
        for (int i = 0; i < 10; i++)
        {
            Cat cat = new Cat();
            cat.setName("Cat " + i);
            cat.setDescription("Grumpy cat number " + i + " is purring.");
            cat.setBirthDate("2.2." + (2015 + i));
            petRepo.save(cat);
        }

        for (int i = 0; i < 10; i++)
        {
            Dog dog = new Dog();
            dog.setName("Dog " + i);
            dog.setDescription("Doggy number " + i + " is very good boy!");
            dog.setBirthDate("2.2." + (2015 + i));
            dog.setRating(i % 11);
            petRepo.save(dog);
        }
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }

    public List<Pet> listPets() {
        return petRepo.findAll();
    }

    public void buyPets()
    {
        List<User> users = userRepo.findAll();
        List<Pet> pets = petRepo.findAll();

        int successful = 0;
        int failed = 0;

        for (User user : users)
        {
            boolean bought = false;

            for (Pet pet : pets)
            {
                if (pet.getOwner() == null && user.getBudget() >= pet.getPrice())
                {
                    pet.setOwner(user);
                    user.setBudget(user.getBudget() - pet.getPrice());
                    userRepo.save(user);
                    petRepo.save(pet);

                    if (pet instanceof Cat)
                    {
                        System.out.println("Meow, cat " + pet.getName() + " has owner " + user.getFirstName());
                    }
                    else
                    {
                        System.out.println("Woof, dog " + pet.getName() + " has owner " + user.getFirstName());
                    }

                    bought = true;
                    break;
                }
            }

            if (bought)
                successful++;
            else
                failed++;
        }

        buyLogs.add(new BuyLogEntry(LocalDateTime.now(), successful, failed));
    }

    public List<BuyLogEntry> getBuyLogs()
    {
        return buyLogs;
    }
}