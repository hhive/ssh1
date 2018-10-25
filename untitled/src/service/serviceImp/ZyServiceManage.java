package service.serviceImp;


import dao.ZyDao;
import model.Zyb;
import service.ZyService;

import java.util.List;

public class ZyServiceManage implements ZyService {
	private ZyDao zyDao;
	/* ҵ��ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){
		return zyDao.getOneZy(zyId);
	}
	
	/* ҵ��ʵ�֣��޸�ĳѧ����Ϣ */
	public List getAll(){
		return zyDao.getAll();
	}
	
	public ZyDao getZyDao(){
		return zyDao;
	}
	public void setZyDao(ZyDao zyDao){
		this.zyDao = zyDao;
	}
}
