package com.iweb.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XQR
 * @date 2022/8/13 2022/8/13
 * @dsecription 类的描述和介绍
 */
@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从请求中获取参数
        String name=req.getParameter("name");
//        我们希望根据接收到的参数据不同 给js返回不同的响应内容
        resp.setContentType("text/html;charset=utf-8");
        if (name.equals("xqr")){
            resp.getWriter().println("hehe");
        }else {
            resp.getWriter().println("fw");
        }
    }
}
