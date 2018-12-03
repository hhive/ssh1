package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dlb;
import service.DlService;

import java.util.Map;

public class DlAction extends ActionSupport{
	private Dlb dl;
	protected DlService dlService;
	//�����û������ execute ����
	public String execute() throws Exception{
		boolean validated=false;				//��֤�ɹ���ʶ
		Map session=ActionContext.getContext().getSession();		//��ûỰ�����������浱ǰ��¼�û�����Ϣ
		Dlb dl1=null;
		//�Ȼ�� Dlb ��������ǵ�һ�η��ʸ�ҳ���û�����϶�Ϊ�գ�������ǵڶ��������ǵ����Σ���ֱ�ӵ�¼��ҳ�������ٴ��ظ���֤���û�����Ϣ
		dl1=(Dlb)session.get("dl");
		//����û��ǵ�һ�ν��룬�Ự����δ�洢 dl1 �־û����󣬹�Ϊ null
		if(dl1==null){
			dl1=dlService.find(dl.getId(), dl.getPassword());
			if(dl1!=null){
				session.put("dl", dl1);			//�� dl1 ����洢�ڻỰ��
				validated=true;					//��ʶΪ true ��ʾ��֤�ɹ�ͨ��
    		}
		}
        else{
        	validated=true;						//���û���֮ǰ�ѵ�¼�����ɹ���֤���ʱ�ʶΪ true ��ʾ����������
        }
        if(validated){
        	//��֤�ɹ������ַ��� "success"
        	return SUCCESS;
        }
        else{
            //��֤ʧ�ܷ����ַ��� "error"
        	return ERROR;
        }
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
