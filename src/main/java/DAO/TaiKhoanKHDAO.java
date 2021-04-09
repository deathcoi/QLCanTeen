package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Utils.HibernateUtil;
import entities.LoaiMonAn;
import entities.TaiKhoanKH;

public class TaiKhoanKHDAO {
	public static TaiKhoanKH layThongTinTK(String tenTK) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TaiKhoanKH taiKhoanKH = null;
		try {
			taiKhoanKH = (TaiKhoanKH) session.get(TaiKhoanKH.class, tenTK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return taiKhoanKH;
	}
	public static void DoiMatKhau(TaiKhoanKH kh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(kh);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
