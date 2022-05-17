package com.cap.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public void selectEmp() throws SQLException {
		Connection conn=null;
		Statement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"system","test");
			
			pstmt = conn.createStatement();
			rs=pstmt.executeQuery("select * from emp order by id asc");
			
			System.out.println("아이디            이름           비밀번호");
			System.out.println("-------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getString("ID")+"\t");
				System.out.print(rs.getString("NAME")+"\t");
				System.out.println(rs.getInt("PASSWORD")+"\t");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	}
}
