package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.HoaDon;

public class HoaDonDAO {
	public static HoaDon taoHoaDonMoi() {
		HoaDon hoaDon = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from HoaDon order by maHD desc";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			hoaDon = (HoaDon) query.uniqueResult();
			if (hoaDon == null) {
				hoaDon = new HoaDon();
				hoaDon.setMaHD("hd1");
			} else {
				String str = hoaDon.getMaHD().substring(2);
				Integer num = Integer.parseInt(str);
				num++;
				hoaDon = new HoaDon();
				hoaDon.setMaHD("hd" + num.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return hoaDon;
	}

	public static void themHoaDon(HoaDon hoaDon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(hoaDon);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
