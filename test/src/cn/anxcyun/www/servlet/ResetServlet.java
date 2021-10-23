package cn.anxcyun.www.servlet;

import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceUser serviceUser = new ServiceUser();

        List<User> users = serviceUser.select("");

        boolean flag = true;

        for(User u : users) {
            flag &= serviceUser.deleteUser(u.getU_name());
        }

        User u = new User("comp440", "pass1234", "", "", "");
        flag &= serviceUser.InsertUser(u);

        String JDBCInfo = "error";
        if(flag) {
            List<User> list = serviceUser.userList();
            req.setAttribute("list", list);
            req.getRequestDispatcher("hello.jsp").forward(req, resp);
        }
        else {
            resp.getWriter().write(JDBCInfo);
            System.out.println("error");
        }

    }
}
