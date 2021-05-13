package DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.CTHoaDon;
import entities.HoaDon;

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
	
	public static List<CTHoaDon> layDanhSachCTHoaDon(HoaDon hoaDon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CTHoaDon> list = null;
		try {
			String hql = "from CTHoaDon c where c.hoaDon = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, hoaDon);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
