package com.ly.mvc.handler;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:32 2018/12/4
 * @Modified By:
 */

import com.ly.mvc.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @SessionAttributes注解
 * 		-用来向session域中添加模型数据
 * 		-该注解只能添加到类上面
 * 		-属性：
 * 			-value：通过指定key将模型数据放到session域中，值是String类型的数组
 * 			-types：通过指定类型将模型数据添加到session域中，值是Class<?>[]
 *
 */
@SessionAttributes(value = "user", types = String.class)
@Controller
public class SpringMVCHandler1 {

    public static final String SUCCESS = "success";

    @RequestMapping("/testPOJO")
    public String testPOJO(Employee employee) {
        System.out.println("员工信息是： " + employee);
        return SUCCESS;
    }
}
