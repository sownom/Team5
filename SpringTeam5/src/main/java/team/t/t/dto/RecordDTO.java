package team.t.t.dto;

import java.sql.Date;

public class RecordDTO {
	private String MEM_ID;
	private int PSYC_NO;
	private Date RECO_TIME;
	private String DETI_GRADE;
	private String PSYC_TYPE;
	
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public int getPSYC_NO() {
		return PSYC_NO;
	}
	public void setPSYC_NO(int pSYC_NO) {
		PSYC_NO = pSYC_NO;
	}
	public Date getRECO_TIME() {
		return RECO_TIME;
	}
	public void setRECO_TIME(Date rECO_TIME) {
		RECO_TIME = rECO_TIME;
	}
	public String getDETI_GRADE() {
		return DETI_GRADE;
	}
	public void setDETI_GRADE(String dETI_GRADE) {
		DETI_GRADE = dETI_GRADE;
	}
	public String getPSYC_TYPE() {
		return PSYC_TYPE;
	}
	public void setPSYC_TYPE(String pSYC_TYPE) {
		PSYC_TYPE = pSYC_TYPE;
	}
}