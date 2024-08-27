package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.LoginBean;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private LoginDAO loginDAO;
	

	@Override
	public void init() throws ServletException {
		loginDAO = new LoginDAO();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		String forwardUrl;
		if (loginDAO.login(loginBean)) {
			forwardUrl = "/getItems";
			req.setAttribute("username", username);
		}  else {
			forwardUrl = "/login/login.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardUrl);
		dispatcher.forward(req, resp);
		
	}

	
	
}
