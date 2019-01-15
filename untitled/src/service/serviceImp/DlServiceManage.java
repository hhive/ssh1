package service.serviceImp;


import dao.DlDao;
import model.Dlb;
import service.DlService;

import java.util.List;

public class DlServiceManage implements DlService {
	private DlDao dlDao;

	public List findAll(int pageNow, int pageSize){
		return dlDao.findAll(pageNow, pageSize);
	}
	public int findXsSize(){
		return dlDao.findXsSize();
	}

	public Dlb find(String id, String password){
		return dlDao.find(id, password);
	}


	public void delete(String id){
		dlDao.delete(id);
	}


	public void update(Dlb dlb){
		dlDao.update(dlb);
	}


	public void save(Dlb dlb){
		dlDao.save(dlb);
	}
	public Dlb getOne(String id){
		return dlDao.getOne(id);
	}
	public DlDao getDlDao(){
		return dlDao;
	}
	public void setDlDao(DlDao dlDao){
		this.dlDao = dlDao;
	}
}
