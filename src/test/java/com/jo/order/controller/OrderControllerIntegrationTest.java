package com.jo.order.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jo.order.dto.OrderDto;
import com.jo.order.service.OrderService;
import com.jo.order.starter.OrderServiceApplication;

@SpringBootTest
@ContextConfiguration(classes = OrderServiceApplication.class)
@AutoConfigureMockMvc
public class OrderControllerIntegrationTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public OrderService orderService;

    @MockBean
    public ExecutorService asyncThreadPool;

    @Autowired
    public ObjectMapper objectMapper;

    public OrderDto orderDto;

    @BeforeEach
    public void setUp() {
        orderDto = new OrderDto();
        orderDto.setOrderId(0);
    }

    @Test
    public void testOrderProcessingIntegration() throws Exception {
        String orderDtoJson = objectMapper.writeValueAsString(orderDto);
        ResultActions resultActions = mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderDtoJson));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.key").value("PROCESSING_ORDER"))
                .andExpect(jsonPath("$.message").value("Order is under process"));
        verify(asyncThreadPool, times(1)).submit(any(Runnable.class));
    }
}