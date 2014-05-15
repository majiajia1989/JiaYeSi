package com.e1858.wuye.validator.impl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import com.e1858.wuye.validator.LicencePlate;
public class LicencePlateValidator implements ConstraintValidator<LicencePlate, String> 
{
	@Override
	public void initialize(LicencePlate wordsAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isBlank(value))
		{
			return Boolean.TRUE;
		}
		Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$");  
		Matcher matcher = pattern.matcher(value);  
		return matcher.find();  
	}
}
