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


	public boolean delete(String id){
		if(dlDao.delete(id)) {
			return true;
		}
		return false;
	}


	public boolean update(Dlb dlb){
		if(dlDao.update(dlb)) {
			return true;
		}
		return false;
	}

	public boolean save(Dlb dlb){
		if(dlDao.save(dlb)) {
			return true;
		}
		return false;
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
