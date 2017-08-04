package org.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.S;
import org.model.D;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class StuRegisterAction extends ActionSupport{
	private S stu;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public S getStu() {
		return stu;
	}
	public void setStu(S stu1) {
		this.stu = stu1;
	}
	public String execute() throws Exception{
		try{
			String pw;
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			S xs=new S();  // 创建POJO类对象
			Query query=session.createQuery("from D where deptNo=? ");
			query.setParameter(0,stu.getD().getDeptNo());
			List<?> list=query.list();
			D d=(D) list.get(0);
			xs.setD(d);
			xs.setStuNo(stu.getStuNo().trim());
			xs.setName(stu.getName().trim());
			xs.setD(d);
			pw=stu.getPassword();
			if(pw.trim().equals("")){
				pw=stu.getStuNo().trim();
			}
			pw=MessageDigestUtil.digestByMD5(pw);
			xs.setPassword(pw);
			xs.setGender(stu.getGender());
			xs.setBirth(stu.getBirth());
			session.save(xs);// 保存对象
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
