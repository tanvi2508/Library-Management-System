package com.tb.model;

public class Student {
	private String name;
	private int age;
	private String contact;
	private String email;
	private String address;
	private int id;
	private  static int tempid=0;



	public Student() {
		
		this.id=++tempid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId() {
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getCSVData() {
		// TODO Auto-generated method stub
		return this.id + "," + this.name + "," + this.age + "," + this.contact + "," + this.address + "," + this.email
				+ "\n";
	}

}
