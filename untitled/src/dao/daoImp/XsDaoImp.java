package dao.daoImp;
import java.util.*;
import dao.BaseDAO;
import dao.XsDao;
import model.Xsb;
import org.hibernate.*;
import org.hibernate.query.Query;

public class XsDaoImp extends BaseDAO implements XsDao {
	/* ʵ�֣�ѧ����Ϣ��ѯ */
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
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Xsb xs=find(xh);
			session.delete(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* ʵ�֣��޸�ĳѧ����Ϣ */
	public void update(Xsb xs){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.update(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* ʵ�֣�ѧ����Ϣ¼�� */
	public void save(Xsb xs){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.save(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
