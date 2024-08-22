package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Util.DBUtil;
public class StudentDAO {
	public boolean isValidUser(String name, String password) {
        String query = "SELECT * FROM Student WHERE name = ? AND password = ?";
    	 try{
    		Connection connection = DBUtil.getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public ArrayList<Model> showStudents()
	{
		ArrayList<Model> students = new ArrayList<Model>();
		try {
		String query="select * from Student";
		Connection connection = DBUtil.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			Model s = new Model(rs.getInt("rollno"),rs.getString("name"),rs.getString("password"));
			students.add(s);
		}
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return students;
	}
	public int deleteStudent(int rollno)
	{
		int rows=0;
		try
		{
			String query="delete from Student where rollno=?";
			Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, rollno);
			rows = ps.executeUpdate();
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
		}
		return rows;
	}
}
