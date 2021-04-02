package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.MonAn;
import entities.NhanVien;

public class MonAnDAO {
	public static List<MonAn> layDanhSachMonAn() {
		List<MonAn> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from MonAn m";
			list = session.createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public static MonAn layThongTinMonAn(String maMA) {
		MonAn monAn = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			monAn = session.get(MonAn.class, maMA);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return monAn;
	}

	public static MonAn layThongTinMonAnTheoTen(String tenMA) {
		MonAn monAn = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from MonAn m where m.tenMA = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, tenMA);
			monAn = (MonAn) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return monAn;
	}

	public static void themMonAn(MonAn monan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(monan);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void xoaMonAn(MonAn monan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.remove(monan);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static void suaMonAn(MonAn monan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(monan);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
