package team.t.t.dto;

import java.sql.Date;

public class ReplyDTO {
	
	private int BORD_NO;
	private String MEM_ID;
	private String COMM_CONT;
	private Date COMM_TIME;
	
	public int getBORD_NO() {
		return BORD_NO;
	}
	public void setBORD_NO(int bORD_NO) {
		BORD_NO = bORD_NO;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getCOMM_CONT() {
		return COMM_CONT;
	}
	public void setCOMM_CONT(String cOMM_CONT) {
		COMM_CONT = cOMM_CONT;
	}
	public Date getCOMM_TIME() {
		return COMM_TIME;
	}
	public void setCOMM_TIME(Date cOMM_TIME) {
		COMM_TIME = cOMM_TIME;
	}
	
	
}
