package com.example.design_pattern.factory_method;

public class Dog extends Animal {

    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}
