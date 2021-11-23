package nals.recruiter.vn.controller.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nals.recruiter.vn.business.dto.RestResponseDto;
import nals.recruiter.vn.business.dto.ReturnCode;
import nals.recruiter.vn.business.dto.WorkDto;
import nals.recruiter.vn.business.work.IWorkService;

@Controller
public class WorkController {

	@Autowired
	private IWorkService workService;

	@RequestMapping(value = "/work/add", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RestResponseDto add(@RequestBody WorkDto workDto) {
		try {
			return workService.add(workDto);
		} catch (Exception e) {
			return new RestResponseDto(ReturnCode.GENERAL_FAILED, e.getMessage());
		}
	}

	@RequestMapping(value = "/work/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RestResponseDto update(@RequestBody WorkDto workDto) {
		try {
			return workService.edit(workDto);
		} catch (Exception e) {
			return new RestResponseDto(ReturnCode.GENERAL_FAILED, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/work/delete", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	RestResponseDto delete(@RequestParam String workName) {
		try {
			return workService.delete(workName);
		} catch (Exception e) {
			return new RestResponseDto(ReturnCode.GENERAL_FAILED, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/work/search", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RestResponseDto search(@RequestBody WorkDto workDto) {
		try {
			return workService.search(workDto);
		} catch (Exception e) {
			return new RestResponseDto(ReturnCode.GENERAL_FAILED, e.getMessage());
		}
	}

}
