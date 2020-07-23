package team.t.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class Dbtest {
	public static void main(String arg[]) throws NamingException{
		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			Context con = new InitialContext();

			Context envCon = (Context) con.lookup("java:comp/env");

			DataSource ds = (DataSource) envCon.lookup("Team5");// 이부분 중요

			conn = ds.getConnection();



			pstmt = (PreparedStatement) conn.prepareStatement("select * from member");

			rs = pstmt.executeQuery();



			if (rs.next()) {

				System.out.println(rs.getString("id"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
