package action;

import com.mysql.cj.Session;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.UserService;

import java.util.Map;

public class LoginAction extends ActionSupport {
    ActionContext context;
	private User user;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected UserService userService;
	public String execute() throws Exception{
		String usr=user.getUsername();
		String pwd=user.getPassword();
		boolean validated=false;
		//ApplicationContext sp_context=new FileSystemXmlApplicationContext("file:E:/study/Java EE/webtrst/ssh1/untitled/src/applicationContext.xml");//改
		context=ActionContext.getContext();
		Map session=context.getSession();
		User user1=null;
		user1=(User)session.get("user");
		if(user1==null){
			user1 = userService.validateUser(usr,pwd);
			if(user1!=null){
				session.put("user", user1);
				validated=true;
			}
		}
		else{
			validated=true;
		}
		if(validated)
		{
			//验证成功返回字符串"success"
			return "success";
		}
		else{
			//验证失败返回字符串"error"
			return "error";
		}

	}
	public String register() {
	    User u = new User(user.getUsername(),user.getPassword());
	    User user1 = null;
	    user1 = userService.registerUser(u);
	    if(user1 != null) {
			context=ActionContext.getContext();
	        Map session = context.getSession();
	        session.clear();
	        session.put("user",user1);
	        return SUCCESS;
        }
        return ERROR;
    }


	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}

}
