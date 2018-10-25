package service.serviceImp;



import dao.KcDao;
import model.Kcb;
import service.KcService;

import java.util.List;

public class KcServiceManage implements KcService {
	private KcDao kcDao;
	/* ҵ��ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize){
		return kcDao.findAll(pageNow, pageSize);
	}
	public int findKcSize(){
		return kcDao.findKcSize();
	}
	public Kcb find(String kch){
		return kcDao.find(kch);
	}
	
	public KcDao getKcDao(){
		return kcDao;
	}
	public void setKcDao(KcDao kcDao){
		this.kcDao = kcDao;
	}
}
