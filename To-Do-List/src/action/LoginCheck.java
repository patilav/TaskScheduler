package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.*;
import bean.LoginBean;

public class LoginCheck extends ActionSupport implements ModelDriven<LoginBean>, SessionAware{
	
	
	LoginBean lb;
	Map<String, Object> map;
	
	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public String execute()
	{
		
	String role = null;
	LoginDAO obj = new LoginDAO();
	//System.out.println(lb.getUsername());
	//System.out.println(lb.getPassword());
	
	role=obj.validateLogin(lb.getUsername(),lb.getPassword());
	
	
	
	if(role.equals("admin"))
	{
		map.put("name", lb.getUsername());
		return "admin";
	}
	
	else  if(role.equals("match"))
	{
		map.put("name", lb.getUsername());
		return "user";
	}
	else{
		return "error";
	}
}

	
	public LoginBean getModel() {
		if(lb==null)
		lb=new LoginBean();
		return lb;
	}

	
	public void setSession(Map<String, Object> arg0) {
		this.map=arg0;
		
	}

}
