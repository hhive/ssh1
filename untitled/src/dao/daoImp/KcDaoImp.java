package dao.daoImp;
import java.util.List;

import dao.BaseDAO;
import dao.KcDao;
import model.Kcb;
import org.hibernate.*;
import org.hibernate.query.Query;


public class KcDaoImp extends BaseDAO implements KcDao {
	/* ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Kcb");
		int firstResult=(pageNow-1)*pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List list=query.list();
		ts.commit();
		session.close();
		session=null;
		return list;
	}
	public int findKcSize(){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		int i = session.createQuery("from Kcb").list().size();
		session.close();
		return i;
	}
	public Kcb find(String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Kcb where kch='" + kch + "'");
			query.setMaxResults(1);
			Kcb kc=(Kcb)query.uniqueResult();
			ts.commit();
			session.clear();			// �������
			return kc;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
