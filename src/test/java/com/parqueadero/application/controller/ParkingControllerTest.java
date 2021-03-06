package com.parqueadero.application.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void validarPing() throws Exception {
        this.mockMvc.perform(get("/parking/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("retorno de informacion de parking")));
    }
    
    @Test
    public void listParking() throws Exception {
        this.mockMvc.perform(get("/parking/allVechiculos")).andDo(print()).andExpect(status().isOk());
    }
    
  
    
  
	
}
