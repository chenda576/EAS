package org.action;
import java.util.List;
import java.util.Map;

import org.model.G;
import org.model.GId;
import org.model.T;
import org.model.C;
import org.model.S;
import org.model.X;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class GaveGradeAction extends ActionSupport{
	private List<?> nlist;
	private List<?> tlist;
	private T tec;
	private C cla;
	private S stu;
	private String error;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<?> getNlist() {
		return nlist;
	}
	public void setNlist(List<?> nlist) {
		this.nlist = nlist;
	}
	public List<?> getTlist() {
		return tlist;
	}
	public void setTlist(List<?> tlist) {
		this.tlist = tlist;
	}
	public T getTec() {
		return tec;
	}
	public void setTec(T tec) {
		this.tec = tec;
	}
	public C getCla() {
		return cla;
	}
	public void setCla(C cla) {
		this.cla = cla;
	}
	public String execute() throws Exception{
		try{
			String noc=cla.getCno();
			String not=tec.getTno();
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
		 
			Query queryT=session.createQuery("from T where tNo=?");
			queryT.setParameter(0,not);
			queryT.setMaxResults(1);
			T xk_t=(T)queryT.uniqueResult();
			tec=xk_t;
			
			Query queryC=session.createQuery("from C where cNo=?");
			queryC.setParameter(0,noc);
			queryC.setMaxResults(1);
			C xk_c=(C)queryC.uniqueResult();
			cla=xk_c;
			
			Query query=session.createQuery("from X where cNo=? and tNo=?");
			query.setParameter(0,noc);
			query.setParameter(1,not);
			List<?> cclist=query.list();
			
			Query queryO=session.createQuery("from O where tNo=?");
			queryO.setParameter(0,not);
			List<?> colist=queryO.list();
			
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("colist",colist);
			
			GId gid=new GId();
			gid.setC(xk_c);
			gid.setT(xk_t);
			String no;
			for(int i=0;i<cclist.size();i++){
				Transaction ts=session.beginTransaction();// 创建事务对象
				X xs=(X) cclist.get(i);
				no=xs.getS().getStuNo();
				
				Query queryS=session.createQuery("from S where stuNo=?");
				queryS.setParameter(0,no);
				queryS.setMaxResults(1);
				S xk_s=(S)queryS.uniqueResult();
				stu=xk_s;
				
				gid.setS(stu);
				gid.setTerm("15-16夏季学期");
				G g=(G) session.get(G.class,gid);
				String ng=(String) nlist.get(i);
				String tg=(String) tlist.get(i);
				g.setNgrade(Integer.valueOf(ng));
				g.setTgrade(Integer.valueOf(tg));
				session.update(g);
				ts.commit();  // 提交事务
			}
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
