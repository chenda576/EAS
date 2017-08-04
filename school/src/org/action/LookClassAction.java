package org.action;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.model.S;
import org.hibernate.jdbc.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LookClassAction extends ActionSupport{
	private S stu;
	private String no;
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
	public void setStu(S stu) {
		this.stu = stu;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String execute() throws Exception{
		try{	
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query=session.createQuery("from S where stuNo=? ");
			query.setParameter(0,no);
			List<?> slist=query.list();
			S xk_s=(S)slist.get(0);
			stu=xk_s;
			
			SQLQuery Squery = session.createSQLQuery("{Call selectClassChoose(?)}");
			Squery.setString(0, no);
			List<?> olist=Squery.list();
			
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("olist",olist);
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
