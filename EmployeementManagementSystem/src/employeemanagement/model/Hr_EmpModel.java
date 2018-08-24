package employeemanagement.model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

public class Hr_EmpModel {
	
	private int id;
	private String name;
	private String email;
	private String designation;
	private String address;
	private String passowrd;
	private String contact;
	private InputStream profilepic;
	private Date dob;
	private String department;
	private String salConfigured;
	private int hr;
	
	
	
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public InputStream getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(InputStream profilepic) {
		this.profilepic = profilepic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public Hr_EmpModel() {
		super();
	}
	@Override
	public String toString() {
		return "Hr_EmpModel [id=" + id + ", name=" + name + ", email=" + email + ", designation=" + designation
				+ ", address=" + address + ", passowrd=" + passowrd + ", contact=" + contact + ", profilepic="
				+ profilepic + ", dob=" + dob + ", department=" + department + ", salConfigured=" + salConfigured
				+ ", hr=" + hr + "]";
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalConfigured() {
		return salConfigured;
	}
	public void setSalConfigured(String salConfigured) {
		this.salConfigured = salConfigured;
	}
	public Hr_EmpModel(int id, String name, String email, String designation, String address, String passowrd,
			String contact, InputStream profilepic, Date dob, String department, String salConfigured, int hr) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.address = address;
		this.passowrd = passowrd;
		this.contact = contact;
		this.profilepic = profilepic;
		this.dob = dob;
		this.department = department;
		this.salConfigured = salConfigured;
		this.hr = hr;
	}
	
	
	
	
	
	
	

}
