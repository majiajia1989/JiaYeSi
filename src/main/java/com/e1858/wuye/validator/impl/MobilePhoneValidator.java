package com.e1858.wuye.validator.impl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import com.e1858.wuye.validator.MobilePhone;
public class MobilePhoneValidator implements ConstraintValidator<MobilePhone, String> 
{
	@Override
	public void initialize(MobilePhone wordsAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isBlank(value))
		{
			return Boolean.TRUE;
		}
		Pattern pattern = Pattern.compile("1[3456789]\\d{9}");  
		Matcher matcher = pattern.matcher(value);  
		return matcher.find();  
	}
}
