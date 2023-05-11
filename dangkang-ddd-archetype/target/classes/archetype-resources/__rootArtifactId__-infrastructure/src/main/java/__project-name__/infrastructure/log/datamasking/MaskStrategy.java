#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.log.datamasking;
/**
 * 脱敏策略接口
 */
public interface MaskStrategy {

    String mask(String source, int[] params);
}
