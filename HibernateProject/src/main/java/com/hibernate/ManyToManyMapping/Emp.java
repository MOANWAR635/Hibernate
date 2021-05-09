package com.hibernate.ManyToManyMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp 
{
	@Id
	 private int eid;
	 
	 private String Ename;
	 @ManyToMany
	 private List<Project> project;
	 
	public Emp(int eid, String ename, List<Project> project) {
		super();
		this.eid = eid;
		Ename = ename;
		this.project = project;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
	 
}
