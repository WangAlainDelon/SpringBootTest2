package com.wx.exam1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * HttpServlet获取Cookie中的用户Id,并且删除用户
 */
@WebServlet(name="TestServlet",urlPatterns="/deleteuser")
public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("customer_id")) {
                    System.out.println(cookie.getValue());
                }
            }
        }
        //删除

        //第四步：生成HTTP响应结果
        PrintWriter out;
        String title = "HelloServlet";
        String heading1 = "HelloServlet的doGet方法的输出：";
        //set content type
        response.setContentType("text/html;charset=GB2312");
        //write html page
        out = response.getWriter();
        out.print("<HTML><HEAD><TITLE>" + title + "</TITLE>");
        out.print("</HEAD><BODY>");
        out.print(heading1);
        out.println("<h1><p>" + cookies + ":您好</h1>");
        out.print("</BODY></HTML>");
        out.close();
    }
}
