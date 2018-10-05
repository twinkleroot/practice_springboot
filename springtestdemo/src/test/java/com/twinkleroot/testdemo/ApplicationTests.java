package com.twinkleroot.testdemo;

import com.twinkleroot.testdemo.sample.SampleController;
import com.twinkleroot.testdemo.sample.SampleService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
// @SpringBootApplication을 통한 수 많은 Bean 등록 없이
// 내가 테스트하고 싶은 것만 컨트롤러만 테스트 하고 싶을 때 슬라이스 테스트를 진행한다.
// Web과 관련된 애들만 빈으로 등록되어 테스트 할 수 있다.
// Web이하의 의존성은 끊기기 때문에 테스트에 필요한 빈을 따로 주입해 주어야 한다.
// @WebMvcTest는 MockMvc로 테스트 해야한다.
@WebMvcTest(SampleController.class)
public class ApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    // 테스트가 너무 크기 때문에 @MockBean을 사용해서 쪼갤 수 있음.
    // ApplicationContext에서 SampleService bean을 여기서 만들어준 bean으로 교체한다.
    // SampleService를 MockBean을 이용해서 교체한 것.
    // @MockBean은 통합테스트(@SpringBootTest), 슬라이스테스트 모두에서 사용할 수 있다.
    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("twinkleroot");

        // get(), content() 이 static 메소드가 자동완성 되지 않고 따로 import 시켜줘야 하기 때문에 MockMvc는 좀 불편한다.
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello twinkleroot"));

        assertThat(outputCapture.toString())
                .contains("heesung papa")
                .contains("jungmo");
    }
}


