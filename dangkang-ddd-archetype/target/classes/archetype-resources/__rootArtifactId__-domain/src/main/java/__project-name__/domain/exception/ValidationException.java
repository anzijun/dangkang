#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception;

/**
 * @date 2022/12/30 15:46
 */
public class ValidationException extends ApplicationException{

    public static final String errorCode = "V001";

    public ValidationException(){
        setErrorCode(errorCode);
    }

}
