#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.apdapter.web;


import ${package}.examplecontext.adapter.web.ExampleServiceController;
import ${package}.examplecontext.app.service.dto.request.ExampleServiceRequestDTO;
import ${package}.examplecontext.client.dto.request.ExampleServiceRequest;
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
