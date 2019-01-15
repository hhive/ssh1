package service;



import model.Xsb;

import java.util.List;

public interface XsService {

	public List findAll(int pageNow, int pageSize);
	public int findXsSize();
	

	public Xsb find(String xh);

	public void delete(String xh);

	public void update(Xsb xs);

	public boolean save(Xsb xs);

	public List fuzzyQuery(String value, int pageNow, int pageSize);

	public int fuzzyQuerySize(String value, int pageNow, int pageSize);
}
