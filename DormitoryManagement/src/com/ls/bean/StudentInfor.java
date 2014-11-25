package com.ls.bean;

public class StudentInfor {


	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHostel() {
		return studentHostel;
	}

	public void setStudentHostel(String studentHostel) {
		this.studentHostel = studentHostel;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentAcademy() {
		return studentAcademy;
	}

	public void setStudentAcademy(String studentAcademy) {
		this.studentAcademy = studentAcademy;
	}

	public StudentInfor(String studentNumber, String studentName,
			String studentHostel, String studentClass, String studentAcademy) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentHostel = studentHostel;
		this.studentClass = studentClass;
		this.studentAcademy = studentAcademy;
	}
	@Override
	public String toString() {
		return "StudentInfor [studentNumber=" + studentNumber
				+ ", studentName=" + studentName + ", studentHostel="
				+ studentHostel + ", studentClass=" + studentClass
				+ ", studentAcademy=" + studentAcademy + "]";
	}
	private String studentNumber;
	private String studentName;
	private String studentHostel;
	private String studentClass;
	private String studentAcademy;

}
