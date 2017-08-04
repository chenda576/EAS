package org.action;
import java.util.List;
import java.util.Map;
import org.model.GId;
import org.model.S;
import org.model.T;
import org.model.C;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LookGradeAction extends ActionSupport{
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
			
			Query querys=session.createQuery("from G where stuNo=?");
			querys.setParameter(0,no);
			List<?> glist=querys.list();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("glist",glist);
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
