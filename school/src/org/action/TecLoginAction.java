package org.action;
import java.util.List;

import org.model.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class TecLoginAction extends ActionSupport{
	private T tec;
	public T getTec() {
		return tec;
	}
	public void setTec(T tec1) {
		this.tec = tec1;
	}
	public String execute() throws Exception{
		try{
			String no=tec.getTno();
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query=session.createQuery("from T where tNo=?");
			query.setParameter(0,no);
			List <?>list=query.list();
			T t_out=(T) list.get(0);
			String pw=MessageDigestUtil.digestByMD5(tec.getPassword().trim());
			if(t_out.getPassword().trim().equals(pw)){
				tec=t_out;
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
			return ERROR;
		}
	}
}
