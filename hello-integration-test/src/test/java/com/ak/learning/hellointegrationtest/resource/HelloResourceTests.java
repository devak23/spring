package com.ak.learning.hellointegrationtest.resource;

import com.ak.learning.hellointegrationtest.App;
import com.ak.learning.hellointegrationtest.resources.HelloResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@WebMvcTest(HelloResource.class)
public class HelloResourceTests {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testGreetMessageWithNoParamsReturnsValidHttpResponse() throws Exception {
    String url = baseUrl();

    mockMvc.perform(get(url))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().string("Hello World"))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testGreetMessageWithPassedParameterReturnsAValidHttpResponse() throws Exception {
    String url = baseUrl() + "/{name}";
    mockMvc.perform(get(url, "Abhay"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().string("Hello Abhay"))
        .andDo(print())
        .andReturn();
  }

  @Test
  public void testGetUsersReturnsAValidHttpResponse() throws Exception {
    String url = baseUrl() + "/users";
    String expectedOutput = "[{\"id\":null,\"firstname\":\"Soham\",\"lastname\":\"Kulkarni\",\"emailId\":null},{\"id\":null,\"firstname\":\"Manik\",\"lastname\":\"Kulkarni\",\"emailId\":null},{\"id\":null,\"firstname\":\"Abhay\",\"lastname\":\"Kulkarni\",\"emailId\":null}]";
    mockMvc.perform(get(url))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().string(expectedOutput))
        .andDo(print())
        .andReturn();
  }

  private String baseUrl() {
    return new StringBuilder("http://localhost:8080")
          .append("/")
          .append(HelloResource.HELLO_BASE_URI)
          .toString();
  }
}