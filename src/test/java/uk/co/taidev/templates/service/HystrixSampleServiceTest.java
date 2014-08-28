package uk.co.taidev.templates.service;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.taidev.templates.Application;
import uk.co.taidev.templates.Integration;
import uk.co.taidev.templates.configuration.HystrixConfiguration;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Category(Integration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, HystrixConfiguration.class})
public class HystrixSampleServiceTest {

    @Autowired
    private HystrixSampleService hystrixSampleService;


    @Test
    public void hystrixShouldPreventExceptionBeingPropagated() {
        String response = hystrixSampleService.alwaysFailsMethod();

        assertThat(response, is("success"));
    }

    @Test
    public void hystrixShouldPreventExceptionBeingPropagatedThroughMethodChainFailures() {
        String response = hystrixSampleService.alwaysFailsDownTheChainMethod();

        assertThat(response, is("more success"));
    }

    @Test
    public void hystrixShouldTimeoutLongRunningMethods() {
        String response = hystrixSampleService.longRunningMethod();

        assertThat(response, is("success"));
    }
}
