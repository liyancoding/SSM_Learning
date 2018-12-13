package com.ly.mvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 16:58 2018/12/6
 * @Modified By:
 */
public class MyView implements View {

    public String getContentType() {
        return "text/html;charset=UTF-8";
    }

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());

        response.getWriter().write("我的第一个自定义视图！");
    }
}
