package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.t.t.dto.CheckDTO;

public class CheckDAO {
	private static CheckDAO instance = new CheckDAO();
	
	public static CheckDAO getInstance() {
		return instance;
	}
	
	
	public Connection getConnection() throws Exception{
	  
		String dbURL = "jdbc:mysql://172.30.1.1:3306/team5"; 
		String dbID = "team1";
		String dbPassword = "team1"; 
		Class.forName("com.mysql.jdbc.Driver"); 
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	public List<CheckDTO> list(HashMap<String, Object>listOp){
		List<CheckDTO> list = new ArrayList<CheckDTO>();
		String sql="select * from ";
		int op = (Integer)listOp.get("op");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = getConnection();
			
			if(op == 1) {	// MBTI 검사
				sql += " examination ";
				sql += "where PSYC_NO = ? ";
				sql += "order by EXAM_NO";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
			}else if(op == 2) {	// 스트레스 검사
				//sql +="(select @ROWNUM := @ROWNUM +1 AS rnum, ex.* ";
				//sql +="from ";
				//sql +="(select @ROWNUM := 0) ro, (select * from examination where PSYC_NO = ? order by EXAM_NO) ex) bo ";
				sql += " examination ";
				sql += "where PSYC_NO = ? ";
				sql += "order by EXAM_NO";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
			}else if(op == 3) {	// 우울증 검사
				sql += " examination ";
				sql += "where PSYC_NO = ? ";
				sql += "order by EXAM_NO";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
			}else if(op == 4) {	// 알코올 중독 검사
				sql += " examination ";
				sql += "where PSYC_NO = ? ";
				sql += "order by EXAM_NO";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
			}else if(op == 5) {	// 게임 중독 검사
				sql += " examination ";
				sql += "where PSYC_NO = ? ";
				sql += "order by EXAM_NO";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, op);
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CheckDTO check = new CheckDTO();
				check.setPSYC_NO(rs.getInt("PSYC_NO"));
				check.setEXAM_NO(rs.getInt("EXAM_NO"));
				check.setEXAM_CONT(rs.getString("EXAM_CONT"));
				
				list.add(check);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return list;
	}
}