package service.serviceImp;

import dao.CjDao;
import model.Cjb;
import model.Dlb;
import service.CjService;

import java.util.List;

public class CjServiceManage implements CjService {
	private CjDao cjDao;
	/* ҵ��ʵ�֣��ɼ���Ϣ¼�� */
	public Cjb getXsCj(String xh, String kch){
		return cjDao.getXsCj(xh, kch);
	}
	public void saveorupdateCj(Cjb cj){
		cjDao.saveorupdateCj(cj);
	}
	
	/* ҵ��ʵ�֣�ѧ���ɼ���ѯ */
	public List findAllCj(int pageNow, int pageSize, Dlb dlb){
		return cjDao.findAllCj(pageNow, pageSize, dlb);
	}
	public int findCjSize(){
		return cjDao.findCjSize();
	}
	
	/* ҵ��ʵ�֣��鿴ĳ��ѧ���ĳɼ��� */
	public List getXsCjList(String xh){
		return cjDao.getXsCjList(xh);
	}
	
	/* ҵ��ʵ�֣�ɾ��ѧ���ɼ� */
	public void deleteCj(String xh, String kch){
		cjDao.deleteCj(xh, kch);
	}
	public void deleteOneXsCj(String xh){
		cjDao.deleteOneXsCj(xh);
	}
	public boolean deleteCjByKch(String kch) {
		if(cjDao.deleteCjByKch(kch)) {
			return true;
		}
		return false;
	}
	public CjDao getCjDao(){
		return cjDao;
	}
	public void setCjDao(CjDao cjDao){
		this.cjDao = cjDao;
	}

}
