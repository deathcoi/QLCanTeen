package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.KhachHang;

public class KhachHangDAO {
	public static KhachHang layThongTinKhachHang(String ma) {
		KhachHang khachHang = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			khachHang = session.get(KhachHang.class, ma);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	public static List<KhachHang> layDanhSachKhachHangTheoSDT(Long ma){
		List<KhachHang> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query hql = session.createQuery("From KhachHang as kh where kh.sdt = ?0");
			hql.setParameter(0, ma);
			//Query hql = session.createQuery("From KhachHang");
			list = hql.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<KhachHang> layDanhSachKhachHangTheoSDT(String ma){
		List<KhachHang> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
