package dao;

import model.Zyb;

import java.util.List;

public interface ZyDao {
	/* ������ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId);		//����רҵID����רҵ��Ϣ
	
	/* �������޸�ĳѧ����Ϣ */
	public List getAll();					//��������רҵ��Ϣ��Ϊ����רҵ�����б��ã�
}
