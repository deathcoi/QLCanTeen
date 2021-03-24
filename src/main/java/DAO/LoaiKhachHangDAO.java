package DAO;

import org.hibernate.Session;

import Utils.HibernateUtil;
import entities.LoaiKhachHang;
public class LoaiKhachHangDAO {
	public static LoaiKhachHang layThongTinLoaiKhachHangTheoMa(String ma) {
		LoaiKhachHang k = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			k = session.get(LoaiKhachHang.class, ma);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return k;
	}
}
