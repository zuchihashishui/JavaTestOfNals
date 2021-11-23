package nals.recruiter.vn.business.dto;

public class ReturnCode {
	
	public static final int	SUCCESS	= 0; // General success
	
	public static final int	DUPLICATED_NAME	= 1; // Name is already existed in database
	
	public static final int	NOT_EXIST = 2;	// Specified record does not exist.
	
	public static final int	GENERAL_FAILED	= -1; // General failed (ConnectionExceptions,RunTimeException,v.vâ€¦

}
