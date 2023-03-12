package com.webservice.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트 () {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);


        /**
         * assertj vs JUnit
         * CoreMatchers와 달리 추가적인 라이브러리가 필요하지 않음
         * 자동완성이 조금 더 확실하게 지원됨
         */
        // then
        // assertThat() : 테스트 검증 라이브러리(assertj)의 검증 메소드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
