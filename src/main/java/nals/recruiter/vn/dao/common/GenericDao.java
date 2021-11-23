package nals.recruiter.vn.dao.common;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable> {

	public K save(T t);

	public void update(T t);

	public void delete(T t);
	
	public List<T> findByProp(String prop, Object data);

}
