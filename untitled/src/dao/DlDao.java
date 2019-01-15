package dao;


import model.Dlb;

import java.util.List;

public interface DlDao {
	//����������ѧ�źͿ������
	public Dlb find(String id, String password);
	public Dlb getOne(String id);
	public List findAll(int pageNow, int pageSize);
	public int findXsSize();						


	public void delete(String xh);			


	public void update(Dlb dlb);							


	public void save(Dlb dlb);						
}
