package org.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.A;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
public class AdLoginAction extends ActionSupport{
	private A ad;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public A getAd() {
		return ad;
	}
	public void setAd(A ad1) {
		this.ad = ad1;
	}
	public String execute() throws Exception{
		try{
			String id=ad.getId();
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query=session.createQuery("from A where id=?");
			query.setParameter(0,id);
			List <?>list=query.list();
			A a_out=(A) list.get(0);
			if(a_out.getPassword().trim().equals(ad.getPassword().trim())){
				ts.commit();  // 提交事务
				HibernateSessionFactory.closeSession();// 关闭Session
				return SUCCESS;
			}
			else{
				ts.commit();  // 提交事务
				HibernateSessionFactory.closeSession();// 关闭Session
				return INPUT;
			}
		}
		catch(Exception e){
			this.setError(e.toString());
			return ERROR;
		}
	}
}

