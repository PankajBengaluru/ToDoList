package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoItemsDAO;
import model.TodoItemBean;

@WebServlet(urlPatterns = {"/insert", "/delete", "/getItems", "/add"})
public class TodoItemsController extends HttpServlet{
	private TodoItemsDAO todoItemsDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		
		switch (url) {
			case "/insert":
				insertItem(req, resp);
			break;
			case "/delete":
				deleteItem(req, resp);
			break;
			case "/getItems":
				getItems(req, resp);
			break;
			case "/add":
				showAddPage(req, resp);
			break;
		}
	}
	
	

	private void showAddPage(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("username", req.getParameter("username"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/todo-add.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}



	private void getItems(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		List<TodoItemBean> todoItems = todoItemsDAO.getTodoItems(username);
		req.setAttribute("todoList", todoItems);
		RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-main.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	private void deleteItem(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		todoItemsDAO.deleteItem(id);
		req.setAttribute("username", req.getParameter("username"));
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/getItems");
			dispatcher.forward(req, resp);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void insertItem(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String username = req.getParameter("username");
		boolean isDone = Boolean.valueOf(req.getParameter("isDone"));
		LocalDate targetDate = LocalDate.parse(req.getParameter("targetDate"));
		
		TodoItemBean newTodoItem = new TodoItemBean();
		
		newTodoItem.setTitle(title);
		newTodoItem.setUsername(username);
		newTodoItem.setIsDone(isDone);
		newTodoItem.setTargetDate(targetDate);
		
		todoItemsDAO.insertItem(newTodoItem);
		req.setAttribute("username", username);
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/getItems");
			dispatcher.forward(req, resp);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void init() throws ServletException {
		todoItemsDAO = new TodoItemsDAO();
	}
	
}
