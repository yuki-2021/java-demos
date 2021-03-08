package com.yuki.validate.annotation;

import com.yuki.validate.ColorCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ColorCheckValidator.class) // 哪个了Validator验证
public @interface ColorCheck {

    // values
    String[] value() default {};

    // errorMessage
    String message() default "颜色不符合";

    // group - 分组校验
    Class<?>[] groups() default {};

    // payload - 承载信息
    Class<? extends Payload>[] payload() default {};

}
