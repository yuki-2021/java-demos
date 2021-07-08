package com.yuki.app.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShowAllRunner implements CommandLineRunner {

    /*
    * CommandLineRunner/ApplicationRunner - 是Runner
    * */
    @Override
    public void run(String... args) throws Exception {
        // args如下
        System.out.println("---------------------args");
        System.out.println(args.length);


    }
}
