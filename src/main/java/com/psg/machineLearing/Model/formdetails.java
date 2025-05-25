package com.psg.machineLearing.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentdetails")
public class formdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="STUDENT_NAME")
	private String student_name;
	
	@Column(name="STUDENT_ROLLNUM")
	private int student_rollnum;
	
	@Column(name="DEPARTMENT_NAME")
	private String department_name;
	
	@Column(name="PREFERED_LANGUAGE")
	private String prefered_language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_rollnum() {
		return student_rollnum;
	}

	public void setStudent_rollnum(int student_rollnum) {
		this.student_rollnum = student_rollnum;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPrefered_language() {
		return prefered_language;
	}

	public void setPrefered_language(String prefered_language) {
		this.prefered_language = prefered_language;
	}
	
	

}
