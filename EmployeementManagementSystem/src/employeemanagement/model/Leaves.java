package employeemanagement.model;

public class Leaves {
	
	private int id;
	private int casualleaves;
	private int medicalleaves;
	private int earnedleaves;
	private int year;
	private int empId;
	
	@Override
	public String toString() {
		return "Leaves [id=" + id + ", casualleaves=" + casualleaves + ", medicalleaves=" + medicalleaves
				+ ", earnedleaves=" + earnedleaves + ", year=" + year + ", empId=" + empId + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCasualleaves() {
		return casualleaves;
	}
	public void setCasualleaves(int casualleaves) {
		this.casualleaves = casualleaves;
	}
	public int getMedicalleaves() {
		return medicalleaves;
	}
	public void setMedicalleaves(int medicalleaves) {
		this.medicalleaves = medicalleaves;
	}
	public int getEarnedleaves() {
		return earnedleaves;
	}
	public void setEarnedleaves(int earnedleaves) {
		this.earnedleaves = earnedleaves;
	}


}
