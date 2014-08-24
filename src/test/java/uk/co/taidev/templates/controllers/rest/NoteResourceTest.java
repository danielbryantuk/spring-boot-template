package uk.co.taidev.templates.controllers.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.taidev.templates.AbstractSpringMvcTest;
import uk.co.taidev.templates.Integration;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Category(Integration.class)
public class NoteResourceTest extends AbstractSpringMvcTest {

    @Autowired
    private NoteResource noteResource;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = mockMvc(noteResource);
    }

    @Test
    public void responseShouldBeTest() throws Exception {
        mvc.perform(get("/rest/note"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name", equalTo("first note")));
    }
}
