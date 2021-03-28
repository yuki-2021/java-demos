package com.yuki.aop;

import com.yuki.aspect.CatAnno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("catTarget")
public class Cat implements CatFace{

    private String name;
    private int age;
    private String hobby;

    // 捕鱼
    public void fish(String tool) {
        System.out.println("cat - 正在捕鱼 !!!");
        int i = new Random().nextInt(1000);
        if(i <=5) {
            throw new RuntimeException("cat - 发生了暴雨,捕鱼终止 !!!");
        }
        if(tool.equals("knive")) {
            System.out.println("cat - 捕捉了10条鱼");
        } else {
            System.out.println("cat - 捕捉了1条鱼");
        }
    }

    public void eat() {
        System.out.println("cat - 正在吃饭 !!!");
    }
}
