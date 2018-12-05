package com.ly.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 13:56 2018/11/29
 * @Modified By:
 */
@Controller
//@RequestMapping("/handler")
public class SpringMVCHandler {

    public static final String SUCCESS = "success";

    /**
     * SpringMVC的配置文件中配置的InternalResourceViewResolver视图解析器会将方法的返回值解析为真实的物理视图
     * prefix + 返回值 + suffix
     * 即：/WEB-INF/views/success.jsp
     * 然后自动进行请求的转发
     *
     * @RequestMapping注解 -用来映射请求地址
     * -该注解可以添加到类上，也可以添加到方法上
     * -如果类上添加了该注解，那么注解中的地址相对于当前WEB应用的根目录
     * -方法上添加了该注解
     * -如果类上也添加了该注解，那么方法上注解中的地址相对于类上注解中的地址
     * -如果类上没有添加该注解，那么方法上注解中的地址相对于当前WEB应用的根目录
     */

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("测试@RequestMapping");
        return SUCCESS;
    }

    /**
     * @RequestMapping中的属性 1）★value：
     * -用来设置映射的请求路径，值是String类型的数组
     * -如果只有value属性，那么只检测请求的地址是否一致，不管请求的方式
     * 2）★method：
     * -用来设置映射的请求方式，值是RequestMethod类型的数组
     * 3）params：
     * -用来设置映射的请求参数，值是String类型的数组
     * 4）headers:
     * -用来设置映射的请求头，值也是Stirng类型的数组
     */

    @RequestMapping(value = {"/testValue", "/testValue2"})
    public String testValue() {
        System.out.println("testValue");
        return SUCCESS;
    }

    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testValue");
        return SUCCESS;
    }

    //测试params和headers属性
    @RequestMapping(value = "/testParamsAndHeaders", method = RequestMethod.GET,
            params = {"username!=admin", "age=26"}, headers = {"Host=localhost:8080", "Accept-Language=zh-CN,zh;q=0.9"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 测试Ant风格的地址
     * ？：匹配一个字符 /aaa/?/bbb => /aaa/c/bbb
     * *：匹配任意个字符 /aaa/(*)/bbb => /aaa/ccc/bbb
     * **：匹配多层路径 /aaa/(**)/bbb => /aaa/ccc/ddd/bbb
     */

    @RequestMapping("/testAnt/**/ant")
    public String testAnt() {
        System.out.println("testAnt");
        return SUCCESS;
    }

    /**
     * REST风格：
     * ★ @PathVariable注解
     * -用来将REST风格的URL中的请求参数绑定到方法的入参中
     * -属性value：指定占位符的值
     */

    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("传入的id值为： " + id);
        return SUCCESS;
    }

    //测试REST风格的GET请求（相当于查询）
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String testREST_GET(@PathVariable("id") Integer id) {
        System.out.println("获取的订单的id值是： " + id);
        return SUCCESS;
    }

    //测试REST风格的POST请求（相当于增加，也就是新建请求）
    @RequestMapping(value = "/testREST", method = RequestMethod.POST)
    public String testREST_POST() {
        System.out.println("你正在向数据库中保存订单");
        return SUCCESS;
    }

    //测试REST风格的PUT请求（相当于更新）
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.PUT)
    public String testREST_PUT(@PathVariable("id") Integer id) {
        System.out.println("你正在更新的订单的id是： " + id);
        return SUCCESS;
    }

    // 测试REST风格的DEELTE请求（相当于删除）
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.DELETE)
    public String tesREST_DELETE(@PathVariable("id") Integer id) {
        System.out.println("你正在删除的订单的id是：" + id);
        return SUCCESS;
    }

    /**
     * 传统的：
     * ★@RequestParam注解
     * -用来将传统方式的URL中的请求参数获取表单中的请求参数绑定到方法的入参中
     * -如果handler的方法中的入参的名字和请求参数的名字一样那么@RequestParam注解可以不写，但是建议写上
     * -属性：
     * value：用来设置请求参数的参数名
     * required：用来设置该请求参数是否是必须的，默认是true，是必须的
     * defaultValue：给请求参数设置一个默认值，如果获取不到请求参数则使用该值
     *
     * @RequestHeader注解 -用来将请求头中的属性值绑定到handler方法的入参中
     * @CookieValue注解 -用来将Cookie对象的value值绑定到handler方法的入参中
     * -@RequestHeader注解和@CookieValue注解中的属性与@RequestParam中的属性一样
     */

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
        System.out.println("用户名： " + username);
        System.out.println("用户年龄： " + age);
        return SUCCESS;
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Host") String host) {
        System.out.println("你从这里来：" + host);
        return SUCCESS;
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("Cookie对象的value值或者说是Session对象的Id值是：" + sessionId);
        return SUCCESS;
    }

}
