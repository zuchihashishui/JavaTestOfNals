package nals.recruiter.vn.dao.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WORK")
public class MWork implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String workName;
	private Timestamp startingDate;
	private Timestamp endingDate;
	private String status;
	
	public MWork() {
		
	}
	
	public MWork(String workName, Timestamp startingDate, Timestamp endingDate, String status) {
		this.workName = workName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.status = status;
	}

	@Id
	@Column(name = "WORK_NAME", unique = true, nullable = false)
	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	@Column(name = "STARTING_DATE", nullable = false)
	public Timestamp getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Timestamp startingDate) {
		this.startingDate = startingDate;
	}

	@Column(name = "ENDING_DATE")
	public Timestamp getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Timestamp endingDate) {
		this.endingDate = endingDate;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
