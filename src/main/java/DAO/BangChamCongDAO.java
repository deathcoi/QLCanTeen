package DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.BangChamCong;

public class BangChamCongDAO {
	public static List<BangChamCong> layDanhSachBangChamCong(){
		List<BangChamCong> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from BangChamCong";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<BangChamCong> layDanhSachBangChamCongTheoNgay(Date tuNgay, Date denNgay) {
		List<BangChamCong> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from BangChamCong h where h.batDau >= ?0 "
					+ " AND h.batDau <= ?1";
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
	
	public static List<BangChamCong> layDanhSachBangChamCongTheoNgayVaMa(Date tuNgay, Date denNgay, String maNV) {
		List<BangChamCong> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from BangChamCong h where h.batDau >= ?0 "
					+ " AND h.batDau <= ?1"
					+ " AND h.nhanVien.maNV = ?2";
			Query query = session.createQuery(hql);
			query.setParameter(0, tuNgay);
			query.setParameter(1, denNgay);
			query.setParameter(2, maNV);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static BangChamCong layThongTinBCCTheoMaNV(String maNV) {
		BangChamCong bangChamCong = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from BangChamCong h where h.nhanVien.maNV = ?0 ORDER BY h.batDau desc";
			Query query = session.createQuery(hql);
			query.setParameter(0, maNV);
			bangChamCong = (BangChamCong) query.setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bangChamCong;
	}
	
	public static void themBCC(BangChamCong bcc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bcc);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static void suaBCC(BangChamCong bcc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(bcc);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
