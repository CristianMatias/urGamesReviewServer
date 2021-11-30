package com.gamesreview.server.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomExceptionTest {

    @Test
    void shouldCreateCustomExceptionFromAnother(){
        Assertions.assertNotNull(new CustomException(new Exception()));
    }

    @Test
    void shouldCreateCustomExceptionWithMessage(){
        Assertions.assertNotNull(new CustomException("example"));
    }

    @Test
    void shouldCreateFullException(){
        Assertions.assertNotNull(new CustomException(new Exception(), "message"));
    }
}
