package com.javid.springframework.sfgdi;

import com.javid.springframework.sfgdi.controllers.ConstructorInjectedController;
import com.javid.springframework.sfgdi.controllers.MyController;
import com.javid.springframework.sfgdi.controllers.PropertyInjectedController;
import com.javid.springframework.sfgdi.controllers.SetterInjectedController;
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
    }

    private static void log(String title, String log) {
        String splitter = "--------------";
        System.out.printf("\n%s %s %s\n%s\n", splitter, title, splitter, log);
    }
}
