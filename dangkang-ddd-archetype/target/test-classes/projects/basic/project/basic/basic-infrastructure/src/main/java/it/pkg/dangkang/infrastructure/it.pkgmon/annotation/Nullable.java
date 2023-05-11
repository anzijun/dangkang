package it.pkg.dangkang.infrastructure.it.pkgmon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @date 2022/12/21 15:53
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
public @interface Nullable {
}
