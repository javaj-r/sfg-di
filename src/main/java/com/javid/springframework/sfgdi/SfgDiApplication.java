package com.javid.springframework.sfgdi;

import com.javid.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

        MyController myController = (MyController) context.getBean("myController");
        log("Primary", myController.sayHello());


        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
        log("Property", propertyInjectedController.getGreeting());

        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        log("Setter", setterInjectedController.getGreeting());

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        log("Constructor", constructorInjectedController.getGreeting());


        I18nController i18nController = (I18nController) context.getBean("i18nController");
        log("@Profile", i18nController.sayHello());

        PetController petController = (PetController) context.getBean("petController");
        log("Pet Controller", petController.whichPetIsTheBest());
    }

    private static void log(String title, String log) {
        String splitter = "--------------";
        System.out.printf("%n%s %s %s%n%s%n", splitter, title, splitter, log);
    }
}
