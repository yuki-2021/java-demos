package com.yuki.web;

import com.yuki.entity.Cat;
import com.yuki.entity.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/*
* 数据验证 - JSR303
* */
@Controller
@Validated
public class ValidateController {

    /*
    *  校验注解
    *  @NotNull
    *  @NotEmpty
    *  @Length
    *  @Max
    *  @Min
    *  @Range
    *  @PositiveOrZero
    *  @Size - 元素
    *  @Email
    *  @Past
    *  @Feature
    *
    * */

    /*
    * MARK 实体类校验 - @Valid
    * MARK 嵌套校验
    *
    * @Valid - 用在requestMapping方法上
    * @Valid - 用在Field上，表示嵌套校验 (@Valided不能用在Field)
    * BindResult - 接收校验结果
    *   - hasErrors()
    *   - getFieldErrors()
    *   - getField()、getRejectedValue()、getDefaultMessage()、getCode()
    * */
    @GetMapping("/validate1")
    @ResponseBody
    public String validate2(@Valid User user,BindingResult bindingResult){
        printBindResult(bindingResult);
        return "验证成功";
    }

    /*
    * MARK 基本类型验证  - 解决方案 - 配置MethodValidationPostProcessor
    *
    * 1. 配置MethodValidationPostProcessor - MethodValidation后置处理器
    * 2. 在Controller上添加@Validated
    * */
    @GetMapping("/validate2")
    @ResponseBody

    public String validate1(@RequestParam("username") @Length(min = 7,message = "name min is {0}") String username){
        return "基本类型验证";
    }


    /*
     * MARK 分组校验 - @Validated
     *
     * 1. 分组 - 对于通用验证，卸一个Default.class，然后其他组继承Default.class
     * 2. @Validated({Group.class}) 指定组
     * */
    @GetMapping("/validInsert")
    @ResponseBody
    public String validInsert(@Validated({User.InsertGroup.class}) User user, BindingResult bindingResult){
        printBindResult(bindingResult);
        return "基本类型验证";
    }
    @GetMapping("/validUpdate")
    @ResponseBody
    public String validUpdate(@Validated({User.UpdateGroup.class}) User user,BindingResult bindingResult){
        printBindResult(bindingResult);
        return "基本类型验证";
    }

    /*
    * MARK 自定义 - 校验注解 - @
    *
    * 1. 定义校验注解 - groups表示分组验证，payload用于承载信息
    * 2. @Constraint - 指定Validator
    * 3. 实现Validator - 继承ConstraintValidator
    *
    *
    * 如果 自定义校验 和 基本属性校验一起,也就是 在Controller上用了@Validated,那么对于自定义校验，
    *  - 使用@Valid，无法使用BindingResult - 直接跑出500.
    *  - 应该用@Validated
    *
    * */
    @GetMapping("/validCustom")
    @ResponseBody
    public String validCustom(@Valid Cat cat,BindingResult bindingResult) {
        printBindResult(bindingResult);

        if(bindingResult.hasErrors()) {
            return "Cat颜色错误";
        }
        return "验证Cat成功";
    }


    private void printBindResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField()); // 字段名称
                System.out.println(fieldError.getRejectedValue()); // 提供的值
                System.out.println(fieldError.getDefaultMessage()); // 错误信息
                System.out.println(fieldError.getCode()); // 错误信息
                System.out.println("===================================");
            }
        }
    }

}
