package com.javid.springframework.sfgdi;

import com.javid.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javid.springframework.services", "com.javid.springframework.sfgdi"})
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

        MyController myController = (MyController) context.getBean("myController");
        log("Primary", myController.sayHello());

        log("Property", context.getBean(PropertyInjectedController.class).getGreeting());
        log("Setter", context.getBean(SetterInjectedController.class).getGreeting());
        log("Constructor", context.getBean(ConstructorInjectedController.class).getGreeting());
        log("@Profile", context.getBean(I18nController.class).sayHello());
        log("Pet Controller", context.getBean(PetController.class).whichPetIsTheBest());
    }

    private static void log(String title, String log) {
        String splitter = "--------------";
        System.out.printf("%n%s %s %s%n%s%n", splitter, title, splitter, log);
    }
}
