package com.niit.tanu.CollabarationBackend.DAO;



import java.util.List;
import com.niit.tanu.CollabarationBackend.Model.*;
public interface BlogDAO 
{
	public boolean addBlog(BlogModel blogPart);
	public boolean updateBlog(BlogModel blogPart);	
	public boolean deleteBlog(BlogModel blogPart);
	public BlogModel getBlog(String title);
	public List<BlogModel> getBlogByUser(String username);
	public List<BlogModel> getAllBlogs();

}
