package org.action;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.model.O;
import org.model.S;
import org.model.X;
import org.hibernate.jdbc.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LookClassTableAction extends ActionSupport{
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
			
			SQLQuery Squery = session.createSQLQuery("select o.cNo,o.tNo,o.time,o.addr,o.term from O as o,X as x where x.stuNo=? and x.cNo=o.cNo and x.tNo=o.tNo").addEntity(O.class);
			Squery.setString(0, no);
			List<?> olist=Squery.list();
			O tempO=new O();
			String [][]schedule=new String [8][5];
			String tempTime;
			char tempWeek;
			for (int i = 0; i < olist.size(); i++)
			{
				tempO=(O) olist.get(i);
				tempTime=tempO.getTime().toString();
				tempWeek=tempTime.charAt(0);
				if(tempWeek=='一'){
					tempWeek=0;
				}
				else if(tempWeek=='二'){
					tempWeek=1;
				}
				else if(tempWeek=='三'){
					tempWeek=2;
				}
				else if(tempWeek=='四'){
					tempWeek=3;
				}
				else{
					tempWeek=4;
				}
				schedule[(int)tempTime.charAt(1)-'1'][tempWeek]=tempO.getId().getC().getCno();
				schedule[(int)tempTime.charAt(3)-'1'][tempWeek]=tempO.getId().getC().getCno();
			}
			for(int j=0;j<8;j++){
				for(int k=0;k<5;k++){
					System.out.print(schedule[j][k]);
				}
				System.out.println();
			}
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("schedule",schedule);
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
