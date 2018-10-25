package dao.daoImp;

import dao.BaseDAO;
import dao.ZyDao;
import model.Zyb;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ZyDaoImp extends BaseDAO implements ZyDao {
	/* ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Zyb where id=?");
			query.setParameter(0, zyId);
			query.setMaxResults(1);
			return (Zyb)query.uniqueResult();	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	
	/* ʵ�֣��޸�ĳѧ����Ϣ */
	public List getAll(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			List list=session.createQuery("from Zyb").list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
