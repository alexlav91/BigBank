package ru.al.bigbank.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.path;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.al.bigbank.BigBankApplication;
import ru.al.bigbank.BigBankApplicationTests;

import java.nio.file.Path;


public class ClientControllerTest extends BigBankApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void viewHomePageTest() throws Exception{

        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(CoreMatchers.containsString("<td> <a href=\"/showTransaction/1\" class=\"btn btn-primary\">Show transaction</a> </td>")));


    }

    @Test
    public void showNewClientForm() throws Exception {
        mockMvc.perform(get("/showNewClientForm")).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(CoreMatchers.containsString("<input type=\"text\" placeholder=\"Client Name\" class=\"form-control mb-4 col-4\" id=\"clientName\" name=\"clientName\" value=\"\">")));

    }

}