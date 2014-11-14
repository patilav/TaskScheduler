package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import bean.EventBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import dao.EventAddDAO;
import dao.EventEditDAO;
import dao.EventViewDAO;


public class EventAction extends ActionSupport implements ModelDriven<EventBean>, SessionAware{

	String status=null;
	EventBean eb;		
	

	public EventBean getEb() {
		return eb;
	}


	public void setEb(EventBean eb) {
		this.eb = eb;
	}



	public String execute()
	{
		
	EventAddDAO ead= new EventAddDAO();
	//String ocr = eb.getOccurence().toString();
	
	System.out.println("name->"+eb.getName());
	System.out.println("venue->"+eb.getVenue());
	System.out.println("dates ->"+eb.getStartDate()+ " -- "+eb.getEndDate());
	System.out.println("occ"+eb.getOccurrence());
	
	status=ead.addEvent(eb.getName(),eb.getVenue(),eb.getStartDate(),eb.getEndDate(),eb.getOccurrence());
	
	if(status.equals("success"))
		{
		return "done";
		}
	
	else 
		{
		return "not done";
		}
	}
	

	public String eventEditAction()
	{
		
	EventEditDAO ead= new EventEditDAO();
	//String ocr = eb.getOccurence().toString();
	
	System.out.println("name->"+eb.getName());
	System.out.println("venue->"+eb.getVenue());
	System.out.println("dates ->"+eb.getStartDate()+ " -- "+eb.getEndDate());
	System.out.println("occ"+eb.getOccurrence());
	
	status=ead.editEvent(eb.getId(),eb.getName(),eb.getVenue(),eb.getStartDate(),eb.getEndDate(),eb.getOccurrence());
	
	if(status.equals("edit success"))
		{
		return "done";
		}
	
	else 
		{
		return "not done";
		}
	}
	
	public String viewEvents()
	{
		EventViewDAO ev = new EventViewDAO();
		 eb.setEventlist(ev.view(eb.getId()));
		 return "done";
	}
	
	
	public EventBean getModel() {
		if(eb==null)
			eb=new EventBean();
			return eb;
	
	}

	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
