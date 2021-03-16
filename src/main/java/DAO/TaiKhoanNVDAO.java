package DAO;

import org.hibernate.Session;

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
}
