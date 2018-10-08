package com.cg.fmanage.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({ @NamedQuery(name = "Faculty.getFacultyByID", query = "SELECT f FROM Faculty f WHERE f.facultyId = ?1"),
		@NamedQuery(name = "Faculty.getAllFaculty", query = "SELECT f FROM Faculty f "),
		@NamedQuery(name = "Faculty.deleteFacultyById", query = "DELETE FROM Faculty f WHERE f.facultyId = ?1"),
		@NamedQuery(name = "Faculty.updateFacultyById", query = "UPDATE Faculty f SET f.facultyName = ?1 WHERE f.facultyId = ?2"),

})

public class Faculty {

	@Id
	@Column(name = "FID")
	int facultyId;
	@Column(name = "FNAME")
	String facultyName;
	@Column(name = "SUBJECT")
	String subject;
	@Column(name = "CLASSROOM")
	ArrayList<String> classRoom;

	public Faculty() {
		super();
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ArrayList<String> getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ArrayList<String> classRoom) {
		this.classRoom = classRoom;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facultyId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (facultyId != other.facultyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", subject=" + subject + ", classRoom=" + classRoom + "]";
	}

}
