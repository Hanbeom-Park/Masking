package com.masking.masking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

//@SpringBootTest
class MaskingApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        String ttt = "123.0.0.1";
        ObjectMapper a = new ObjectMapper();
        TestVo testVo = new TestVo();
        testVo.setName("이름");
        testVo.setAddress("주소");
        testVo.setCreditCard("ㅁㅁㅁㅁ");
        testVo.setPhoneNumber("test");

        String s = a.writeValueAsString(testVo);
    }

}
