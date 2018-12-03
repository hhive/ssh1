package service;


import model.Dlb;

public interface DlService {
	//���񣺸���ѧ�źͿ������
	public Dlb find(int id, String password);
	public Dlb getOne(int id);
}
