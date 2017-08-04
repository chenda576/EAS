package org.action;
import java.util.List;
import java.util.Map;
import org.model.G;
import org.model.GId;
import org.model.T;
import org.model.C;
import org.model.S;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InputGradeAction extends ActionSupport{
	private T tec;
	private C cla;
	private List<?> nlist;
	private List<?> tlist;
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
	public List<?> getNlist() {
		return nlist;
	}
	public void setNlist(List<?> nlist) {
		this.nlist = nlist;
	}
	public C getCla() {
		return cla;
	}
	public void setCla(C cla) {
		this.cla = cla;
	}
	public List<?> getTlist() {
		return tlist;
	}
	public void setTlist(List<?> tlist) {
		this.tlist = tlist;
	}
	public String execute() throws Exception{
		try{
			int a=0;
			a=a+1;
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			Query query=session.createQuery("from T where tNo=? ");
			query.setParameter(0,tec.getTno());
			List<?> tList=query.list();
			T t_out=(T) tList.get(0);
			tec=t_out;
			
			query=session.createQuery("from X where tNo=? and cNo=?");
			query.setParameter(0,tec.getTno());
			query.setParameter(1,cla.getCno());
			List<?> sList=query.list();
			
			GId gid=new GId();
			for(int i=0;i<nlist.size();i++){
				gid.setC(cla);
				gid.setT(tec);
				gid.setS((S) sList.get(i));
				G g=(G) session.get(G.class,gid);
				g.setNgrade((int)nlist.get(i));
				g.setTgrade((int)tlist.get(i));
			}
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
