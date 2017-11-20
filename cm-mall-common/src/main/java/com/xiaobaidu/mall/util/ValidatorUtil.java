package com.xiaobaidu.mall.util;


import com.xiaobaidu.mall.exception.BaseCode;
import com.xiaobaidu.mall.vo.ResponseVo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author chenhaipeng
 * @version 1.0
 * @date 2016/11/26 17:35
 */
public class ValidatorUtil {
	private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	/**
	 * 使用jsr303 校验
	 *
	 * @param t
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseVo validator(T t) {
		Set<ConstraintViolation<T>> violations = validator.validate(t);
		if (BeanUtils.isNotEmpty(violations)) {
			return ResponseVo.ERROR(BaseCode.PARAM_ILLEGAL,violations.iterator().next().getMessage());
		}
		return ResponseVo.SUCCESS();
	}
}
