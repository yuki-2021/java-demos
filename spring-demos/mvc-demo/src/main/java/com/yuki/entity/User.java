package com.yuki.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    /*
    * 分组验证测试 - 分组验证
    * */
    @Min(value = 12,message = "最小是#{value}",groups = InsertGroup.class)
    @NotNull(groups = InsertGroup.class)
    private Integer id;



    @Length(min = 7,message = "长度最少是{0}")
    private String username;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /*
    * 所有验证
    * */
    @Min(value = 1000, message = "{Min}",groups = AllGroup.class)
    @NumberFormat(pattern = "#,###.##")
    private Double salary;


    @Valid
    private Car car;

    /*
    * 分组校验
    * */
    public interface InsertGroup extends AllGroup{}
    public interface UpdateGroup extends AllGroup {}
    public interface AllGroup{}

}
