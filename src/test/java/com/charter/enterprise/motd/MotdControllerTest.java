package com.charter.enterprise.motd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MotdControllerTest {

    @Autowired
    private MockMvc mvc;

    String defaultMessage = "Welcome to Charter.  All systems are nominal.";

    /**
     * Requesting the Motd without changing it should return the default Motd
     *
     * @throws Exception
     */
    @Test
    public void getMotd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(defaultMessage)));
    }

    /**
     * Setting a non-empty Motd should update the saved Motd
     *
     * @throws Exception
     */
    @Test
    public void setMotd() throws Exception {
        String updatedMessage = "This is the new message.";
        mvc.perform(MockMvcRequestBuilders.put("/").content(updatedMessage))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Message has been set")));

        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(updatedMessage)));
    }

    /**
     * Setting an empty Motd should error and NOT update the saved Motd
     *
     * @throws Exception
     */
    @Test
    public void setEmptyMotd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/").content(""))
                .andExpect(status().isBadRequest());

        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(defaultMessage)));
    }
}
