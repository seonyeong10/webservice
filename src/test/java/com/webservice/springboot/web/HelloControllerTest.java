package com.webservice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 저장된 다른 실행자 실행
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중한다.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean 주입
    private MockMvc mvc; // Web API를 테스트 할 때 사용

    @Test
    public void hello가_리턴된다 () throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }
}
