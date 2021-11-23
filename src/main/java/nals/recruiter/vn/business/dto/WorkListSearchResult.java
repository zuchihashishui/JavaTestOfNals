package nals.recruiter.vn.business.dto;

import java.util.List;

public class WorkListSearchResult implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<WorkDto> data;
	private Integer totalRecords;
	
	public WorkListSearchResult(List<WorkDto> data, Integer totalRecords) {
		this.data = data;
		this.totalRecords = totalRecords;
	}

	public List<WorkDto> getData() {
		return data;
	}

	public void setData(List<WorkDto> data) {
		this.data = data;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

}
