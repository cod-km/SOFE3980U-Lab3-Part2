package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/api/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/api/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }


@Test
public void addWithZero() throws Exception {
    this.mvc.perform(get("/api/add")
            .param("operand1", "0")
            .param("operand2", "1010"))
        .andExpect(status().isOk())
        .andExpect(content().string("1010"));
}

@Test
public void addLargeBinaryNumbers() throws Exception {
    this.mvc.perform(get("/api/add")
            .param("operand1", "1000")
            .param("operand2", "10001"))
        .andExpect(status().isOk())
        .andExpect(content().json("11001")); // Expected sum of 111111 + 111111
}


// Multiplication test
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/api/multiply").param("operand1", "101").param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    // Multiplication with case (zero)
    @Test
    public void multiplyWithZero() throws Exception {
        this.mvc.perform(get("/api/multiply").param("operand1", "0").param("operand2", "1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // AND operation test
    @Test
    public void andOperation() throws Exception {
        this.mvc.perform(get("/api/and").param("operand1", "1101").param("operand2", "1011"))
            .andExpect(status().isOk())
            .andExpect(content().string("1001"));
    }

    // AND operation with case (1 & 0)
    @Test
    public void andOperationEdgeCase() throws Exception {
        this.mvc.perform(get("/api/and").param("operand1", "1").param("operand2", "0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // OR operation test
    @Test
    public void orOperation() throws Exception {
        this.mvc.perform(get("/api/or").param("operand1", "1101").param("operand2", "1011"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    // OR operation with case (0 | 1)
    @Test
    public void orOperationEdgeCase() throws Exception {
        this.mvc.perform(get("/api/or").param("operand1", "0").param("operand2", "1"))
            .andExpect(status().isOk())
            .andExpect(content().string("1"));
    }

    // case for different lengths
    @Test
    public void multiplyDifferentLengths() throws Exception {
        this.mvc.perform(get("/api/multiply").param("operand1", "110").param("operand2", "101"))
            .andExpect(status().isOk())
            .andExpect(content().string("11110"));
    }

    


}