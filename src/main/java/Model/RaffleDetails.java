/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author AnthonT
 *
 */
@Entity
public class RaffleDetails {
@Id
@GeneratedValue
	private int id;
	private String listName;
	private LocalDate raffleDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private DrawingHost drawingHost;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<RaffleList> listOfNames;
	
	public RaffleDetails() {
		super();
	}
	public RaffleDetails(int id, String listName, LocalDate raffleDate, DrawingHost drawingHost, List<RaffleList> listOfNames) {
		super();
		this.id = id;
		this.listName = listName;
		this.raffleDate = raffleDate;
		this.drawingHost = drawingHost;
		this.listOfNames = listOfNames;
	}
			public RaffleDetails(String listName, LocalDate raffleDate,	DrawingHost drawingHost, List<RaffleList> listOfNames) {
				super();
				this.listName = listName;
				this.raffleDate = raffleDate;
				this.drawingHost = drawingHost;
				this.listOfNames = listOfNames;
			}
			public RaffleDetails(String listName, LocalDate raffleDate, DrawingHost drawingHost) {
				super();
				this.listName = listName;
				this.raffleDate = raffleDate;
				this.drawingHost = drawingHost;
			}
			/**
			 * @return the id
			 */
			public int getId() {
				return id;
			}
			/**
			 * @param id the id to set
			 */
			public void setId(int id) {
				this.id = id;
			}
			/**
			 * @return the listName
			 */
			public String getListName() {
				return listName;
			}
			/**
			 * @param listName the listName to set
			 */
			public void setListName(String listName) {
				this.listName = listName;
			}
			/**
			 * @return the raffleDate
			 */
			public LocalDate getRaffleDate() {
				return raffleDate;
			}
			/**
			 * @param raffleDate the raffleDate to set
			 */
			public void setRaffleDate(LocalDate raffleDate) {
				this.raffleDate = raffleDate;
			}
			/**
			 * @return the drawingHost
			 */
			public DrawingHost getDrawingHost() {
				return drawingHost;
			}
			/**
			 * @param drawingHost the drawingHost to set
			 */
			public void setDrawingHost(DrawingHost drawingHost) {
				this.drawingHost = drawingHost;
			}
			/**
			 * @return the listOfNames
			 */
			public List<RaffleList> getListOfNames() {
				return listOfNames;
			}
			/**
			 * @param listOfNames the listOfNames to set
			 */
			public void setListOfNames(List<RaffleList> listOfNames) {
				this.listOfNames = listOfNames;
			}
			
}

