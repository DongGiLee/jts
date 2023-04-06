package com.mysite.jts;

import lombok.Getter;
//import lombok.Setter;

@Getter
//@Setter
public class HelloLombok {

    private final String hello;
    private final int lombok;

    public HelloLombok(String hello, int lombok) {
        this.hello = hello;
        this.lombok = lombok;
    }

    public static void main(String[] args){
//        HelloLombok helloLombok = new HelloLombok();
//        helloLombok.setHello("헬로");
//        helloLombok.setLombok(4);

        HelloLombok helloLombok = new HelloLombok("헬로",4);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
