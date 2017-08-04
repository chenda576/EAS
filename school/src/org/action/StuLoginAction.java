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
			// ����HibernateSessionFactory��getSession��������Session����
			Transaction ts=session.beginTransaction();// �����������
			Query query=session.createQuery("from S where stuNo=?");
			query.setParameter(0,no);
			List <?>list=query.list();
			S s_out=(S) list.get(0);
			String pw=MessageDigestUtil.digestByMD5(stu.getPassword().trim());
			if(s_out.getPassword().trim().equals(pw)){
				stu.setName(s_out.getName());
				stu=s_out;
				ts.commit();  // �ύ����
				HibernateSessionFactory.closeSession();// �ر�Session
				return SUCCESS;
			}
			else{
				ts.commit();  // �ύ����
				HibernateSessionFactory.closeSession();// �ر�Session
				return INPUT;
			}
		}
		catch(Exception e){
			return ERROR;
		}
	}
}
