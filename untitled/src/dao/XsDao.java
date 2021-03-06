package dao;


import model.Xsb;

import java.util.List;

public interface XsDao {
	/* ������ѧ����Ϣ��ѯ */
	public List findAll(int pageNow, int pageSize);		//��ʾ����ѧ����Ϣ
	public int findXsSize();							//��ѯһ��������ѧ����¼
	
	/* �������鿴ĳ��ѧ������ϸ��Ϣ */
	public Xsb find(String xh);							//����ѧ�Ų�ѯĳѧ����Ϣ
	
	/* ������ɾ��ĳѧ����Ϣ */
	public void delete(String xh);						//����ѧ��ɾ��ѧ��
	
	/* �������޸�ĳѧ����Ϣ */
	public void update(Xsb xs);							//�޸�ѧ����Ϣ
	
	/* ������ѧ����Ϣ¼�� */
	public boolean save(Xsb xs);							//����ѧ��

	public List fuzzyQuery(String value, int pageNow, int pageSize);
	public int fuzzyQuerySize(String value, int pageNow, int pageSize);
}
