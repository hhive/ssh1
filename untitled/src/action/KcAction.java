package action;

import com.opensymphony.xwork2.ActionContext;
import model.Dlb;
import model.Kcb;
import service.CjService;
import service.DlService;
import service.KcService;
import service.ZyService;
import tool.Pager;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
//老师只能管理自己的课程
public class KcAction {

    private int pageNow = 1;
    private int pageSize = 8;
    private Kcb kc;
    private KcService kcService;
    List zys;

    public List getZys() {
        return zys;
    }

    public void setZys(List zys) {
        this.zys = zys;
    }

    public void setCjService(CjService cjService) {
        this.cjService = cjService;
    }

    public CjService getCjService() {
        return cjService;
    }

    private ZyService zyService;
    private DlService dlService;
    private CjService cjService;
    private List list;
    private String message;

    public String execute() throws Exception{
        Map session=ActionContext.getContext().getSession();
        Dlb dlb = (Dlb)session.get("dl");
        List list=kcService.findAll(pageNow,pageSize,dlb);
       // Kcb temp = (Kcb)list.get(0);
      //  System.out.println("list" + temp.getZyb().getZym());
        Map request=(Map) ActionContext.getContext().get("request");
        Pager page=new Pager(getPageNow(),kcService.findKcSize(dlb));
        System.out.println(page.getTotalPage());
        ActionContext.getContext().put("page", page);
        request.put("list", list);
        request.put("page", page);
        return SUCCESS;
    }

    private boolean isLesson(Kcb kc) {
        Map session=ActionContext.getContext().getSession();
        Dlb dlb = (Dlb)session.get("dl");
        List list = kcService.findAll(1,100, dlb);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Kcb k = (Kcb) it.next();
            if (!kc.getKch().equals(k.getKch())) {
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
            }
            if (kc.getWeekBegin() >= kc.getWeekEnd()) {
                message = "结束周次不能小于或等于开始周次";
                return false;
            }
        }
        return true;
    }

    public String addKcView() throws Exception{
        Map request=(Map) ActionContext.getContext().get("request");
        List list = zyService.getAll();
        request.put("list", list);
        return SUCCESS;
    }

    public String addKc() throws Exception{
        kc.setZyb(zyService.getOneZy(kc.getZyb().getId()));
        Map session = ActionContext.getContext().getSession();
        Dlb dlb = (Dlb)session.get("dl");
        kc.setDlb(dlb);
        if (isLesson(kc)) {
            if (kcService.saveOrUpdate(kc)) {
                return SUCCESS;
            }
           return ERROR;
        } else {
            return ERROR;
        }
    }

    public String findOneKc() throws Exception{
        String kch=kc.getKch();
        kc = kcService.find(kch);
        zys=zyService.getAll();
//        Map request=(Map)ActionContext.getContext().get("request");
//        request.put("zys", zys);
        message = null;
        return SUCCESS;
    }

    public String deleteKc() throws Exception{
        String kch=kc.getKch();
        if(cjService.deleteCjByKch(kch)) {
            if (kcService.delete(kch)) {
                message = "删除成功！";
                return SUCCESS;
            }
        }
        message = "删除失败！";
        return ERROR;

    }


//    public String updateXsView() throws Exception{
//        String xh=kc.getXh();
//        Xsb xsInfo=xsService.find(xh);
//        List zys=zyService.getAll();
//        Map request=(Map)ActionContext.getContext().get("request");
//        request.put("xsInfo", xsInfo);
//        request.put("zys", zys);
//        return SUCCESS;
//    }
    public String updateKc() throws Exception{
        Map session = ActionContext.getContext().getSession();
        Dlb dlb = (Dlb)session.get("dl");
        kc.setDlb(dlb);
        if (isLesson(kc)) {
            kcService.saveOrUpdate(kc);
            message = "修改成功！";
            return SUCCESS;
        }
        return ERROR;
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

    public DlService getDlService() {
        return dlService;
    }

    public void setDlService(DlService dlService) {
        this.dlService = dlService;
    }
}
