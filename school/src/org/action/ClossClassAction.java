package org.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.C;
import org.model.OId;
import org.model.O;
import org.model.T;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
public class ClossClassAction extends ActionSupport{
	private String noc;
	private String tn;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// ����HibernateSessionFactory��getSession��������Session����
			Transaction ts=session.beginTransaction();// �����������
			OId delID=new OId();
			Query query=session.createQuery("from C where cNo=?");
			query.setParameter(0,noc);
			List<?> clist=query.list();
			C xk_c=(C) clist.get(0);
			delID.setC(xk_c);
			
			query=session.createQuery("from T where tNo=? ");
			query.setParameter(0,tn);
			List<?> tlist=query.list();
			T xk_t=(T) tlist.get(0);
			delID.setT(xk_t);
			
			delID.setTerm("15-16�ļ�ѧ��");
			
			O o=(O)session.get(O.class, delID);
			session.delete(o);
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
