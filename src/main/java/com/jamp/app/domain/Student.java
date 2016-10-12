package com.jamp.app.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement
//@XmlRootElement
@XmlType(propOrder = {"id", "name", "graduationTime", "courses"})
//@JsonPropertyOrder({"id", "name", "graduationTime", "courses"})
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Student extends BaseEntity implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	//private int id;
	@XmlElement
	private String name;
	@XmlElement
	private String graduationTime;
	@XmlElement
	private ArrayList<Course> courses = new ArrayList<Course>();
 
	@XmlElement
	public Integer getId() { return id; }
	//@XmlElement
	public String getName() { return name; }
	//@XmlElement
	public String getGraduationTime() { return graduationTime; }
	//@XmlElement
	public ArrayList<Course> getCourses() { return courses; }
	
	//@XmlElement
	
	public void setId(Integer value) { this.id = value; }
	//@XmlElement
	public void setName(String value) { this.name = value; }
	//@XmlElement
	public void setGraduationTime(String value) { this.graduationTime = value; }
	//@XmlElement
	public void setCourses(ArrayList<Course> value) { this.courses = value; }
 
	//@JsonIgnore
//	public String toString() {
//		return this.name + " - "
//				+ graduationTime == null? "Unknown" : graduationTime.toString();
//	}
	
	public Student() {}
	public Student(int id, String name, String graduationTime) {
		this.id = id;
		this.name = name;
		this.graduationTime = graduationTime;
	}
}
