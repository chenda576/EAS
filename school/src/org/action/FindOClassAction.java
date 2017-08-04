package org.action;
import java.util.List;
import java.util.Map;
import org.model.OId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FindOClassAction extends ActionSupport{
	private List<?> oList;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<?> getoList() {
		return oList;
	}
	public void setoList(List<?> oList) {
		this.oList = oList;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// ����HibernateSessionFactory��getSession��������Session����
			Transaction ts=session.beginTransaction();// �����������
			Query query=session.createQuery("from O");
			oList=query.list();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("olist",oList);
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
