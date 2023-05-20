package com.supriya.test.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.supriya.dao.SmartBuildingDAOImpl;
import com.supriya.dao.UserDataAccessImpl;
import com.supriya.service.SmartBuildingServiceImpl;
import com.supriya.service.UserDataServiceImpl;




@Configuration
@EnableWebMvc
public class AppRequestRegistry implements WebMvcConfigurer{
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.port}")
	private String dbPort;
	
	@Value("${db.user.name}")
	private String dbUserName;
	
	@Value("${db.user.pass}")
	private String dbUserPass;
	
	@Value("${db.server.url}")
	private String dbServerUrl;
	
	@Autowired
	AppRequestHandler appRequestHandler;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(appRequestHandler);
	}
	
	
	@Bean
	public UserDataServiceImpl userDataServiceImpl() {
		return new UserDataServiceImpl();
	}
	
	@Bean
	public UserDataAccessImpl userDataAccessImpl() {
		return new UserDataAccessImpl();
	}  
	
	@Bean
	public SmartBuildingServiceImpl  smartBuildingService() {
		return new SmartBuildingServiceImpl();
	}
	
	@Bean
	public SmartBuildingDAOImpl smartBuildingDAO() {
		return new SmartBuildingDAOImpl();
	} 
	
	@Bean
	public DataSource myPostgresDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		String connUrl = "jdbc:postgresql://"+dbServerUrl+":"+dbPort+"/"+dbName;
		System.out.println("connUrl -> "+ connUrl);
		dataSource.setUrl(connUrl);
		jdbc:postgresql://localhost:5432/shopme
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbUserPass);

		return dataSource;
	}
	
	/*
	 * @Bean public Connection postgresConnection() { Connection c = null; try {
	 * Class.forName("org.postgresql.Driver"); c = DriverManager
	 * .getConnection("jdbc:postgresql://"+dbServerUrl+":5432/"+dbName, dbUserName,
	 * dbUserPass); } catch (ClassNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return c;
	 * 
	 * 
	 * }
	 */
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

	
}
