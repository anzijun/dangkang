#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.domain.exception;

public class DataBaseException extends ApplicationException{

    public static final String ERR_DATABASE_CODE="D001";


    public DataBaseException(){
        setErrorCode(ERR_DATABASE_CODE);
    }
}
