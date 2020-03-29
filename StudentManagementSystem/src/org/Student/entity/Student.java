package org.Student.entity;

public class Student {
	private	int sno;
	private String sname;
	private int sage ;
	private String saddress;
	private String e_mail;
	private String password;
	
	
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	
	
	public Student(int sno, String password) {
		super();
		this.sno = sno;
		this.password = password;
	}
	public Student() {
		super();
	}
	
	
	
	
	
	

	public Student(int sno, String sname, int sage, String saddress, String e_mail) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
		this.e_mail = e_mail;
	}
	public Student(int sno, String sname, int sage, String saddress, String e_mail, String password) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
		this.e_mail = e_mail;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + ", e_mail="
				+ e_mail + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
