package employeemanagement.model;

import java.util.Date;

public class Message {
	
	private int id;
	private String heading;
	private String description;
	private Date sendDate;
	private String status;
	private int senderId;
	private int empId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", heading=" + heading + ", description=" + description + ", sendDate=" + sendDate
				+ ", status=" + status + ", senderId=" + senderId + ", empId=" + empId + "]";
	}

}
