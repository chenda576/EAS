package org.action;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.T;
import org.model.D;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class TecRegisterAction extends ActionSupport{
	private T tec;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public T getTec() {
		return tec;
	}
	public void setTec(T tec1) {
		this.tec = tec1;
	}
	public String execute() throws Exception{
		try{
			String pw;
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			T js=new T();  // 创建POJO类对象
			Query query=session.createQuery("from D where deptNo=? ");
			query.setParameter(0,tec.getD().getDeptNo());
			List<?> list=query.list();
			D d=(D) list.get(0);
			js.setD(d);
			js.setTno(tec.getTno().trim());
			js.setTname(tec.getTname().trim());
			pw=tec.getPassword();
			if(pw.trim().equals("")){
				pw=tec.getTno().trim();
			}
			pw=MessageDigestUtil.digestByMD5(pw);
			js.setPassword(pw);
			js.setAddr(tec.getAddr());
			session.save(js);// 保存对象
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
