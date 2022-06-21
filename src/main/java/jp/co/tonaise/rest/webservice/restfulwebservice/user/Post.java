package jp.co.tonaise.rest.webservice.restfulwebservice.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String descriptionString;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getDescriptionString() {
	return descriptionString;
    }

    public void setDescriptionString(String descriptionString) {
	this.descriptionString = descriptionString;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    @Override
    public String toString() {
	return "Post [id=" + id + ", descriptionString=" + descriptionString + ", user=" + user + "]";
    }

}
