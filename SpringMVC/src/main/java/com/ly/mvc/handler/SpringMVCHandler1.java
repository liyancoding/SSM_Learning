package com.ly.mvc.handler;

import com.ly.mvc.entities.Employee;
import com.ly.mvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 13:56 2018/11/29
 * @Modified By:
 */

/**
 * @SessionAttributes注解
 * 		-用来向session域中添加模型数据
 * 		-该注解只能添加到类上面
 * 		-属性：
 * 			-value：通过指定key将模型数据放到session域中，值是String类型的数组
 * 			-types：通过指定类型将模型数据添加到session域中，值是Class<?>[]
 *
 */
@SessionAttributes(value = "user3",types = String.class)
@Controller
public class SpringMVCHandler1 {

    public static final String SUCCESS = "success";
    public static final String SHOW = "show";

    /**
     * 使用POJO对象绑定请求参数值
     *
     * SpringMVC会根据入参对象的类型调用类的无参构造器创建对象，
     * 然后根据表单中的name属性值调用对应的set方法将请求参数设置到对象中
     *
     * 注意：表单中表单项的name属性值一定要与类中的属性名保持一致
     *
     */

    @RequestMapping("/testPojo")
    public String testPojo(Employee employee) {
        System.out.println("员工的信息是：" + employee);
        return SUCCESS;
    }

    /**
     * Handler方法的入参中支持的原生ServletAPI
     * <p>
     * ★HttpServletRequest
     * ★HttpServletResponse
     * ★HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(response);
        return SUCCESS;
    }

    /**
     * 处理模型数据方式一：返回值是ModelAndView对象
     * ModelAndView中的模型数据会通过InternalResourceViewResolver
     * 解析器解析得到的InternalResourceView放到request域中，然后进行请求的转发
     *
     */

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        //设置模型数据
        mv.addObject("user1", new User(1, "周茜", "123456", "zq@idea.com"));

        //设置视图名
        mv.setViewName(SHOW);
        return mv;
    }

    /**
     * 处理模型数据方式二：Handler的方法的入参中传入Map、Model获取ModelMap
     * <p>
     * 不管在方法的入参中传入的是Map、Model还是ModelMap，SpringMVC都会转换为ModelAndView对象
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass());

        //向map中添加模型数据，最终会放到request域中
        map.put("user3", new User(2, "李炎", "123456", "ly@idea.com"));

        return SHOW;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {

        //向map中添加模型数据
//        map.put("user3", new User(3, "小明", "111111", "xm@idea.com"));
        map.put("person", "小红");

        return SHOW;
    }

    /**
     * @ModelAttribute注解： -添加了该注解的方法会在所有的目标方法执行之前执行
     * -该注解可以添加到方法上，也可以添加到参数的前面
     * -添加该注解的方法得到的对象会被放到一个叫implicitModel的Map中
     */

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        @RequestParam(value = "username", required = false) String username,
                        Map<String, Object> map) {
        System.out.println("添加了@ModelAttribute注解的方法执行了……");

        if (id != null || username != null) {

            //从数据库中查询出要更新的用户的信息，在此我们假设new的User对象就是从数据库中查询出来的
            User user = new User(1, "liyan", "123456", "ly@idea.com");
            //将user放到map中
            map.put("user", user); // key ==> "user"；value ==> user
        }
    }

    /**
     * 方法入参User对象获取的流程：
     * 		1.先确定获取User对象的key
     * 			1）如果入参的前面添加了@ModelAttribute，那么key就是@ModelAttribute注解中的value属性值
     * 			2）如果入参的前面没有添加@ModelAttribute，那么key就是入参对象的类型的首字母小写
     * 		2.确定了key之后如何获取User对象
     * 			1）以1中得到的key从implicitModel中去寻找User对象
     * 			2）如果通过1）得不到User对象，看当前方法所在的类上有没有添加@SessionAttributes注解
     * 				-如果添加了@SessionAttributes注解那么将从session域中寻找User对象
     * 					-如果找到了key但没有找到值则会抛出以下异常
     * 					Session attribute 'user' required - not found in session
     * 				-如果没有添加@SessionAttributes注解不会去session域中寻找
     * 			3）如果通过1）和2）都找不到User对象，那么SpringMVC将调用User类的无参构造器创建一个User对象
     * 		3.得到User对象之后将表单中的请求参数通过调用set方法设置到User对象中
     *
     *
     */

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user) {
        System.out.println("更新之后的用户的信息是：" + user);
        return SUCCESS;
    }
}
