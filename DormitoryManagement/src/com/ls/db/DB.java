package com.ls.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ls.bean.LoginInfor;
import com.ls.bean.StudentInfor;
import com.mysql.jdbc.log.Log;

public class DB {
	private static Connection connection;
	private static Statement statement;

	/** 数据库初始化连接，获取连接 */
	public static Connection getConnection() {
		java.sql.Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/dormitory_management", "root",
					"root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static int insert(StudentInfor studentInfor) {
		connection = getConnection();
		String sql = "insert into studentinfor "
				+ "(student_number,student_name,student_hostel,student_class,student_academy) "
				+ "values('" + studentInfor.getStudentNumber() + "','"
				+ studentInfor.getStudentName() + "','"
				+ studentInfor.getStudentHostel() + "','"
				+ studentInfor.getStudentClass() + "','"
				+ studentInfor.getStudentAcademy() + "')";
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println("向数据库插入数据：" + count);
			connection.close();
			statement.close();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("向数据库插入数据失败");
			return 0;
		}

	}

	public static List<StudentInfor> query(String queryInfor, String where) {
		List<StudentInfor> studentInfors = new ArrayList<StudentInfor>();
		StudentInfor studentInfor = null;
		connection = getConnection();
		String sql = "select * from   studentinfor where " + where + "='"
				+ queryInfor + "'";
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String studentNumber = resultSet.getString("student_number");
				String studentName = resultSet.getString("student_name");
				String studentHostel = resultSet.getString("student_hostel");
				String studentClass = resultSet.getString("student_class");
				String studentAcademy = resultSet.getString("student_academy");
				studentInfor = new StudentInfor(studentNumber, studentName,
						studentHostel, studentClass, studentAcademy);
				System.out.println(studentInfor);
				studentInfors.add(studentInfor);
			}
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentInfors;
	}

	public static List<StudentInfor> queryAll() {
		List<StudentInfor> studentInfors = new ArrayList<StudentInfor>();
		StudentInfor studentInfor = null;
		connection = getConnection();
		String sql = "select * from   studentinfor  order by student_hostel asc ";// desc降序，asc升序
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String studentNumber = resultSet.getString("student_number");
				String studentName = resultSet.getString("student_name");
				String studentHostel = resultSet.getString("student_hostel");
				String studentClass = resultSet.getString("student_class");
				String studentAcademy = resultSet.getString("student_academy");
				studentInfor = new StudentInfor(studentNumber, studentName,
						studentHostel, studentClass, studentAcademy);
				System.out.println(studentInfor);
				studentInfors.add(studentInfor);
			}
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentInfors;
	}

	public static int delete(String deleteInfor, String where) {
		connection = getConnection();
		String sql = "delete from studentinfor where " + where + "='"
				+ deleteInfor + "'";
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println("删除了：" + count);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public static void update(String updateName, String updateInfor,
			String whereName, String whereInfor) {
		connection = getConnection();
		String sql = "update studentinfor set " + updateName + "='"
				+ updateInfor + "'" + " where " + whereName + "='" + whereInfor
				+ "'";
		try {
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println("更新数据：" + count);
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<LoginInfor> queryLoginInfor() {
		List<LoginInfor> loginInfors = new ArrayList<LoginInfor>();
		LoginInfor infor = null;
		connection = getConnection();
		String sql = "select * from managerlogin ";
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				infor = new LoginInfor(name, password);
				loginInfors.add(infor);
				System.out.println("查询到：" + infor.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginInfors;
	}

	public static void main(String[] args) {
		// getConnection();
		// insert(new StudentInfor("2012214948", "王畅", "611", "0191203",
		// "通信学院"));
		// query("李双", "student_name");
		// queryAll();
		// delete("0191203", "student_class");
		// update("student_academy", "计算机学院", "student_name", "李三");
		// queryLoginInfor();
	}
}
