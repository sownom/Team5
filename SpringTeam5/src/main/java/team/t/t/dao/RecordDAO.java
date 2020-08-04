package team.t.t.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.t.t.dto.RecordDTO;

public class RecordDAO {
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
	
	public List<RecordDTO> list(String id){
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		String sql="select r.*, p.PSYC_TYPE from ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = getConnection();
			
			sql += "record r, ";
			sql += "(select * from psychological) p ";
			sql += "where r.MEM_ID = ? ";
			sql += "and p.PSYC_NO = r.PSYC_NO ";
			sql += "order by r.RECO_TIME";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecordDTO record = new RecordDTO();
				record.setMEM_ID(rs.getString("MEM_ID"));
				record.setPSYC_NO(rs.getInt("PSYC_NO"));
				record.setRECO_TIME(rs.getDate("RECO_TIME"));
				record.setDETI_GRADE(rs.getString("DETI_GRADE"));
				record.setPSYC_TYPE(rs.getString("PSYC_TYPE"));
				
				list.add(record);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return list;
	}
}