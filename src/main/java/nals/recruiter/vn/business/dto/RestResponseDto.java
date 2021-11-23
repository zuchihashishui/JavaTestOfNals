package nals.recruiter.vn.business.dto;

import java.io.Serializable;

public class RestResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int returnedCode;
	private Object data;

	public RestResponseDto() {}

	public RestResponseDto(int returnedCode) {
		this.returnedCode = returnedCode;
	}

	public RestResponseDto(int returnedCode, Object data) {
		this.returnedCode = returnedCode;
		this.data = data;
	}

	public int getReturnedCode() {
		return returnedCode;
	}

	public void setReturnedCode(int returnedCode) {
		this.returnedCode = returnedCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestResponseDto [returnedCode=").append(returnedCode)
				.append(", data=").append(data).append("]");
		return builder.toString();
	}

}

