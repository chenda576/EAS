package org.action;
import java.util.List;
import java.util.Map;

import org.model.X;
import org.model.C;
import org.model.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class TecFindClass extends ActionSupport{
	private String no;
	private T tec;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public T getTec() {
		return tec;
	}
	public void setTec(T tec) {
		this.tec = tec;
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
			
			Query query=session.createQuery("from O where tNo=?");
			query.setParameter(0,no);
			List<?> colist=query.list();
			
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("colist",colist);
			
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
