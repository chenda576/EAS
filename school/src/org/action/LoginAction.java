package org.action;
import java.util.List;
import org.model.S;
import org.model.T;
import org.model.A;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private String no;
	private String password;
	private S stu;
	private T tec;
	private A ad;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public S getStu() {
		return stu;
	}
	public void setStu(S stu1) {
		this.stu = stu1;
	}
	public T getTec() {
		return tec;
	}
	public void setTec(T tec) {
		this.tec = tec;
	}
	public A getAd() {
		return ad;
	}
	public void setAd(A ad) {
		this.ad = ad;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			if(no.length()==8){
				Query queryS=session.createQuery("from S where stuNo=?");
				queryS.setParameter(0,no);
				List <?>slist=queryS.list();
				S s_out=(S) slist.get(0);
				String pw=MessageDigestUtil.digestByMD5(password.trim());
				if(s_out.getPassword().trim().equals(pw)){
					stu=s_out;
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return "stuSUCCESS";
				}
				else{
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return INPUT;
				}
			}
			else if(no.length()==4){
				Query queryT=session.createQuery("from T where tNo=?");
				queryT.setParameter(0,no);
				List <?>tlist=queryT.list();
				T t_out=(T) tlist.get(0);
				String pw=MessageDigestUtil.digestByMD5(password.trim());
				if(t_out.getPassword().trim().equals(pw)){
					tec=t_out;
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return "tecSUCCESS";
				}
				else{
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return INPUT;
				}
			}
			else{
				Query queryA=session.createQuery("from A where id=?");
				queryA.setParameter(0,no);
				List <?>alist=queryA.list();
				A a_out=(A) alist.get(0);
				if(a_out.getPassword().trim().equals(password.trim())){
					ad=a_out;
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return "adminSUCCESS";
				}
				else{
					ts.commit();  // 提交事务
					HibernateSessionFactory.closeSession();// 关闭Session
					return INPUT;
				}
			}
		}
		catch(Exception e){
			this.setError(e.toString());
			return ERROR;
		}
	}
}
