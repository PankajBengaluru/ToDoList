package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserBean;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private UserDAO userDAO;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserBean userBean = new UserBean();
		userBean.setFirstname(firstName);
		userBean.setLastname(lastName);
		userBean.setUsername(username);
		userBean.setPassword(password);
		
		boolean result = userDAO.registerUser(userBean);
		if (result) {
			req.setAttribute("username", username);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/getItems");
			requestDispatcher.forward(req, resp);
		}
	}

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
}
