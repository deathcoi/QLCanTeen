package DAO;

import org.hibernate.Session;

import Utils.HibernateUtil;
import entities.NhanVien;

public class NhanVienDAO {
	public static NhanVien layThongTinNhanVien(String maNV){
		NhanVien nhanVien = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			nhanVien = session.get(NhanVien.class, maNV);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nhanVien;
	}
}
