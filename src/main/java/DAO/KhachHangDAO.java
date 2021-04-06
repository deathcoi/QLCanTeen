package DAO;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.lucene.analysis.fi.FinnishAnalyzer;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
	
	public static KhachHang layThongTinKhachHangTheoSDT(Long ma){
		KhachHang khachHang = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from KhachHang where sdt = ?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, ma);
			khachHang = (KhachHang) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return khachHang;
	}
	
	public static List<KhachHang> layThongTinKhachHang() {
		List<KhachHang> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query hql = session.createQuery("From KhachHang kh");
			list = hql.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public static List<KhachHang> timKiemThongTinKhachHang(String maLoai, String maKH, String tenKH, String gioiTinh, Integer namSinh, Long sdt) {
		List<KhachHang> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query hql = session.createQuery("From KhachHang kh");
			list = hql.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public static  void  suaKhachHang(KhachHang khachHang) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(khachHang);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}

