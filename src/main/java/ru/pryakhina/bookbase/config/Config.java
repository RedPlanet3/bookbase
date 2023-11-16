//package ru.pryakhina.bookbase.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//
//@ComponentScan("ru.pryakhina.bookbase")
//@PropertySource("classpath:hibernate.properties")
//@EnableTransactionManagement
//@EnableWebMvc
//public class Configure implements WebMvcConfigurer {
//
//    private final ApplicationContext applicationContext;
//    private final Environment env;
//
//    @Autowired
//    public Configure(ApplicationContext applicationContext, Environment env) {
//        this.applicationContext = applicationContext;
//        this.env = env;
//    }
////    @Bean
////    public InternalResourceViewResolver internalResourceViewResolver(){
////        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
////       internalResourceViewResolver.setApplicationContext(applicationContext);
////        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
////        internalResourceViewResolver.setSuffix(".jsp");
////        return internalResourceViewResolver;
////    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".jsp");
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
//@Bean
//public DataSource dataSource(){
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//    dataSource.setDriverClassName(env.getRequiredProperty("hibernate.driver_class"));
//    dataSource.setUrl(env.getRequiredProperty("hibernate.connection.url"));
//    dataSource.setUsername(env.getRequiredProperty("hibernate.connection.user"));
//    dataSource.setPassword(env.getRequiredProperty("hibernate.connection.password"));
//
//    return dataSource;
//}
//
//private Properties hibernateProperties()
//{
//    Properties properties = new Properties();
//    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
//    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
//    return properties;
//}
//
////@Bean
////public LocalSessionFactoryBean sessionFactoryBean() {
////
////    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
////    sessionFactoryBean.setDataSource(dataSource());
////    sessionFactoryBean.setPackagesToScan("ru.pryakhina.bookbase.models");
////    sessionFactoryBean.setHibernateProperties(hibernateProperties());
////    return sessionFactoryBean;
////}
//
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("ru.pryakhina.bookbase.models");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }
//
//
//
//@Bean
//public PlatformTransactionManager hibernateTransactionManager(){
//    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//    hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
//    return hibernateTransactionManager;
//}

