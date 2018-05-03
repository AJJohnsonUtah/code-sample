package com.charter.enterprise.motd;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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
        // TODO: Consider escaping HTML chars to prevent a malicious motd
        // like this --> HtmlUtils.htmlEscape(messageOfTheDay);
        this.messageOfTheDay = messageOfTheDay;
    }

}
