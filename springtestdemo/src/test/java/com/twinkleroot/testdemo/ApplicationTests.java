package com.twinkleroot.testdemo;

import com.twinkleroot.testdemo.sample.SampleController;
import com.twinkleroot.testdemo.sample.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @Runwith 와 같이 사용 해야 함. 빈 설정 @SpringBootApplication 을 찾아가서 알아서 찾는다.
public class ApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    // 테스트가 너무 크기 때문에 @MockBean을 사용해서 쪼갤 수 있음.
    // ApplicationContext에서 SampleService bean을 여기서 만들어준 bean으로 교체한다.
    // SampleService를 MockBean을 이용해서 교체한 것.
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("twinkleroot");
        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello twinkleroot");
    }
}
