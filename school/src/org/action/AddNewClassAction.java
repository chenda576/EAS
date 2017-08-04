package org.action;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.C;
import org.model.D;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class AddNewClassAction extends ActionSupport{
	private C cla;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public C getCla() {
		return cla;
	}
	public void setCla(C cla1) {
		this.cla = cla1;
	}
	public String execute() throws Exception{
		try{
			Integer rt;
			Integer xf;
			Session session=HibernateSessionFactory.getSession();
			// ����HibernateSessionFactory��getSession��������Session����
			Transaction ts=session.beginTransaction();// �����������
			C kc=new C();  // ����POJO�����
			Query query=session.createQuery("from D where deptNo=? ");
			query.setParameter(0,cla.getD().getDeptNo());
			List<?> list=query.list();
			D d=(D) list.get(0);
			kc.setD(d);
			kc.setCno(cla.getCno().trim());
			kc.setCname(cla.getCname().trim());
			rt=cla.getRate();
			if(rt==null){
				rt=40;
			}
			kc.setRate(rt);
			xf=cla.getCredit();
			if(xf==null){
				xf=4;
			}
			kc.setCredit(xf);
			session.save(kc);// �������
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
