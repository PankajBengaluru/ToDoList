package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBean;
import utils.DBConnection;

public class UserDAO {
	
	private static final String insertQuery = "INSERT INTO users (first_name, last_name, username, password)" 
			+ "VALUES (?, ?, ?, ?);";
	
	public boolean registerUser(UserBean userBean) {
		boolean isRegistered = false;
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2, userBean.getLastname());
			preparedStatement.setString(3, userBean.getUsername());
			preparedStatement.setString(4, userBean.getPassword());
			
			int result = preparedStatement.executeUpdate();
			isRegistered = (result != 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isRegistered;
	}
}
