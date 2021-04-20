package utils;

import models.History;
import models.Security;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                File file = new File("");
                Configuration configuration = new Configuration().configure();

                //jdbc:sqlite:C:/Users/PC home/IdeaProjects/MoscowExchange/db/db_MoscowExchange
                String str= "jdbc:sqlite:"+file.getAbsolutePath()+"/db/db_MoscowExchange";
                System.out.println(str);
                configuration.setProperty("hibernate.connection.url",str);
                configuration.addAnnotatedClass(Security.class);
                configuration.addAnnotatedClass(History.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение в HibernateSessionFactoryUtil!" + e);
            }
        }
        return sessionFactory;
    }
}
