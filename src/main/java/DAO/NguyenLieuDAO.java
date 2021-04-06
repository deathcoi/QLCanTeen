package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import Utils.HibernateUtil;
import entities.NguyenLieu;
import entities.NhanVien;

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
	
	public static List<NguyenLieu> layDanhSachNguyenLieu(){
		List<NguyenLieu> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from NguyenLieu n";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static void themNguyenLieu(NguyenLieu nguyenLieu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(nguyenLieu);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void suaNguyenLieu(NguyenLieu nguyenLieu){
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
