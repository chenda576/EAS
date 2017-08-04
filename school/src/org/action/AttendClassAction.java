package org.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.C;
import org.model.S;
import org.model.T;
import org.model.X;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class AttendClassAction extends ActionSupport{
	private String noc;
	private String tn;
	private String no;
	private S stu;
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
	public S getStu() {
		return stu;
	}
	public void setStu(S stu) {
		this.stu = stu;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String execute() throws Exception
	{
		try{
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			// 创建POJO类对象
			X xk_f=new X();
			
			Query query=session.createQuery("from S where stuNo=? ");
			query.setParameter(0,no);
			List<?> slist=query.list();
			S xk_s=(S)slist.get(0);
			stu=xk_s;
			xk_f.setS(xk_s);
			
			query=session.createQuery("from C where cNo=?");
			query.setParameter(0,noc);
			List<?> clist=query.list();
			C xk_c=(C) clist.get(0);
			xk_f.setC(xk_c);
			
			query=session.createQuery("from T where tNo=? ");
			query.setParameter(0,tn);
			List<?> tlist=query.list();
			T xk_t=(T) tlist.get(0);
			xk_f.setT(xk_t);
			
			session.save(xk_f);// 保存对象
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
