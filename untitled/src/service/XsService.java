package service;



import model.Xsb;

import java.util.List;

public interface XsService {

	public List findAll(int pageNow, int pageSize);
	public int findXsSize();
	

	public Xsb find(String xh);

	public void delete(String xh);

	public void update(Xsb xs);

	public void save(Xsb xs);
}
