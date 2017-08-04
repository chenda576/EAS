package org.action;
import java.util.List;
import org.model.S;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class StuLoginAction extends ActionSupport{
	private S stu;
	public S getStu() {
		return stu;
	}
	public void setStu(S stu1) {
		this.stu = stu1;
	}
	public String execute() throws Exception{
		try{
			String no=stu.getStuNo();
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query=session.createQuery("from S where stuNo=?");
			query.setParameter(0,no);
			List <?>list=query.list();
			S s_out=(S) list.get(0);
			String pw=MessageDigestUtil.digestByMD5(stu.getPassword().trim());
			if(s_out.getPassword().trim().equals(pw)){
				stu.setName(s_out.getName());
				stu=s_out;
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
