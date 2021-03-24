package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Utils.HibernateUtil;
import entities.CTHoaDon;

public class CTHoaDonDAO {
	public static void themHoaDon(CTHoaDon cTHoaDon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(cTHoaDon);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
