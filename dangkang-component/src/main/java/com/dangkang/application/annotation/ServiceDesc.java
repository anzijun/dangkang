package com.dangkang.application.annotation;

import java.lang.annotation.*;

/**
 * @date 2023/1/31 14:04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ServiceDesc {

    String applicationCode() default "";

    String applicationName() default "dangkang";

    String ServiceCode() default "";

    String ServiceName() default "";
}
