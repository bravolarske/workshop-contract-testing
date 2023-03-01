package com.axxes.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTestClass {

    @Autowired
    private MockMvc mockMvc;
@MockBean
MealVoucherRepository repository;
    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
        Mockito.when(repository.get(10)).thenReturn(
                new MealVoucher( 80,  LocalDate.of(1996,12,2))
        );
    }
}