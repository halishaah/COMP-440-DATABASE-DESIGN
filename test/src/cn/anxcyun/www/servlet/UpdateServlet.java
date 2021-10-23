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
    * @ClassName: UpdateUser
    * @Description: 
    * @author H&H
    * @date 
    *
 */
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("name");
		//String classes = req.getParameter("class");
		//String password = req.getParameter("password");
		//String sex = req.getParameter("sex");
		//String tel =req.getParameter("tel");
		String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String classes =new String(req.getParameter("classes").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String tel = new String(req.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//
		user.setU_name(name);
		user.setU_classes(classes);
		user.setU_password(password);
		user.setU_sex(sex);
		user.setU_tel(tel);
		System.out.println("------�鿴��ǰֵ��"+user.toString());
		//
		boolean flag = serviceUser.updateUser(user);
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
