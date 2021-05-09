package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.NhanVien;

public class NhanVienDAO {
	public static NhanVien layThongTinNhanVien(String maNV){
		NhanVien nhanVien = null;
		Session session = HibernateUtil.getSessionFactory().openSession(); //khởi động hibernate để lấy dữ liệu
		try {
			nhanVien = session.get(NhanVien.class, maNV);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nhanVien;
	}
	
	public static List<NhanVien> layDanhSachNhanVien(){
		List<NhanVien> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from NhanVien";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static void themNhanVien(NhanVien nhanVien){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(nhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void xoaNhanVien(NhanVien nhanVien) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.remove(nhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void suaNhanVien(NhanVien nhanVien) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(nhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
