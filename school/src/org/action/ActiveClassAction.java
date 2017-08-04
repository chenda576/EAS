package org.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.OId;
import org.model.O;
import org.model.C;
import org.model.T;
import org.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
public class ActiveClassAction extends ActionSupport{
	private OId actp;
	private O act;
	private String error;
	public OId getActp() {
		return actp;
	}
	public void setActp(OId actp) {
		this.actp = actp;
	}
	public O getAct() {
		return act;
	}
	public void setAct(O act) {
		this.act = act;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String execute() throws Exception{
		try{
			Session session=HibernateSessionFactory.getSession();
			// 调用HibernateSessionFactory的getSession方法创建Session对象
			Transaction ts=session.beginTransaction();// 创建事务对象
			OId kcp=new OId();  // 创建POJO类对象
			O kc=new O();
			Query query=session.createQuery("from C where cNo=? ");
			query.setParameter(0,actp.getC().getCno());
			List<?> clist=query.list();
			C c=(C) clist.get(0);
			kcp.setC(c);
			query=session.createQuery("from T where tNo=? ");
			query.setParameter(0,actp.getT().getTno());
			List<?> tlist=query.list();
			T t=(T) tlist.get(0);
			kcp.setT(t);
			kcp.setTerm(actp.getTerm());
			kc.setId(actp);
			kc.setTime(act.getTime());
			kc.setAddr(act.getAddr());
			session.save(kc);// 保存对象
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
