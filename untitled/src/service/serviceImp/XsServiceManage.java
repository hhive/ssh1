package service.serviceImp;

import dao.CjDao;
import dao.XsDao;
import model.Xsb;
import service.XsService;
import java.util.List;

public class XsServiceManage implements XsService {
	private XsDao xsDao;
	private CjDao cjDao;

	public List findAll(int pageNow, int pageSize){
		return xsDao.findAll(pageNow, pageSize);
	}
	public int findXsSize(){
		return xsDao.findXsSize();
	}

	public Xsb find(String xh){
		return xsDao.find(xh);
	}
	

	public void delete(String xh){
		xsDao.delete(xh);
	}
	

	public void update(Xsb xs){
		xsDao.update(xs);
	}
	

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
