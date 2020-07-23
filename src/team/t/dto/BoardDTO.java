package team.t.dto;

import java.sql.Date;

public class BoardDTO {
	
	private int BOAR_NO;
	private String MEM_ID;
	private String BOAR_TITLE;
	private String BOAR_CONT;
	private Date BOAR_TIME;
	private int BOAR_COUN;
	
	public int getBOAR_NO() {
		return BOAR_NO;
	}
	public void setBOAR_NO(int bOAR_NO) {
		BOAR_NO = bOAR_NO;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getBOAR_TITLE() {
		return BOAR_TITLE;
	}
	public void setBOAR_TITLE(String bOAR_TITLE) {
		BOAR_TITLE = bOAR_TITLE;
	}
	public String getBOAR_CONT() {
		return BOAR_CONT;
	}
	public void setBOAR_CONT(String bOAR_CONT) {
		BOAR_CONT = bOAR_CONT;
	}
	public Date getBOAR_TIME() {
		return BOAR_TIME;
	}
	public void setBOAR_TIME(Date bOAR_TIME) {
		BOAR_TIME = bOAR_TIME;
	}
	public int getBOAR_COUN() {
		return BOAR_COUN;
	}
	public void setBOAR_COUN(int bOAR_COUN) {
		BOAR_COUN = bOAR_COUN;
	}
	
	
	
}
