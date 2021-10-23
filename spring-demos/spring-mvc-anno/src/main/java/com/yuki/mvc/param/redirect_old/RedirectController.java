package com.yuki.mvc.param.redirect_old;


import com.yuki.mvc.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
* 测试FlashAttributes、RedirectAttributes
*
* RedirectAttribute - 放在url中，自动追加到queryParamter
* */
@RequestMapping("/redirect")
public class RedirectController {



    @GetMapping("/start/{id}")
    public String start(@PathVariable String id, String name, RedirectAttributes redirectAttributes) {
        System.out.println("==================== start");
        System.out.println("name = " + name);
        System.out.println("id = " + id);

        redirectAttributes.addAttribute("name" ,name); // 会追加
        return "redirect:/redirect/next/{id}";
    }



    @ResponseBody
    @GetMapping("next/{id}")
    public String next(@PathVariable String id, String name) {
        System.out.println("==================== next");
        System.out.println("name = " + name);
        System.out.println("id = " + id);

        return name;
    }



    @GetMapping("/fstart/{id}")
    public String flashStart(@PathVariable String id, String name, User user, RedirectAttributes redirectAttributes) {
        System.out.println("==================== start");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("user = " + user);

        redirectAttributes.addFlashAttribute("name" ,name); // 不追加，自动放到Session中
        redirectAttributes.addFlashAttribute("cat" ,user); // 不追加，自动放到Session中
        return "redirect:/redirect/fnext/{id}";
    }


    // session中自动取出，放到Model
    // 对于基本类型，使用@ModelAttribute访问。对于非基本类型，直接使用
    @ResponseBody
    @GetMapping("fnext/{id}")
    public String next(@PathVariable String id, @ModelAttribute("name") String name, User user) {
        System.out.println("==================== next");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("cat = " + user);

        return name;
    }
}
