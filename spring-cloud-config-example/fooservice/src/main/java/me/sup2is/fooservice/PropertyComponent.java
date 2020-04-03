package me.sup2is.fooservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PropertyComponent {

    @Value("${example.property}")
    private String exampleProperty;

    @PostConstruct
    public void doSomething() {
        System.out.println(exampleProperty);
    }

}
