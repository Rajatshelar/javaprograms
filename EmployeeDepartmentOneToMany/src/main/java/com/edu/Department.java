package com.edu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deptid")
	private int departmentId;
	
	@Column(name = "deptname",nullable = false , length = 50)
	private String departmentName;
	
	@Column(name = "deptlocation",nullable = false , length = 50)
	private String departmentLocation;
	
	@OneToMany
	@JoinColumn(name = "deptid")
	List<Employee> emplist = new ArrayList<Employee>();
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department( String departmentName, String departmentLocation) {
		super();
		
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentLocation=" + departmentLocation + "]";
	}
	
	
}
