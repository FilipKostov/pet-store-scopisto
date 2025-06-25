package com.applicationfilip.petstore.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Pet
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String birthDate;

    @ManyToOne
    private User owner;

    public abstract float getPrice();

    public int getAge() {
        String[] pom = birthDate.split("\\.");
        int year = Integer.parseInt(pom[2]);
        int month = Integer.parseInt(pom[1]);
        int day = Integer.parseInt(pom[0]);
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentMonth = today.getMonthValue();
        int currentDay = today.getDayOfMonth();
        int age = currentYear - year;
        if (currentMonth < month || (currentMonth == month && currentDay < month))
        {
            age--;
        }
        return age;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getBirthDate()
    {
        return birthDate;
    }
    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }
    public User getOwner()
    {
        return owner;
    }
    public void setOwner(User owner)
    {
        this.owner = owner;
    }
}

