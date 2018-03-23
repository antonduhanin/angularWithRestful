package com.mvc;

import com.core.services.BlogEntryService;
import com.rest.core.entities.BlogEntry;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController controller;
    @Mock
    private BlogEntryService service;


    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        BlogEntry entry = new BlogEntry();
        entry.setId(1l);
        entry.setTitle("Test Title");
        when(service.find(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andDo(print())
                .andExpect(jsonPath("$.title",is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href",hasItem(endsWith("/blog-entries/1"))))
                .andExpect(status().isOk());

    }
}