#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.app.service.dto.request;


import ${package}.application.dto.request.MultipleQueryRequest;

/**
 * @date 2023/1/11 10:48
 */
public class ExampleQueryRequestDTO extends MultipleQueryRequest {

    private String email;

    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
