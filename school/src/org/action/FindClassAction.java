package org.action;
import java.util.List;
import java.util.Map;
import org.model.C;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FindClassAction extends ActionSupport{
	private List<?> cList;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<?> getcList() {
		return cList;
	}
	public void setcList(List<?> cList) {
		this.cList = cList;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// ����HibernateSessionFactory��getSession��������Session����
			Transaction ts=session.beginTransaction();// �����������
			Query query=session.createQuery("from C");
			cList=query.list();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("clist",cList);
			ts.commit();  // �ύ����
			HibernateSessionFactory.closeSession();// �ر�Session
			return SUCCESS;
		}
		catch(Exception e){
			this.setError(e.toString());
			return ERROR;
		}
	}
}
