package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Utils.HibernateUtil;
import entities.NguyenLieu;

public class NguyenLieuDAO {
	public static void updateNguyenLieu(NguyenLieu nguyenLieu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(nguyenLieu);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
