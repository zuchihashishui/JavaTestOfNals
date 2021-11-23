package nals.recruiter.vn.business.dto;

import java.sql.Timestamp;

public class WorkDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String workName;
	private Timestamp startingDate;
	private Timestamp endingDate;
	private String status;
	private Integer colSorting;
	private Integer orderSorting;
	private Integer startIndex;
	private Integer pageSize;

	public WorkDto() {

	}

	public WorkDto(String workName, Timestamp startingDate, Timestamp endingDate, String status) {
		this.workName = workName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.status = status;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Timestamp getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Timestamp startingDate) {
		this.startingDate = startingDate;
	}

	public Timestamp getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Timestamp endingDate) {
		this.endingDate = endingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getColSorting() {
		return colSorting;
	}

	public void setColSorting(Integer colSorting) {
		this.colSorting = colSorting;
	}

	public Integer getOrderSorting() {
		return orderSorting;
	}

	public void setOrderSorting(Integer orderSorting) {
		this.orderSorting = orderSorting;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
