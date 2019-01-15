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
	

	public boolean save(Xsb xs){
		if(xsDao.save(xs)) {
			return true;
		}
		return false;
	}

	public List fuzzyQuery(String value, int pageNow, int pageSize) {
		return xsDao.fuzzyQuery(value, pageNow, pageSize);
	}
	public int fuzzyQuerySize(String value, int pageNow, int pageSize) {
		return xsDao.fuzzyQuerySize(value, pageNow, pageSize);
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
