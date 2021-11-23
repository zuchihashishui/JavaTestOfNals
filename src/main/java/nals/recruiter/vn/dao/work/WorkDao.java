package nals.recruiter.vn.dao.work;

import java.sql.Timestamp;
import java.util.List;

import nals.recruiter.vn.dao.common.GenericDao;
import nals.recruiter.vn.dao.model.MWork;

public interface WorkDao extends GenericDao<MWork, String> {

	public List<MWork> search(String workName, Timestamp startingDate, Timestamp endingDate, String status,
			Integer colSorting, Integer orderSort, Integer startIndex, Integer pageSize);

}
