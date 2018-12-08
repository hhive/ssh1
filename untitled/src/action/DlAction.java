package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dlb;
import service.DlService;

import java.util.Map;

public class DlAction extends ActionSupport{
	private Dlb dl;
	protected DlService dlService;

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
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
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
}
