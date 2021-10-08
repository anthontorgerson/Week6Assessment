/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//package and import statements
@Entity
@Table(name = "host")
public class DrawingHost {
	@Id
	@GeneratedValue
	private int id;
	private String hostName;

	public DrawingHost() {
		super();
	}

	public DrawingHost(int id, String hostName) {
		super();
		this.id = id;
		this.hostName = hostName;
	}

	public DrawingHost(String hostName) {
		super();
		this.hostName = hostName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gethostName() {
		return hostName;
	}

	public void sethostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "host [id=" + id + ", hostName=" + hostName + "]";
	}
}