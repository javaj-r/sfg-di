package com.javid.springframework.sfgdi.services;

import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        log(null, null, "Constructor", "LifeCycleBean has been initialized.");
    }

    private void log(String clazz, String annotated, String methodName, String msg) {
        final String splitter = String.format(
                "%n\t\t####### [ LifeCycleDemoBean%s] ####### [ %s%s] #######%n\t\t"
                , clazz == null ? " " : " impl ".concat(clazz).concat(" ")
                , methodName
                , annotated == null ? " " : " annotated by ".concat(annotated).concat(" ")
        );
        System.out.printf("%s  %s%n", splitter, msg);
    }

    // InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        log("InitializingBean", null, "afterPropertiesSet", "LifeCycleBean has its properties set!");
    }

    // DisposableBean
    @Override
    public void destroy() throws Exception {
        log("DisposableBean", null, "destroy", "Lifecycle bean has been terminated");
    }

    // BeanNameAware
    @Override
    public void setBeanName(String name) {
        log("BeanNameAware", null, "setBeanName", "Bean Name is: " + name);
    }

    // BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        log("BeanFactoryAware", null, "setBeanFactory", "Bean Factory has been set");
    }

    // ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        log("ApplicationContextAware", null, "setApplicationContext", "Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        log(null, "@PostConstruct", "postConstruct", "The @PostConstruct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        log(null, "@PreDestroy", "preDestroy", "The @PreDestroy annotated method has been called");
    }

    public void beforeInit() {
        log(null, null, "beforeInit", "Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        log(null, null, "afterInit", "After  Init - Called by Bean Post Processor");
    }
}
