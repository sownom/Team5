package team.t.t.dto;

import java.sql.Timestamp;

public class LoginDTO {
	
    private String mem_id; 
    private String mem_pw; 
    private String mem_name;
    private String mem_post;
    private String mem_addr;
    private String mem_addr2;  
	private String mem_birth;
    private String mem_tel;
    private String mem_phone;
	private String mem_email;
	private String mem_social;
    private Timestamp mem_time;
    
    public String getMem_social() {
		return mem_social;
	}

	public void setMem_social(String mem_social) {
		this.mem_social = mem_social;
	}

	public String getMem_addr2() {
  		return mem_addr2;
  	}

  	public void setMem_addr2(String mem_addr2) {
  		this.mem_addr2 = mem_addr2;
  	}
    public Timestamp getMem_time() {
		return mem_time;
	}

	public void setMem_time(Timestamp mem_time) {
		this.mem_time = mem_time;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_post() {
		return mem_post;
	}

	public void setMem_post(String mem_post) {
		this.mem_post = mem_post;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

}
