/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entries")
public class RaffleList {
	// attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="FirstName")
	private String FirstName;
	@Column(name="LastName")
	private String LastName;
	
	// default no args constructor
	public RaffleList() {
		super();
	}
	
	// constructor with args
	public RaffleList(String FirstName, String LastName) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "RaffleList [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + "]";
	}

	
}

