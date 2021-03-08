package com.yuki.validate;

import com.yuki.validate.annotation.ColorCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/*
* ConstraintValidator - 约束验证
* */
public class ColorCheckValidator implements ConstraintValidator<ColorCheck,String> {

    private HashSet<String> colorSet = new HashSet<>();
    @Override
    public void initialize(ColorCheck constraintAnnotation) {
        // 可以根据 payload 承载的信息 - 进行 - 初始化
        for (String color : constraintAnnotation.value()) {
            colorSet.add(color);
        }
    }

    /*
    * true  = 通过
    * false = 不通过
    * */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return colorSet.contains(value);
    }
}
