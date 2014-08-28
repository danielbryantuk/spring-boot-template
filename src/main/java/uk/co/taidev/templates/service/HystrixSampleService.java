package uk.co.taidev.templates.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HystrixSampleService {

    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String alwaysFailsMethod() {
        throw new RuntimeException("Bad stuff has happened!");
    }

    @HystrixCommand(fallbackMethod = "failingFallbackMethod")
    public String alwaysFailsDownTheChainMethod() {
        throw new RuntimeException("Bad stuff continues to happen!");
    }

    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String longRunningMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "this method takes too long!";
    }


    private String defaultFallbackMethod() {
        return "success";
    }

    @HystrixCommand(fallbackMethod = "secondFallbackMethod")
    private String failingFallbackMethod() {
        throw new RuntimeException("Bad stuff has happened!");
    }

    private String secondFallbackMethod() {
        return "more success";
    }
}
