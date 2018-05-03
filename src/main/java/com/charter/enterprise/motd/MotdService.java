package com.charter.enterprise.motd;

import org.springframework.stereotype.Service;

/**
 * This service handles the message of the day 
 * 
 * @author AJ Johnson
 */
@Service
public class MotdService {

    // Use default message value 
    private String messageOfTheDay = "Welcome to Charter.  All systems are nominal.";

    public String getMessageOfTheDay() {
        return messageOfTheDay;
    }

    public void setMessageOfTheDay(String messageOfTheDay) {
        this.messageOfTheDay = messageOfTheDay;
    }

}
