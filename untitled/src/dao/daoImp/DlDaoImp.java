package dao.daoImp;

import dao.BaseDAO;
import dao.DlDao;
import model.Dlb;
import org.hibernate.query.Query;
import org.hibernate.Session;


import java.util.Iterator;
import java.util.List;

public class DlDaoImp extends BaseDAO implements DlDao {
	//ʵ�֣�����ѧ�źͿ������
	public Dlb find(int id, String password){
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
	public Dlb getOne(int id){
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
}
