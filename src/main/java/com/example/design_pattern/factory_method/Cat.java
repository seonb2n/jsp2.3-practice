package com.example.design_pattern.factory_method;

public class Cat extends Animal {

    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
