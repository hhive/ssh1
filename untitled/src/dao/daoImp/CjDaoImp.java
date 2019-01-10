package dao.daoImp;

import dao.BaseDAO;
import dao.CjDao;
import model.Cjb;
import model.CjbId;
import model.CjbPK;
import model.Dlb;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CjDaoImp extends BaseDAO implements CjDao {
	public Cjb getXsCj(String xh, String kch){
		CjbPK cjbPk=new CjbPK();
		cjbPk.setXh(xh);
		cjbPk.setKch(kch);
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return (Cjb)session.get(Cjb.class, cjbPk);
	}
	public void saveorupdateCj(Cjb cj){
		System.out.println("saveorupdateCj");
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(cj);
		ts.commit();
		session.close();
	}

	public List findAllCj(int pageNow, int pageSize, Dlb dlb){
		Query query;
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		if (dlb.getRole().equals("sa")) {
			query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch");
		} else {
			query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch AND b.dlb.id='" + dlb.getId() + "'");
		}
		query.setFirstResult((pageNow-1)*pageSize);			//��ҳ�Ӽ�¼��ʼ����
		query.setMaxResults(pageSize);						//���ҵ����������
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	public int findCjSize(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			int i = session.createQuery("from Cjb").list().size();
			session.close();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	public List getXsCjList(String xh){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf FROM Xsb a,Kcb b,Cjb c WHERE c.id.xh='" + xh + "' AND a.xh=c.id.xh AND b.kch=c.id.kch");
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}

	public void deleteCj(String xh, String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.delete(getXsCj(xh, kch));
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean deleteCjByKch(String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			String hql = "delete from Cjb where id.kch='" + kch + "'";
			session.createQuery(hql).executeUpdate();
			ts.commit();
			session.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public void deleteOneXsCj(String xh){
		try{
			System.out.println("deleteOneXsCj:" + xh);
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			String hql = "delete from Cjb where id.xh='" + xh + "'";
			session.createQuery(hql).executeUpdate();
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
