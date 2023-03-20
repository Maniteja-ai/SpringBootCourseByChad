package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println(" In " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "play tennnis for 5min";
    }
}
