package DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtil;
import entities.LoaiMonAn;

public class LoaiMonAnDAO {
	public static List<LoaiMonAn> layDanhSachLoaiMonAn(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<LoaiMonAn> list = null;
		try {
			String hql = "from LoaiMonAn ";
			Query query = session.createQuery(hql);
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	
	public static LoaiMonAn layThongTin(String maLoai) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		LoaiMonAn l = null;
		try {
			l = session.get(LoaiMonAn.class, maLoai);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return l;
	}
	
	public static void themLoaiMonAn(LoaiMonAn l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(l);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void suaLoaiMonAn(LoaiMonAn l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(l);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void xoaLoaiMonAn(LoaiMonAn l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.remove(l);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}