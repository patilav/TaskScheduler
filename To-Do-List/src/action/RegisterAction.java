package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import bean.RegisterBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import dao.RegisterDAO;


public class RegisterAction extends ActionSupport implements ModelDriven<RegisterBean>, SessionAware{

	String status=null;
	RegisterBean rb;
	
		
	public RegisterBean getRb() {
		return rb;
	}


	public void setRb(RegisterBean rb) {
		this.rb = rb;
	}



	public String execute()
	{
		
	RegisterDAO rd= new RegisterDAO();
	//System.out.println("id is"+rb.getUsername());
	status=rd.registerCustomer(rb.getFname(),rb.getLname(),rb.getUsername(),rb.getPassword(),rb.getDob(),rb.getSecretQuestion(),rb.getSecretAnswer());
	
	//System.out.println(status);
	if(status.equals("done"))
		{
		return "done";
		}
	
	else 
		{
		return "input";
		}
	}
	

	
	public RegisterBean getModel() {
		if(rb==null)
			rb=new RegisterBean();
			return rb;
	
	}

	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
