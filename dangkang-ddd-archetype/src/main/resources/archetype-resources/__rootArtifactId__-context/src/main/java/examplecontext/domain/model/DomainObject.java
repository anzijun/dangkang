#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.examplecontext.domain.model;

/**
 * 领域对象
 * @date 2022/12/23 10:22
 */
public class DomainObject {


    public DomainObject() {
    }

    public DomainObject(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private String email;

    private String phoneNumber;


    public void toDo(){
        //todo 领域对象业务逻辑
    }


    public String getEmail() {
        return email;
    }

    public DomainObject setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public DomainObject setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
