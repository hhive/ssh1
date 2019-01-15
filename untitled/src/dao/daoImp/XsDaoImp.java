package dao.daoImp;
import java.util.*;
import dao.BaseDAO;
import dao.XsDao;
import model.Xsb;
import org.hibernate.*;
import org.hibernate.query.Query;

public class XsDaoImp extends BaseDAO implements XsDao {
	public List findAll(int pageNow, int pageSize){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Xsb order by xh");
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public int findXsSize(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			int i = session.createQuery("from Xsb").list().size();
			session.close();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/* ʵ�֣��鿴ĳ��ѧ������ϸ��Ϣ */
	public Xsb find(String xh){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Xsb where xh= '" + xh + "'");
			Xsb xs=(Xsb)query.uniqueResult();
			ts.commit();
			session.close();
			return xs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	public void delete(String xh){
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			Xsb xs=find(xh);
			session.delete(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			session.close();
			e.printStackTrace();
		}
	}

	public void update(Xsb xs){
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			session.update(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			session.close();
			e.printStackTrace();
		}
	}

	public boolean save(Xsb xs){
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			session.save(xs);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
			return false;
		}
	}

	public List fuzzyQuery(String value, int pageNow, int pageSize) {
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Xsb where xh like '%" + value + "%' or xm like '%" + value + "%' order by xh");
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			session.close();
			return list;
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		}
		return null;
	}
	public int fuzzyQuerySize(String value, int pageNow, int pageSize) {
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			int i = session.createQuery("from Xsb where xh like '%" + value + "%' or xm like '%" + value + "%' order by xh").list().size();
			ts.commit();
			session.close();
			return i;
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		}
		return  0;
	}
}
