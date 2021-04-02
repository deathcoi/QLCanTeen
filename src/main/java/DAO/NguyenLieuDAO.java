package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.LoaiMonAn;
import entities.MonAn;
import entities.NguyenLieu;

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
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<NguyenLieu> list = null;
		try {
			String hql = "from NguyenLieu ";
			Query query = session.createQuery(hql);
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public static NguyenLieu layThongTinNguyenLieu(String mlnl) {
		NguyenLieu n = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			n = session.get(NguyenLieu.class, mlnl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
		
	}
}
