package com.example.design_pattern.proxy;

public class Service implements IService {

    @Override
    public String runSomething() {
        return "서비스 입니다.";
    }
}
