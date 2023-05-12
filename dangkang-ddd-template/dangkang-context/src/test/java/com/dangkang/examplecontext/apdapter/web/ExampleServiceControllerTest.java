package com.dangkang.examplecontext.apdapter.web;


import com.dangkang.examplecontext.adapter.web.ExampleServiceController;
import com.dangkang.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import com.dangkang.examplecontext.client.dto.request.ExampleServiceRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleServiceControllerTest {

    @Autowired
    private ExampleServiceController exampleServiceController;

    @Test
    public void executeShouldSuccessTest(){
        ExampleServiceRequest exampleServiceRequest = new ExampleServiceRequest();
        exampleServiceRequest.setEmail("dangkang@email.com");
        exampleServiceRequest.setPhoneNumber("17600405800");
        exampleServiceController.execute(exampleServiceRequest);
    }

    @Test()
    public void executeShouldFailTest(){
        ExampleServiceRequest exampleServiceRequest = new ExampleServiceRequest();
        exampleServiceRequest.setEmail("");
        exampleServiceRequest.setPhoneNumber("1760040580");
        exampleServiceController.execute(exampleServiceRequest);
    }
}
