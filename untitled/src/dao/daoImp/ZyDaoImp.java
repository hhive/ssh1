package dao.daoImp;

import dao.BaseDAO;
import dao.ZyDao;
import model.Zyb;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ZyDaoImp extends BaseDAO implements ZyDao {
	/* ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Zyb where id='" + zyId + "'");
			query.setMaxResults(1);
			Zyb zyb = (Zyb)query.uniqueResult();
			session.close();
			return zyb;
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
