package com.applicationfilip.petstore.model;

//import com.applicationfilip.petstore.model.Pet;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Pet
{
    private int rating;

    @Override
    public float getPrice()
    {
        return (getAge() + rating);
    }

    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
}
