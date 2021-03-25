package DAO;

import java.util.Date;
import java.util.List;

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
			String hql = "from HoaDon order by ngayLap desc";
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
	
	public static List<HoaDon> layDanhSacHoaDonTheoNgay(Date tuNgay, Date denNgay) {
		List<HoaDon> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from HoaDon h where h.ngayLap >= ?0 "
					+ " AND h.ngayLap <= ?1";
			Query query = session.createQuery(hql);
			query.setParameter(0, tuNgay);
			query.setParameter(1, denNgay);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<HoaDon> layDanhSacHoaDon() {
		List<HoaDon> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from HoaDon";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static HoaDon layThongTinHoaDon(String maHD) {
		HoaDon hoaDon = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			hoaDon = session.get(HoaDon.class, maHD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return hoaDon;
	}
}
