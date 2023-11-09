package com.example.design_pattern.proxy;

public class Proxy implements IService {

    IService iService;

    @Override
    public String runSomething() {
        System.out.println("호출에 대해 반환 결과를 그대로 전달");

        iService = new Service();
        return iService.runSomething();
    }
}
