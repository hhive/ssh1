package dao.daoImp;

import dao.BaseDAO;
import dao.DlDao;
import model.Dlb;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;


import java.util.Iterator;
import java.util.List;

public class DlDaoImp extends BaseDAO implements DlDao {
	//ʵ�֣�����ѧ�źͿ������
	public Dlb find(String id, String password){
		//��ѯ DLB ���еļ�¼
		String hql="from Dlb u where u.id= '" + id + "' and u.password='" + password + "'";
		Session session=getSession();
		Query query=session.createQuery(hql);
		List users=query.list();
		Iterator it=users.iterator();
		while(it.hasNext()){
			if(users.size()!=0){
				Dlb user=(Dlb)it.next();	//�����־û��� JavaBean ���� user
				session.close();
				return user;
			}
		}
		session.close();
		return null;
	}
	public Dlb getOne(String id){
		//��ѯ DLB ���еļ�¼
		String hql="from Dlb u where u.id= '" + id + "'";
		Session session=getSession();
		Query query=session.createQuery(hql);
		List users=query.list();
		Iterator it=users.iterator();
		while(it.hasNext()){
			if(users.size()!=0){
				Dlb user=(Dlb)it.next();	//�����־û��� JavaBean ���� user
				return user;
			}
		}
		session.close();
		return null;
	}
	public List findAll(int pageNow, int pageSize){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Dlb order by id");
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
			int i = session.createQuery("from Dlb").list().size();
			session.close();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	public Dlb find(String id){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Dlb where id= '" + id + "'");
			Dlb dlb=(Dlb)query.uniqueResult();
			ts.commit();
			session.close();
			return dlb;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(String id){
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			Dlb dlb=find(id);
			session.delete(dlb);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Dlb dlb){
		Session session=getSession();
		try{

			Transaction ts=session.beginTransaction();
			session.update(dlb);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(Dlb dlb){
		Session session=getSession();;
		try{
			Transaction ts=session.beginTransaction();
			session.save(dlb);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
			return false;
		}
	}
}
