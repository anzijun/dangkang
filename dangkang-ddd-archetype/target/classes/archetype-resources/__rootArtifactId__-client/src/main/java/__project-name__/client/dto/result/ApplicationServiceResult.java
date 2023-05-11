#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.client.dto.result;

/**
 *
 * ApplicationServiceResult是ddd定义的dto，用于applicationService处理结果的返回值给ApplicationServiceController(ddd定义的adapter)
 * @date 2022/12/18 17:36
 */
public class ApplicationServiceResult extends Result{

    //todo 定义返回属性
    private String Data;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
