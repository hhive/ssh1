package dao.daoImp;
import java.util.List;

import dao.BaseDAO;
import dao.KcDao;
import model.Dlb;
import model.Kcb;
import org.hibernate.*;
import org.hibernate.query.Query;


public class KcDaoImp extends BaseDAO implements KcDao {
	/* ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize, Dlb dlb){
		Query query;
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		if (dlb.getRole().equals("sa")) {
			query = session.createQuery("from Kcb");
		} else {
			//外键查询通过外连接实现,需要在配置文件中配置
			query=session.createQuery("from Kcb where dlb.id like '%" + dlb.getId() + "%'"	);
		}
		int firstResult=(pageNow-1)*pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List list=query.list();

		ts.commit();
		session.close();
		session=null;
		return list;
	}
	public int findKcSize(Dlb dlb){
		int i;
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		if (dlb.getRole().equals("sa")) {
			i = session.createQuery("from Kcb").list().size();
		} else {
			i = session.createQuery("from Kcb where dlb.id like '%" + dlb.getId() + "%'").list().size();
		}
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

	//添加课程
	public boolean saveOrUpdate(Kcb kc){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.saveOrUpdate(kc);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Kcb kcb=find(kch);
			session.delete(kcb);
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateKcStatus(String kch, String status) {
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.createQuery("update Kcb set status='" + status + "' where kch='" + kch + "'").executeUpdate();
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
