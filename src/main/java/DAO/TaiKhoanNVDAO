package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Utils.HibernateUtil;
import entities.TaiKhoanNV;

public class TaiKhoanNVDAO {
	public static TaiKhoanNV layThongTinTK(String tenTK) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TaiKhoanNV taiKhoanNV = null;
		try {
			taiKhoanNV = (TaiKhoanNV) session.get(TaiKhoanNV.class, tenTK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return taiKhoanNV;
	}
	
	public static void themTaiKhoanNV(TaiKhoanNV nhanVien) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(nhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}
	
	public static void xoaTaiKhoanNV(TaiKhoanNV nhanVien) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.remove(nhanVien);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
		}
	}
	
	public static void DoiMatKhau(TaiKhoanNV nv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(nv);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
