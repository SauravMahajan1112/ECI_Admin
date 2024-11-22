package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Candidates {
	@Id
	private int id;
	private String names;
	private String assembly;
	private String partyname;
	private String statename;
	private int age;
	private String gender;

	public Candidates(){
		super();
	}
	public Candidates(int id, String names, String assembly, String partyname, String statename, int age,
			String gender) {
		super();
		this.id = id;
		this.names = names;
		this.assembly = assembly;
		this.partyname = partyname;
		this.statename = statename;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ",names=" + names + ", assembly=" + assembly + ", partyname=" + partyname
				+ ", statename=" + statename + ", age=" + age + ", gender=" + gender + "]";
	}

}
