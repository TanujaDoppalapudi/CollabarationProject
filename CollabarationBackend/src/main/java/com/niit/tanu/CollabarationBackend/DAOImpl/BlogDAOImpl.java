package com.niit.tanu.CollabarationBackend.DAOImpl;



import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.tanu.CollabarationBackend.DAO.BlogDAO;
import com.niit.tanu.CollabarationBackend.Model.BlogModel;
import com.niit.tanu.CollabarationBackend.Model.UserPart;



@SuppressWarnings("deprecation")
@Repository("blogDAO")
@EnableTransactionManagement
public class BlogDAOImpl implements BlogDAO 
{
private static final Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) 
	{
		try 
		{
			this.sessionFactory = sessionFactory;
			log.info("Connection Established Successfully");
		} 
		catch (Exception ex) 
		{
			log.error("Failed to establish connection");
			ex.printStackTrace();
		}
	}
	@Transactional
	public boolean addBlog(BlogModel blogModel) {
		log.info("Add Blog Method Started");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blogModel);
			log.info("Add blog Method Success");
			return true;
		}
		catch(Exception ex)
		{
			log.error("Add blog has an Error");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean updateBlog(BlogModel blogModel) {
		log.info("Update Blog method Started");
		try
		{
			log.info("Update blog Success");
			sessionFactory.getCurrentSession().update(blogModel);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Update Blog Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean deleteBlog(BlogModel blogModel) {
		log.info("Delete Blog method Started");
		try
		{
			log.info("Delete blog Success");
			sessionFactory.getCurrentSession().delete(blogModel);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Delete Blog Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public BlogModel getBlog(String title) {
		log.debug("Starting of Method Get Blog "+title);
		try
		{
			BlogModel blogPart =  sessionFactory.getCurrentSession().get(BlogModel.class, title);
			blogPart.setErrorCode("200");
			blogPart.setErrorMsg("User Found");
			return blogPart;
		}
		catch(Exception ex)
		{
			UserPart userPart = new UserPart();
			ex.printStackTrace();
			userPart.setErrorCode("404");
			userPart.setErrorMsg("User Not Found");
			return null;
		}
	}
	@Transactional
	public List<BlogModel> getBlogByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<BlogModel> getAllBlogs() {
		log.info("Starting of List Method");
		String hql_string = "FROM Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		log.info("List Retrieved");
		return query.list();
	}
	/**public boolean addBlog(BlogModel blogPart) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean updateBlog(BlogModel blogPart) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteBlog(BlogModel blogPart) {
		// TODO Auto-generated method stub
		return false;
	}
	public BlogModel getBlog(String title) {
		// TODO Auto-generated method stub
		return null;
	}**/
	

	}
