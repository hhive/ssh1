package service.serviceImp;


import dao.DlDao;
import model.Dlb;
import service.DlService;

public class DlServiceManage implements DlService {
	private DlDao dlDao;
	//ҵ��ʵ�֣�����ѧ�źͿ������
	public Dlb find(String xh, String kl){
		return dlDao.find(xh, kl);
	}
	
	public DlDao getDlDao(){
		return dlDao;
	}
	public void setDlDao(DlDao dlDao){
		this.dlDao = dlDao;
	}
}
