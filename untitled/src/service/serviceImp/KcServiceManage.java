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
	public boolean saveOrUpdate(Kcb kc) {
		if(kcDao.saveOrUpdate(kc)) {
			return true;
		}
		return false;
	}
	public KcDao getKcDao(){
		return kcDao;
	}
	public void setKcDao(KcDao kcDao){
		this.kcDao = kcDao;
	}
	public boolean delete(String kch) {
		if (kcDao.delete(kch)) {
			return true;
		}
		return false;
	}

}
