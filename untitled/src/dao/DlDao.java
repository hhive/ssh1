package dao;


import model.Dlb;

public interface DlDao {
	//����������ѧ�źͿ������
	public Dlb find(int id, String password);
	public Dlb getOne(int id);
}
