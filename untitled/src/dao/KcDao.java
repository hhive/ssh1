package dao;
import model.Dlb;
import model.Kcb;

import java.util.*;

public interface KcDao {
	/* �������ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize, Dlb dlb);			//��ѯ���пγ���Ϣ
	public int findKcSize(Dlb dlb);								//��ѯһ���������γ̼�¼
	public Kcb find(String kch);							//���ݿγ̺Ų��ҿγ���Ϣ
	public boolean saveOrUpdate(Kcb kc);
	public boolean delete(String kch);
}
