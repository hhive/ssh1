package service;


import model.Dlb;

import java.util.List;

public interface DlService {

	public List findAll(int pageNow, int pageSize);
	public int findXsSize();


	public Dlb find(String id, String password);

	public void delete(String id);

	public void update(Dlb dlb);

	public void save(Dlb dlb);
	public Dlb getOne(String id);
}
