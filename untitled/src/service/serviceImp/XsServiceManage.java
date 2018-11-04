package service.serviceImp;

import dao.CjDao;
import dao.XsDao;
import model.Xsb;
import service.XsService;
import java.util.List;

public class XsServiceManage implements XsService {
	private XsDao xsDao;
	private CjDao cjDao;
	/* ҵ��ʵ�֣�ѧ����Ϣ��ѯ */
	public List findAll(int pageNow, int pageSize){
		return xsDao.findAll(pageNow, pageSize);
	}
	public int findXsSize(){
		return xsDao.findXsSize();
	}
	
	/* ҵ��ʵ�֣��鿴ĳ��ѧ������ϸ��Ϣ */
	public Xsb find(String xh){
		return xsDao.find(xh);
	}
	
	/* ҵ��ʵ�֣�ɾ��ĳѧ����Ϣ */
	public void delete(String xh){
		xsDao.delete(xh);
		cjDao.deleteOneXsCj(xh);			//ɾ��ѧ����ͬʱҪɾ��������Ӧ�ĳɼ�
	}
	
	/* ҵ��ʵ�֣��޸�ĳѧ����Ϣ */
	public void update(Xsb xs){
		xsDao.update(xs);
	}
	
	/* ҵ��ʵ�֣�ѧ����Ϣ¼�� */
	public void save(Xsb xs){
		xsDao.save(xs);
	}
	
	public XsDao getXsDao(){
		return xsDao;
	}
	public void setXsDao(XsDao xsDao){
		this.xsDao = xsDao;
	}
	
	public CjDao getCjDao(){
		return cjDao;
	}
	public void setCjDao(CjDao cjDao){
		this.cjDao = cjDao;
	}
	
}
