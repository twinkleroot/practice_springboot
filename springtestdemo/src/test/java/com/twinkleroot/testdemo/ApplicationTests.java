package com.twinkleroot.testdemo;

import com.twinkleroot.testdemo.sample.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @Runwith 와 같이 사용 해야 함. 빈 설정 @SpringBootApplication 을 찾아가서 알아서 찾는다.
public class ApplicationTests {

    // 비동기 테스트 : 요청의 응답이 오면 그 때 콜백이 오고 콜백을 실행 할 수 있다.
    // 웹 클라이언트와 비슷한 api 사용 가능.
    // 비동기가 아니더라도 이 api가 좋아서라도 webflux 의존성을 추가해서 webClient를 쓸 것 같다.
    @Autowired
    WebTestClient webTestClient;

    // 테스트가 너무 크기 때문에 @MockBean을 사용해서 쪼갤 수 있음.
    // ApplicationContext에서 SampleService bean을 여기서 만들어준 bean으로 교체한다.
    // SampleService를 MockBean을 이용해서 교체한 것.
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("twinkleroot");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello twinkleroot");
    }
}
