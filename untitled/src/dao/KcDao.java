package dao;
import model.Kcb;

import java.util.*;

public interface KcDao {
	/* �������ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize);			//��ѯ���пγ���Ϣ
	public int findKcSize();								//��ѯһ���������γ̼�¼
	public Kcb find(String kch);							//���ݿγ̺Ų��ҿγ���Ϣ
}
