package com.yuki.app.args;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
*   ApplicationArguments
*       - getNonOptionArgs() - 获取所有Key
*       - getOptionValues(key) - 获取值
*
*       - containsOption() - 是否存在
*
*
* */
@RestController
@RequestMapping("/args")
public class ArgController {


    @Autowired
    private ApplicationArguments args;


    @GetMapping
    public String agrs() {
        // 遍历agrs
        System.out.println("----------------------------Args");
        List<String> keys = args.getNonOptionArgs();
        for (String key : keys) {
            List<String> values = args.getOptionValues(key);
            System.out.println("key = "+ key + " , value = " + values);
        }

        // 是否存在
        System.out.println("----------------------------Exists");
        boolean info = args.containsOption("info");
        System.out.println("key = info , exists = " + info);


        // String
        System.out.println("----------------------------SourceAgrs");
        String[] sourceArgs = args.getSourceArgs();
        for (String key : sourceArgs) {
            List<String> values = args.getOptionValues(key);
            System.out.println("key = "+ key + " , value = " + values);
        }

        // String
        System.out.println("----------------------------String");
        String s = args.toString();
        System.out.println(s);


        return s;
    }
}
