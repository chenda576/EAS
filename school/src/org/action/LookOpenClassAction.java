package org.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.model.GId;
import org.model.S;
import org.model.T;
import org.model.C;
import org.model.O;
import org.model.OId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LookOpenClassAction extends ActionSupport{
	private OId xk;
	private S stu;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public OId getXk() {
		return xk;
	}
	public void setXk(OId xk) {
		this.xk = xk;
	}
	public S getStu() {
		return stu;
	}
	public void setStu(S stu) {
		this.stu = stu;
	}
	
	public String execute() throws Exception{
		try{
			String no=stu.getStuNo();
			String noc=xk.getC().getCno();
			String not=xk.getT().getTno();
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query1=session.createQuery("from S where stuNo=? ");
			query1.setParameter(0,no);
			List<?> slist=query1.list();
			S xk_s=(S)slist.get(0);
			stu=xk_s;
			
			Query query=session.createQuery("from O where cNo like ? and tNo like ?");
			query.setParameter(0,'%'+noc+'%');
			query.setParameter(1,'%'+not+'%');
			List<?> oclist=query.list();

			Map request=(Map)ActionContext.getContext().get("request");
			request.put("oclist",oclist);
			ts.commit();  // 提交事务
			HibernateSessionFactory.closeSession();// 关闭Session
			return SUCCESS;
		}
		catch(Exception e){
			this.setError(e.toString());
			return ERROR;
		}
	}
}
