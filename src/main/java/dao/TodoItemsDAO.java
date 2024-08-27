package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import model.TodoItemBean;
import model.UserBean;
import utils.DBConnection;

public class TodoItemsDAO {
	private static final String INSERT_QUERY = "INSERT INTO items" + 
			"(title, username, target_date, is_done) VALUES (?, ?, ?, ?);";
	private static final String DELETE_QUERY = "delete from items where id = ?;";
	private static final String RETRIEVE_QUERY = "select * from items where username = ?;";
	
	public boolean insertItem(TodoItemBean todoItemBean) {
		Connection connection = DBConnection.getConnection();
		boolean status = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setString(1, todoItemBean.getTitle());
			preparedStatement.setString(2, todoItemBean.getUsername());
			preparedStatement.setDate(3, Date.valueOf(todoItemBean.getTargetDate()));
			preparedStatement.setBoolean(4, todoItemBean.getIsDone());
			
			status = preparedStatement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean deleteItem(int id) {
		boolean status = false;
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setLong(1,id);
			
			status = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public List<TodoItemBean> getTodoItems(String username) {
		List<TodoItemBean> todoItems = new ArrayList <>();
		
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(RETRIEVE_QUERY);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				LocalDate targetDate = rs.getDate(3).toLocalDate();
				boolean isDone = rs.getBoolean(4);
				String uname = rs.getString(5);
				
				TodoItemBean newTodoItem = new TodoItemBean();
				newTodoItem.setId(id);
				newTodoItem.setTitle(title);
				newTodoItem.setTargetDate(targetDate);
				newTodoItem.setIsDone(isDone);
				newTodoItem.setUsername(uname);
				todoItems.add(newTodoItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todoItems;
	}
	
}
