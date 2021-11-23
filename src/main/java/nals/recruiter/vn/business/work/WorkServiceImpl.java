package nals.recruiter.vn.business.work;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nals.recruiter.vn.business.dto.RestResponseDto;
import nals.recruiter.vn.business.dto.ReturnCode;
import nals.recruiter.vn.business.dto.WorkDto;
import nals.recruiter.vn.business.dto.WorkListSearchResult;
import nals.recruiter.vn.dao.model.MWork;
import nals.recruiter.vn.dao.work.WorkDao;

@Service
@Transactional
public class WorkServiceImpl implements IWorkService {

	@Autowired
	private WorkDao workDao;

	@Override
	public RestResponseDto add(WorkDto workDto) {
		if (workDao.findByProp("workName", workDto.getWorkName()).size() > 0) {
			return new RestResponseDto(ReturnCode.DUPLICATED_NAME, "Work Name has existed!");
		} else {
			MWork work = new MWork();
			work.setWorkName(workDto.getWorkName());
			work.setStartingDate(workDto.getStartingDate());
			work.setEndingDate(workDto.getEndingDate());
			work.setStatus(workDto.getStatus());

			workDao.save(work);
			return new RestResponseDto(ReturnCode.SUCCESS, workDto.getWorkName());
		}
	}

	@Override
	public RestResponseDto edit(WorkDto workDto) {
		List<MWork> works = workDao.findByProp("workName", workDto.getWorkName());
		if (works.size() > 0) {
			MWork work = works.get(0);
			if (workDto.getStartingDate() != null) {
				work.setStartingDate(workDto.getStartingDate());
			}
			if (workDto.getEndingDate() != null) {
				work.setEndingDate(workDto.getEndingDate());
			}
			if (workDto.getStatus() != null && !"".equals(workDto.getStatus())) {
				work.setStatus(workDto.getStatus());
			}
			workDao.update(work);

			return new RestResponseDto(ReturnCode.SUCCESS, "Work has updated successfully!");
		}
		return new RestResponseDto(ReturnCode.NOT_EXIST, "Work doesn't exist!");
	}

	@Override
	public RestResponseDto delete(String workName) {
		List<MWork> works = workDao.findByProp("workName", workName);
		if (works.size() == 0) {
			return new RestResponseDto(ReturnCode.NOT_EXIST, "Work has not existed!");
		}
		MWork work = works.get(0);
		workDao.delete(work);
		return new RestResponseDto(ReturnCode.SUCCESS, "Work has deleted successfully!");
	}

	@Override
	public RestResponseDto search(WorkDto workDto) {
		Integer totalRecord = 0;
		totalRecord = workDao.search(workDto.getWorkName(), workDto.getStartingDate(), workDto.getEndingDate(),
				workDto.getStatus(), workDto.getColSorting(), workDto.getOrderSorting(), null, null).size();

		if (totalRecord != null && totalRecord.intValue() > 0) {
			List<MWork> list = workDao.search(workDto.getWorkName(), workDto.getStartingDate(), workDto.getEndingDate(),
					workDto.getStatus(), workDto.getColSorting(), workDto.getOrderSorting(), workDto.getStartIndex(),
					workDto.getPageSize());
			WorkDto workSearchResult = null;
			List<WorkDto> workSearchResultList = new ArrayList<>();
			for (MWork work : list) {
				workSearchResult = new WorkDto();
				workSearchResult.setWorkName(work.getWorkName());
				workSearchResult.setStartingDate(work.getStartingDate());
				workSearchResult.setEndingDate(work.getEndingDate());

				workSearchResultList.add(workSearchResult);
			}
			return new RestResponseDto(ReturnCode.SUCCESS, new WorkListSearchResult(workSearchResultList, totalRecord));
		} else {
			return new RestResponseDto(ReturnCode.SUCCESS, new WorkListSearchResult(new ArrayList<WorkDto>(), 0));
		}
	}

}
