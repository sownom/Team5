package team.t.t.dto;

import java.sql.Date;

public class BoardDTO {
	
	private int BOAR_NO;
	private String MEM_ID;
	private String BOAR_TITLE;
	private String BOAR_CONT;
	private Date BOAR_TIME;
	private int BOAR_COUN;
	private int COMM_NO;
	private Date COMM_DATE;
	private String COMM_CONT;
	
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
	public int getCOMM_NO() {
		return COMM_NO;
	}
	public void setCOMM_NO(int cOMM_NO) {
		COMM_NO = cOMM_NO;
	}
	public Date getCOMM_DATE() {
		return COMM_DATE;
	}
	public void setCOMM_DATE(Date cOMM_DATE) {
		COMM_DATE = cOMM_DATE;
	}
	public String getCOMM_CONT() {
		return COMM_CONT;
	}
	public void setCOMM_CONT(String cOMM_CONT) {
		COMM_CONT = cOMM_CONT;
	}
	
	
	
}
