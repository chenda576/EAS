package org.action;
import java.util.List;
import java.util.Map;
import org.model.O;
import org.model.T;
import org.model.C;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TecFindAction extends ActionSupport{
	private T tec;
	private C cla;
	private String no;
	private String noc;
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
	public void setCla(C cla) {
		this.cla = cla;
	}
	public T getTec() {
		return tec;
	}
	public void setTec(T tec) {
		this.tec = tec;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
		 
			Query queryT=session.createQuery("from T where tNo=?");
			queryT.setParameter(0,no);
			queryT.setMaxResults(1);
			T xk_t=(T)queryT.uniqueResult();
			tec=xk_t;
			
			Query queryC=session.createQuery("from C where cNo=?");
			queryC.setParameter(0,noc);
			queryC.setMaxResults(1);
			C xk_c=(C)queryC.uniqueResult();
			cla=xk_c;
			
			Query query=session.createQuery("from X where tNo=? and cNo=?");
			query.setParameter(0,no);
			query.setParameter(1,noc);
			List<?> cclist=query.list();
			
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("clist",cclist);
			
			ts.commit();  // 提交事务
			HibernateSessionFactory.closeSession();// 关闭Session
			return SUCCESS;
		}
		catch(Exception e){
			System.out.println(e);
			this.setError(e.toString());
			return ERROR;
		}
	}
}