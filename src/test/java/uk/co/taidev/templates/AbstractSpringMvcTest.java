package uk.co.taidev.templates;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public abstract class AbstractSpringMvcTest {

    protected MockMvc mockMvc(final Object... controllers) {
        return MockMvcBuilders.standaloneSetup(controllers)
                .build();
    }
}
