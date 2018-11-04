package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Cjb;
import model.CjbId;
import model.CjbPK;
import model.Kcb;
import service.CjService;
import service.KcService;
import service.XsService;
import tool.Pager;
import java.util.List;
import java.util.Map;

public class CjAction extends ActionSupport{
	private Cjb cj;
	private XsService xsService;
	private KcService kcService;
	private CjService cjService;
	/* Action ģ�飺ѧ���ɼ���ѯ */
	private int pageNow = 1;			//Ĭ�ϵ�һҳ
	private int pageSize = 8;			//ÿҳ��ʾ 8 ����¼
	/* Action ģ�飺�ɼ���Ϣ¼�� */
	public String execute() throws Exception{
		List list1=xsService.findAll(1, xsService.findXsSize());
		List list2=kcService.findAll(1, kcService.findKcSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list1", list1);
		request.put("list2", list2);
		return SUCCESS;
	}
	public String addorupdateXscj() throws Exception{
		Cjb cj1 = null;
		CjbPK cjId1=new CjbPK();
		cjId1.setXh(cj.getId().getXh());
		cjId1.setKch(cj.getId().getKch());
		if(cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch())==null){
			cj1 = new Cjb();
			cj1.setId(cjId1);
		}else{
			cj1 = cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch());
		}
		Kcb kc1=kcService.find(cj.getId().getKch());
		cj1.setCj(cj.getCj());
		if(cj.getCj()>60||cj.getCj()==60){
			cj1.setXf(kc1.getXf());
		}else
			cj1.setXf(0);
		cjService.saveorupdateCj(cj1);
		return SUCCESS;
	}
	
	/* Action ģ�飺ѧ���ɼ���ѯ */
	public String xscjInfo() throws Exception{
		List list=cjService.findAllCj(this.getPageNow(), this.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list",list);
		Pager page=new Pager(this.getPageNow(), cjService.findCjSize());
		request.put("page", page);
		return SUCCESS;
	}
	
	/* Action ģ�飺�鿴ĳ��ѧ���ĳɼ��� */
	public String findXscj() throws Exception{
		List list=cjService.getXsCjList(cj.getId().getXh());
		if(list.size()>0){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/* Action ģ�飺ɾ��ѧ���ɼ� */
	public String deleteOneXscj() throws Exception{
		String xh=cj.getId().getXh();
		String kch=cj.getId().getKch();
		cjService.deleteCj(xh, kch);
		return SUCCESS;
	}
	
	public Cjb getCj(){
		return cj;
	}
	public void setCj(Cjb cj){
		this.cj = cj;
	}
	
	public XsService getXsService(){
		return xsService;
	}
	public void setXsService(XsService xsService){
		this.xsService = xsService;
	}
	
	public KcService getKcService(){
		return kcService;
	}
	public void setKcService(KcService kcService){
		this.kcService = kcService;
	}
	
	public CjService getCjService(){
		return cjService;
	}
	public void setCjService(CjService cjService){
		this.cjService = cjService;
	}
	
	/* Action ģ�飺ѧ���ɼ���ѯ */
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow = pageNow;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
}
