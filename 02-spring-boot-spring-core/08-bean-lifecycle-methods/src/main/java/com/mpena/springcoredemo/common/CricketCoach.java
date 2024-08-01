package com.mpena.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("In doMyStartUpStuff" + getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling 15 min :)";
    }
}
