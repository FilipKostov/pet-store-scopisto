package com.applicationfilip.petstore.model;

//import com.applicationfilip.petstore.model.Pet;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Pet
{
    @Override
    public float getPrice()
    {
        return getAge();
    }
}

