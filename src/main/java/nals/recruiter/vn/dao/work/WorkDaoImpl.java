package nals.recruiter.vn.dao.work;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import nals.recruiter.vn.dao.common.GenericDaoImpl;
import nals.recruiter.vn.dao.model.MWork;

@Repository
public class WorkDaoImpl extends GenericDaoImpl<MWork, String>  implements WorkDao {
	
	@Override
	public List<MWork> search(String workName, Timestamp startingDate, Timestamp endingDate, String status,
			Integer colSorting, Integer orderSort, Integer startIndex, Integer pageSize) {
		Criteria criteria = getSession().createCriteria(MWork.class);
		if (workName != null && !"".equals(workName)) {
			criteria.add(Restrictions.like("workName", "%" + workName + "%"));
		}
		if (startingDate != null && !"".equals(startingDate)) {
			criteria.add(Restrictions.ge("startingDate", startingDate));
		}
		if (endingDate != null && !"".equals(endingDate)) {
			criteria.add(Restrictions.ge("endingDate", endingDate));
		}
		
		if (colSorting == null || orderSort == null) {
			criteria.addOrder(Order.asc("workName"));
		} else {
			switch (colSorting) {
			case 0:
				if (orderSort == -1) {
					criteria.addOrder(Order.desc("workName"));
				} else {
					criteria.addOrder(Order.asc("workName"));
				}
				break;
			case 1:
				if (orderSort == -1) {
					criteria.addOrder(Order.desc("startingDate"));
				} else {
					criteria.addOrder(Order.asc("startingDate"));
				}
				break;
			case 2:
				if (orderSort == -1) {
					criteria.addOrder(Order.desc("endingDate"));
				} else {
					criteria.addOrder(Order.asc("endingDate"));
				}
				break;
			case 3:
				if (orderSort == -1) {
					criteria.addOrder(Order.desc("status"));
				} else {
					criteria.addOrder(Order.asc("status"));
				}
				break;
			default:
				break;
			}
		}
		if (startIndex != null && pageSize != null) {
			criteria.setFirstResult(startIndex);
			criteria.setMaxResults(pageSize);
		}
		return criteria.list();
	}

}
