package com.e1858.wuye.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.e1858.wuye.validator.impl.MobilePhoneValidator;

/**
 * 车牌号码验证
 * @author baoguit
 */
@Documented
@Constraint(validatedBy = {MobilePhoneValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface MobilePhone {
	
	String message() default "{constraint.default.words.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String filed() default "";
}
