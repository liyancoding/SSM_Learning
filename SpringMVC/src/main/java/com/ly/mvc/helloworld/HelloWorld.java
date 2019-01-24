package com.ly.mvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 10:41 2018/11/29
 * @Modified By:
 */
@Controller
public class HelloWorld {

    @RequestMapping("/helloworld")
    public String helloWorld() {
        System.out.println("测试HelloWorld");
        return "helloworld";
    }
    public static void main(String[] args){
        System.out.println("这是使用mac之后第一次使用sourcetree上传到到github");
    }
}
