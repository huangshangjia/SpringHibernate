package com.manage.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Connect {
	static Logger logger = Logger.getLogger(Connect.class);

	public static void main(String[] a) throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:h2:D://code//intellijworkspace//SpringHibernate//database//data", "sa", "");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.USERS");
		while (rs.next()) {
			System.out.println(rs.getInt("ID") + "," + rs.getString("NAME"));
		}
        stmt.close();
		conn.close();
	}

}
