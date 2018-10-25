package dao.daoImp;

import dao.BaseDAO;
import dao.DlDao;
import model.Dlb;
import org.hibernate.Query;
import org.hibernate.Session;


import java.util.Iterator;
import java.util.List;

public class DlDaoImp extends BaseDAO implements DlDao {
	//ʵ�֣�����ѧ�źͿ������
	public Dlb find(String xh, String kl){
		//��ѯ DLB ���еļ�¼
		String hql="from Dlb u where u.xh=? and u.kl=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, xh);
		query.setParameter(1, kl);
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
