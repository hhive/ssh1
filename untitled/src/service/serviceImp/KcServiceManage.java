package service.serviceImp;



import dao.KcDao;
import model.Dlb;
import model.Kcb;
import service.KcService;

import java.util.List;

public class KcServiceManage implements KcService {
	private KcDao kcDao;
	/* ҵ��ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize, Dlb dlb){
		return kcDao.findAll(pageNow, pageSize, dlb);
	}
	public int findKcSize(Dlb dlb){
		return kcDao.findKcSize(dlb);
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
	public boolean updateKcStatus(String kch, String status) {
		if (kcDao.updateKcStatus(kch, status)) {
			return true;
		}
		return false;
	}
}
