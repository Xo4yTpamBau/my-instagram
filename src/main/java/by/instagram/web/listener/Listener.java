package by.instagram.web.listener;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {

    public static DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("root");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setInitialSize(10);
        ds.setMaxTotal(20);
        dataSource = ds;
    }

}
