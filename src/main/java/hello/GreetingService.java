package hello;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";

    public String greet(String name) {
        return String.format(template, name);
        //return "Hello World";
    }
}