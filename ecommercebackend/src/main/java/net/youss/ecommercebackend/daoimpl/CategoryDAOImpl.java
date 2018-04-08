package net.youss.ecommercebackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.youss.ecommercebackend.dao.ICategoryDAO;
import net.youss.ecommercebackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {
	
	@Autowired
	private SessionFactory sessionfactory;


	
	@Override
	public List<Category> list() {
		String selectActiveCats = "FROM Category WHERE active =:active";
		Query query = sessionfactory.getCurrentSession().createQuery(selectActiveCats);
		query.setParameter("active", true);
		return query.list();
	}

	@Override
	public Category get(int id) {
		
		
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionfactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
           e.printStackTrace();
           return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
           e.printStackTrace();
           return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
           e.printStackTrace();
           return false;
		}
	}
	
	

}
