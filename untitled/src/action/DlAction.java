package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dlb;
import org.apache.struts2.ServletActionContext;
import service.DlService;
import tool.Pager;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class DlAction extends ActionSupport{
	private Dlb dl;
	protected DlService dlService;
	private int pageNow = 1;
	private int pageSize = 8;
	private List list;
	private String message;

	public String execute() throws Exception{
		boolean validated=false;
		Map session=ActionContext.getContext().getSession();
		Dlb dl1=null;

		dl1=(Dlb)session.get("dl");

		if(dl1==null){
			dl1=dlService.find(dl.getId(), dl.getPassword());
			if(dl1!=null){
				session.put("dl", dl1);
				validated=true;
			}
		}
		else{
			validated=true;
		}
		if(validated){

			return SUCCESS;
		}
		else{

			return ERROR;
		}
	}

	public String showUserList() throws Exception{
		System.out.println("dlAction.execute()");
		List list=dlService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),dlService.findXsSize());
		System.out.println(page.getTotalPage());
		ActionContext.getContext().put("page", page);
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}


	public String findUser() throws Exception{
		Dlb dl1 =dlService.getOne(dl.getId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("dl1", dl1);
		return SUCCESS;
	}

	public String deleteUser() throws Exception{
		if(dlService.delete(dl.getId())) {
			message = "添加成功！";
			return SUCCESS;
		}
		message = "添加失败！";
		return ERROR;
	}


	public String updateUserView() throws Exception{
		Dlb UserInfo=dlService.getOne(dl.getId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("UserInfo", UserInfo);
		return SUCCESS;
	}
	public String updateUser() throws Exception{
		if(dlService.update(dl)) {
			return SUCCESS;
		}
		return ERROR;
	}


	public String addUserView() throws Exception{
		System.out.println("addXsView()");
		return SUCCESS;
	}
	public String addUser() throws Exception{
		System.out.println("addXs()");

		if(dlService.save(dl)) {
			message = "添加成功！";
			return SUCCESS;
		}
		message = "添加失败！";
		return ERROR;
	}
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}

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

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	public Dlb getDl(){
		return dl;
	}
	public void setDl(Dlb dl){
		this.dl = dl;
	}
	
	public DlService getDlService(){
		return dlService;
	}
	public void setDlService(DlService dlService){
		this.dlService = dlService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
