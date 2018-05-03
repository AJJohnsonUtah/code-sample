package com.charter.enterprise.motd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MotdController {

    @Autowired
    MotdService motdService;

    @GetMapping
    public String getMotd() {
        return motdService.getMessageOfTheDay();
    }

    /**
     * Allow users to make PUT requests with the request body containing the new
     * message of the day. Messages of the day cannot be empty, so a 400 error
     * will be returned if an empty message of the day is found.
     *
     * @param updatedMessage - the new message of the day
     * @return
     */
    @PutMapping
    public HttpEntity<String> setMotd(@RequestBody String updatedMessage) {
        if (updatedMessage == null || updatedMessage.trim().isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        motdService.setMessageOfTheDay(updatedMessage.trim());
        return new ResponseEntity<>("Message has been set", HttpStatus.OK);
    }

}
