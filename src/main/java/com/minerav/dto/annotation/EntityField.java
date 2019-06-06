/**
 * 
 */
package com.minerav.dto.annotation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Target;

@Target(FIELD)
/**
 * @author Nirav
 *
 */
public @interface EntityField {

	public String name();
}
