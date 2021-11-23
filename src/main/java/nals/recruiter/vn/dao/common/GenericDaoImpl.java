package nals.recruiter.vn.dao.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GenericDaoImpl<T, K extends Serializable> extends BaseDAO implements GenericDao<T, K> {
	
	private Class<T> type;
	
	protected Class<T> getType() {
		return this.type;
	}

	protected String getClassName() {
		return type.getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public K save(T t) {
		return (K) getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public List<T> findByProp(String prop, Object data) {
		Criteria cr = getSession().createCriteria(type);
		cr.add(Restrictions.eq(prop, data));
		return cr.list();
	}

}
