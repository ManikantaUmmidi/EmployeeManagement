package employeemanagement.model;

import java.util.Date;

public class Notice {
	
	private int id;
	private Date datetime1;
	private String description;
	public Notice() {
		super();
	}
	public Notice(int id, Date datetime1, String description) {
		super();
		this.id = id;
		this.datetime1 = datetime1;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", datetime1=" + datetime1 + ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatetime1() {
		return datetime1;
	}
	public void setDatetime1(Date datetime1) {
		this.datetime1 = datetime1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
