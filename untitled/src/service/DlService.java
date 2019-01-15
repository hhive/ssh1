package service;


import model.Dlb;

import java.util.List;

public interface DlService {

	public List findAll(int pageNow, int pageSize);
	public int findXsSize();


	public Dlb find(String id, String password);

	public boolean delete(String id);

	public boolean update(Dlb dlb);

	public boolean save(Dlb dlb);
	public Dlb getOne(String id);
}
