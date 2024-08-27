package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginBean;
import utils.DBConnection;

public class LoginDAO {
	
	public boolean login(LoginBean loginBean) {
		boolean isLoggedIn = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement  preparedStatement = connection.prepareStatement("select * from users where username = ? "
					+ "and password = ? ");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			isLoggedIn = rs.next();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLoggedIn;
	}
}
