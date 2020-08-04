package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.t.t.dto.ResultDTO;

public class ResultDAO {
	private static ResultDAO instance = new ResultDAO();
	
	public static ResultDAO getInstance() {
		return instance;
	}
	
	
	public Connection getConnection() throws Exception{
	  
		String dbURL = "jdbc:mysql://172.30.1.1:3306/team5"; 
		String dbID = "team1";
		String dbPassword = "team1"; 
		Class.forName("com.mysql.jdbc.Driver"); 
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	public ResultDTO list(HashMap<String, Object>listOp){
		ResultDTO dto = new ResultDTO();
		String sql="select * from ";
		int op = (Integer)listOp.get("op");
		String result = (String)listOp.get("result");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = getConnection();
			
			if(op == 1) {	// MBTI 검사
				sql += " psycdetile ";
				sql += "where PSYC_NO = ? ";
				sql += "and DETI_GRADE = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
				pstmt.setString(2, result);
			}else if(op == 2) {	// 스트레스 검사
				sql += " psycdetile ";
				sql += "where PSYC_NO = ? ";
				sql += "and DETI_GRADE = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
				pstmt.setString(2, result);
			}else if(op == 3) {	// 우울증 검사
				sql += " psycdetile ";
				sql += "where PSYC_NO = ? ";
				sql += "and DETI_GRADE = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
				pstmt.setString(2, result);
			}else if(op == 4) {	// 알코올 중독 검사
				sql += " psycdetile ";
				sql += "where PSYC_NO = ? ";
				sql += "and DETI_GRADE = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
				pstmt.setString(2, result);
			}else if(op == 5) {	// 게임 중독 검사
				sql += " psycdetile ";
				sql += "where PSYC_NO = ? ";
				sql += "and DETI_GRADE = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
				pstmt.setString(2, result);
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setPSYC_NO(rs.getInt("PSYC_NO"));
				dto.setPSYC_GRADE(rs.getString("PSYC_GRADE"));
				dto.setDETI_GRADE(rs.getString("DETI_GRADE"));
				dto.setDETI_CONT(rs.getString("DETI_CONT"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return dto;
	}
}
