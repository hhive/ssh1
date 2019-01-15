package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Xsb;
import org.apache.struts2.ServletActionContext;
import service.CjService;
import service.XsService;
import service.ZyService;
import tool.Pager;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class 	XsAction extends ActionSupport{
	private int pageNow = 1;
	private int pageSize = 8;
	private Xsb xs;
	private XsService xsService;
    private CjService cjService;
	private ZyService zyService;
	private File zpFile;
    private String value;
    private String message;
    public void setCjService(CjService cjService) {
        this.cjService = cjService;
    }

    private List list;

	public String execute() throws Exception{
        System.out.println("XsAction.execute()");
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		System.out.println(page.getTotalPage());
		ActionContext.getContext().put("page", page);
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	

	public String findXs() throws Exception{
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}
	public String getImage() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);
		byte[] img=stu.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();
		if(img!=null&&img.length!=0){
			for(int i=0; i<img.length; i++){
				os.write(img[i]);
			}
			os.flush();
		}
		return NONE;
	}
	

	public String deleteXs() throws Exception{
		String xh=xs.getXh();
        System.out.println("xh:" + xh);
        cjService.deleteOneXsCj(xh);
		xsService.delete(xh);
		return SUCCESS;
	}
	

	public String updateXsView() throws Exception{
		String xh=xs.getXh();
		Xsb xsInfo=xsService.find(xh);
		List zys=zyService.getAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}
	public String updateXs() throws Exception{
		Xsb xs1=xsService.find(xs.getXh());
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		xs1.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		xs1.setCssj(xs.getCssj());
		xs1.setZxf(xs.getZxf());
		xs1.setBz(xs.getBz());
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			xs1.setZp(buffer);
		}
		Map request=(Map)ActionContext.getContext().get("request");
		xsService.update(xs1);
		return SUCCESS;
	}
	

	public String addXsView() throws Exception{
        System.out.println("addXsView()");
		return SUCCESS;
	}
	public String addXs() throws Exception{
        System.out.println("addXs()");
		Xsb stu=new Xsb();
		String xh1=xs.getXh();

		if(xsService.find(xh1)!=null){
			message = "添加失败！";
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		if(!xsService.save(stu)) {
			message = "添加失败！";
		    return ERROR;
        }
		message = "添加成功！";
		return SUCCESS;
	}

    public String fuzzyQuery() {
        System.out.println("XsAction.execute()");
        List list=xsService.fuzzyQuery(value, pageNow, pageSize);
        Map request=(Map)ActionContext.getContext().get("request");
        Pager page=new Pager(getPageNow(),xsService.fuzzyQuerySize(value, pageNow, pageSize));
        System.out.println(page.getTotalPage());
        ActionContext.getContext().put("page", page);
        request.put("list", list);
        request.put("page", page);
        return SUCCESS;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Xsb getXs(){
		return xs;
	}
	public void setXs(Xsb xs){
		this.xs = xs;
	}
	
	public XsService getXsService(){
		return xsService;
	}
	public void setXsService(XsService xsService){
		this.xsService = xsService;
	}
	
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	public ZyService getZyService(){
		return zyService;
	}
	public void setZyService(ZyService zyService){
		this.zyService = zyService;
	}
	
	public File getZpFile(){
		return zpFile;
	}
	public void setZpFile(File zpFile){
		this.zpFile = zpFile;
	}
	//
	/* Action ģ�飺ѧ����Ϣ¼�� */
	public List getList(){
        System.out.println("getList()");
		return zyService.getAll();
	}
	public void setList(List list){
        System.out.println("setList(List list)");
		this.list = list;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
