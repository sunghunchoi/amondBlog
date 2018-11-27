package com.amond.blog;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Test {

    @Value("${spring.profiles.active:}")
    private String test;



}
