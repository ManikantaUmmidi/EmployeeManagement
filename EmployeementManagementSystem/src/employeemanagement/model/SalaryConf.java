package employeemanagement.model;

public class SalaryConf {
	
	private int id;
	private double basicPay;
	private double specialPay;
	private double professionalPay;
	private double drPay;
	private double incomeTaxPay;
	private double lopPay;
	private double paPay;
	private double otherAllowancesPay;
	private double otherDeductionsPay;
	private int empId;
	public SalaryConf() {
		super();
	}
	public SalaryConf(int id, double basicPay, double specialPay, double professionalPay, double drPay,
			double incomeTaxPay, double lopPay, double paPay, double otherAllowancesPay, double otherDeductionsPay,
			int empId) {
		super();
		this.id = id;
		this.basicPay = basicPay;
		this.specialPay = specialPay;
		this.professionalPay = professionalPay;
		this.drPay = drPay;
		this.incomeTaxPay = incomeTaxPay;
		this.lopPay = lopPay;
		this.paPay = paPay;
		this.otherAllowancesPay = otherAllowancesPay;
		this.otherDeductionsPay = otherDeductionsPay;
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "SalaryConf [id=" + id + ", basicPay=" + basicPay + ", specialPay=" + specialPay + ", professionalPay="
				+ professionalPay + ", drPay=" + drPay + ", incomeTaxPay=" + incomeTaxPay + ", lopPay=" + lopPay
				+ ", paPay=" + paPay + ", otherAllowancesPay=" + otherAllowancesPay + ", otherDeductionsPay="
				+ otherDeductionsPay + ", empId=" + empId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public double getSpecialPay() {
		return specialPay;
	}
	public void setSpecialPay(double specialPay) {
		this.specialPay = specialPay;
	}
	public double getProfessionalPay() {
		return professionalPay;
	}
	public void setProfessionalPay(double professionalPay) {
		this.professionalPay = professionalPay;
	}
	public double getDrPay() {
		return drPay;
	}
	public void setDrPay(double drPay) {
		this.drPay = drPay;
	}
	public double getIncomeTaxPay() {
		return incomeTaxPay;
	}
	public void setIncomeTaxPay(double incomeTaxPay) {
		this.incomeTaxPay = incomeTaxPay;
	}
	public double getLopPay() {
		return lopPay;
	}
	public void setLopPay(double lopPay) {
		this.lopPay = lopPay;
	}
	public double getPaPay() {
		return paPay;
	}
	public void setPaPay(double paPay) {
		this.paPay = paPay;
	}
	public double getOtherAllowancesPay() {
		return otherAllowancesPay;
	}
	public void setOtherAllowancesPay(double otherAllowancesPay) {
		this.otherAllowancesPay = otherAllowancesPay;
	}
	public double getOtherDeductionsPay() {
		return otherDeductionsPay;
	}
	public void setOtherDeductionsPay(double otherDeductionsPay) {
		this.otherDeductionsPay = otherDeductionsPay;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	

}
