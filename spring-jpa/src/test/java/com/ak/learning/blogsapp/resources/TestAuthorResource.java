package com.ak.learning.blogsapp.resources;

import com.ak.learning.blogsapp.BlogsApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogsApp.class)
@WebMvcTest(AuthorResource.class)
public class TestAuthorResource {
  @Autowired
  private WebApplicationContext context;
  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testGetAuthorsReturnsAListOfAuthors() throws Exception {
    String url = new StringBuilder()
        .append("/")
        .append(AuthorResource.AUTHORS_BASE_URI)
        .toString();

    mockMvc.perform(MockMvcRequestBuilders.get(url))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andReturn();
  }

}
