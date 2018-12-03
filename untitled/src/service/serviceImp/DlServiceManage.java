package service.serviceImp;


import dao.DlDao;
import model.Dlb;
import service.DlService;

public class DlServiceManage implements DlService {
	private DlDao dlDao;
	//ҵ��ʵ�֣�����ѧ�źͿ������
	public Dlb find(int id, String password){
		return dlDao.find(id, password);
	}
	public Dlb getOne(int id){
		return dlDao.getOne(id);
	}
	public DlDao getDlDao(){
		return dlDao;
	}
	public void setDlDao(DlDao dlDao){
		this.dlDao = dlDao;
	}
}
