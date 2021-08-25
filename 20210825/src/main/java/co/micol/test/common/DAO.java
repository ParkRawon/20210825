package co.micol.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {  //싱글톤클래스 만들기
	private  static DAO dao;
	
	private DAO() {}
	
	public static DAO getInstance() {
		dao = new DAO();
		return dao;
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="dev";
		String password="dev";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB연결 실패!!");
		}
		return conn;
		
	}

}
