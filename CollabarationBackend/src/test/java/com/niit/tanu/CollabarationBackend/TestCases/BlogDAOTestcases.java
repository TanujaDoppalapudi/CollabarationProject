package com.niit.tanu.CollabarationBackend.TestCases;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.tanu.CollabarationBackend.DAO.BlogDAO;
import com.niit.tanu.CollabarationBackend.Model.BlogModel;


public class BlogDAOTestcases 
{
	Logger log = LoggerFactory.getLogger(BlogDAOTestcases.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	BlogModel blogModel;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public BlogDAOTestcases()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.tanu.CollabarationBackend");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blogModel = (BlogModel) context.getBean("blogModel");
		
	}
   public void blogAdd()
   {
	   log.info("Add blog Test started");
	  
	   blogModel.setDescription("Here it contains username title and some other details...");
	   blogModel.setUsername("rajipapanaboina");
	   blogModel.setBlog_title("Fresher_Gradguate");
	   blogModel.setDate_time("DATE_TIME");
	   
	   blogDAO.addBlog(blogModel);
	   log.info("Add Blog Test end");
   }
   public void UpdateBlog()
  	{
  		log.info("Update Success initiated.");
  		blogModel = blogDAO.getBlog("testBlog");
  		blogDAO.updateBlog(blogModel);
  		log.info("Update Success");
  	}
   public void deleteBlog()
	{
		log.info("Delete Success initiated.");
		blogModel = blogDAO.getBlog("testBlog");
		blogDAO.deleteBlog(blogModel);
		log.info("Delete Success");
	}
   public static void main(String[] args) 
	{
	   BlogDAOTestcases tblog = new  BlogDAOTestcases ();
//		tblog.blogAdd();
	    tblog.UpdateBlog();
//		tblog.deleteBlog();
//		tblog.list();
		
		System.out.println("Success");
	}
   
}
