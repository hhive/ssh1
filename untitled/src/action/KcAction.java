package action;

import com.opensymphony.xwork2.ActionContext;
import model.Kcb;
import service.KcService;
import service.ZyService;
import tool.Pager;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class KcAction {

    private int pageNow = 1;
    private int pageSize = 8;
    private Kcb kc;
    private KcService kcService;
    private ZyService zyService;
    private List list;
    private String message;

    public String execute() throws Exception{
        List list=kcService.findAll(pageNow,pageSize);
        Map request=(Map) ActionContext.getContext().get("request");
        Pager page=new Pager(getPageNow(),kcService.findKcSize());
        System.out.println(page.getTotalPage());
        ActionContext.getContext().put("page", page);
        request.put("list", list);
        request.put("page", page);
        return SUCCESS;
    }

    private boolean isLesson(Kcb kc) {
        List list = kcService.findAll(1,100);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Kcb k = (Kcb) it.next();
            if (kc.getZyb().getId() == k.getZyb().getId()
                    && kc.getWeekBegin() >= k.getWeekBegin()
                    && kc.getWeekBegin() <= k.getWeekEnd()) {
                if (kc.getWeekDay() == (k.getWeekDay())) {
                    if (kc.getLesson() == (k.getLesson())) {
                        System.out.println("时间安排冲突！");
                        message = "时间安排冲突！";
                        return false;
                    }
                }
            }
            if (kc.getWeekBegin() <= kc.getWeekEnd()) {
                message = "结束周次不能大于或等于开始周次";
            }
        }
        return true;
    }

    public String addKcView() throws Exception{						//��ʾ¼��ҳ��
        Map request=(Map) ActionContext.getContext().get("request");
        List list = zyService.getAll();
        request.put("list", list);
        return SUCCESS;
    }

    public String addXs() throws Exception{							//ִ��¼�����
        kc.setZyb(zyService.getOneZy(kc.getZyb().getId()));
        if (isLesson(kc)) {
            if (kcService.saveOrUpdate(kc)) {
                return SUCCESS;
            }
           return ERROR;
        } else {
            return ERROR;
        }
    }

    public String findKc() throws Exception{
        String kch=kc.getKch();
        kc = kcService.find(kch);
        return SUCCESS;
    }

    /* Action ģ�飺ɾ��ĳѧ����Ϣ */
    public String deleteXs() throws Exception{
        String kch=kc.getKch();
        kcService.delete(kch);
        return SUCCESS;
    }

    /* Action ģ�飺�޸�ĳѧ����Ϣ */
//    public String updateXsView() throws Exception{					//��ʾ�޸�ҳ��
//        String xh=kc.getXh();
//        Xsb xsInfo=xsService.find(xh);
//        List zys=zyService.getAll();
//        Map request=(Map)ActionContext.getContext().get("request");
//        request.put("xsInfo", xsInfo);
//        request.put("zys", zys);
//        return SUCCESS;
//    }
    public String updateXs() throws Exception{						//ִ���޸Ĳ���
        kcService.saveOrUpdate(kc);
        return SUCCESS;
    }

    public Kcb getKc() {
        return kc;
    }

    public void setKc(Kcb kc) {
        this.kc = kc;
    }

    public KcService getKcService() {
        return kcService;
    }

    public void setKcService(KcService kcService) {
        this.kcService = kcService;
    }

    public ZyService getZyService() {
        return zyService;
    }

    public void setZyService(ZyService zyService) {
        this.zyService = zyService;
    }

    public List getList() {
        return zyService.getAll();
    }

    public void setList(List list) {
        this.list = list;
    }


    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
