package com.niit.tanu.CollabarationBackend.OracleConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.tanu.CollabarationBackend.Model.Blog;
import com.niit.tanu.CollabarationBackend.Model.BlogComment;

import com.niit.tanu.CollabarationBackend.Model.Event;
import com.niit.tanu.CollabarationBackend.Model.FileUpload;
import com.niit.tanu.CollabarationBackend.Model.Forum;

import com.niit.tanu.CollabarationBackend.Model.ForumReply;
import com.niit.tanu.CollabarationBackend.Model.Friend;
import com.niit.tanu.CollabarationBackend.Model.Job;
import com.niit.tanu.CollabarationBackend.Model.JobApplied;
import com.niit.tanu.CollabarationBackend.Model.User;




@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class OracleConfiguration
{
	
		@Bean(name ="dataSource")
		public DataSource getDataSource()
		{
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setUsername("tanu");
			dataSource.setPassword("tanu");
			
			return dataSource;
		}
		
		private Properties getHibernateProperties()
		{
			Properties properties = new Properties();
			
			properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			properties.put("hibernate.show_sql", "true");
     		properties.put("hibernate.hbm2ddl.auto", "update");
			
			return properties;
		}
		
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(Blog.class);
		//	sessionBuilder.addAnnotatedClass(Job.class);
		//	sessionBuilder.addAnnotatedClass(JobApplied.class);
			sessionBuilder.addAnnotatedClass(Event.class);
			sessionBuilder.addAnnotatedClass(BlogComment.class);
			sessionBuilder.addAnnotatedClass(Forum.class);
			sessionBuilder.addAnnotatedClass(ForumReply.class);
			sessionBuilder.addAnnotatedClass(Friend.class);
			sessionBuilder.addAnnotatedClass(FileUpload.class);
			
			return sessionBuilder.buildSessionFactory();
		}
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
}