package com.jovan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jovan.biz.impl.UserBizImpl;
import com.jovan.biz.impl.UserTypeBizImpl;
import com.jovan.entity.UserType;
import com.jovan.entity.Users;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
	       //检查用户是否存在
			Users users = new Users();
			UserBizImpl userbiz = new UserBizImpl();
			users = userbiz.Login(user_id, user_pwd);
			//提示用户信息
			if(users == null){
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("LongIn.jsp").forward(request, response);
			}
			else{
				session.setAttribute("users", users);
				UserType(request,response);
				/*response.sendRedirect("doadmin.jsp");*/
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   public void UserType(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	   try {
		request.setCharacterEncoding("utf-8");
			//获取用户的信息
		   	HttpSession session = request.getSession();
			Users users = (Users)session.getAttribute("users");
			UserTypeBizImpl usertypeBiz = new UserTypeBizImpl();
			List<UserType> usertypelist = usertypeBiz.findUserType(users);
			session.setAttribute("usertypelist", usertypelist);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

}
