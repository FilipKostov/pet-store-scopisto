package com.applicationfilip.petstore.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private float budget;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    public User()
    {}

    public User(String firstName, String lastName, String email, float budget)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public float getBudget()
    {
        return budget;
    }
    public void setBudget(float budget)
    {
        this.budget = budget;
    }
    public List<Pet> getPets()
    {
        return pets;
    }
    public void setPets(List<Pet> pets)
    {
        this.pets = pets;
    }
}
