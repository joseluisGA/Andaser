/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import HibernateConfiguration.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author minit
 */
public class SubCategoriaDao {
     public List<Subcategoria> loadAllFromCategoria(int id){
		
		List<Subcategoria> list = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			list = session.createQuery("FROM Subcategoria where id_categoria="+id).list(); 
			 
			tx.commit(); 
		} catch (HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
    
}
