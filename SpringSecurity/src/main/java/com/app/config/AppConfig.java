package com.app.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.model.Product;

@Configuration
@ComponentScan(basePackages = {"com.app"})
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:app.properties")
@EnableWebMvc
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.un"));
		ds.setPassword(env.getProperty("db.pwd"));

		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource());
		lsfb.setHibernateProperties(hibernateProps());
		lsfb.setAnnotatedClasses(Product.class);

		return lsfb;

	}

	@Bean
	public Properties hibernateProps() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("hb.dialect"));
		p.put("hibernate.show_sql", env.getProperty("hb.showsql"));
		p.put("hibernate.format_sql", env.getProperty("hb.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("hb.ddlauto"));

		return p;
	}

	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate htt = new HibernateTemplate();
		htt.setSessionFactory(sessionFactory().getObject());
		return htt;
	}

	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager hm = new HibernateTransactionManager();
		hm.setSessionFactory(sessionFactory().getObject());
		return hm;

	}

}
