package cn.anxcyun.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.anxcyun.www.control.ServiceUser;
import cn.anxcyun.www.po.User;
/**
 * 
    * @ClassName: LoginServlet
    * @Description: 
    * @author H&H
    * @date 
    *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("username");
		//String password  = req.getParameter("password");
		String name = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		
		
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//赋值初始化
		user.setU_name(name);
		user.setU_password(password);
		
		//调用函数
		boolean flag = serviceUser.LoginUser(user);
//		boolean flag =true;
		String JDBCInfo = "error";
		if(flag) {
			List<User> list = serviceUser.userList();
			req.setAttribute("list", list);
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("success");
		}
		else {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}
		
		
		
	}

}

