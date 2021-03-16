package DAO;

import org.hibernate.Session;

import Utils.HibernateUtil;
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
}
