package nals.recruiter.vn.business.work;

import nals.recruiter.vn.business.dto.RestResponseDto;
import nals.recruiter.vn.business.dto.WorkDto;

public interface IWorkService {
	
	public RestResponseDto add(WorkDto workDto);
	
	public RestResponseDto edit(WorkDto workDto);
	
	public RestResponseDto delete(String workName);
	
	public RestResponseDto search(WorkDto workDto);
}
