#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${project-name}.infrastructure.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @date 2022/12/30 11:10
 */
@EnableConfigurationProperties({ApplicationConfig.class})
public class ConfigManager {


}
