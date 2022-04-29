package jp.co.tonaise.rest.webservice.restfulwebservice.user;

import java.util.Date;

public class User {
    private Integer id;
    private String nameString;
    private Date birthDate;

    protected User() {
    }

    public User(Integer id, String nameString, Date birthDate) {
	super();
	this.id = id;
	this.nameString = nameString;
	this.birthDate = birthDate;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNameString() {
	return nameString;
    }

    public void setNameString(String nameString) {
	this.nameString = nameString;
    }

    public Date getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", nameString=" + nameString + ", birthDate=" + birthDate + "]";
    }

}
