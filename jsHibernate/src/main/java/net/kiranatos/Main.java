package net.kiranatos;

import net.kiranatos.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try {
            Employee emp = new Employee();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(emp); /* save() and persist() are similar, but still different. 
save() immediately persist the entity and returns the generated ID. 
persist() just marks the entity for insertion. The ID, depending on the identifier generator, may be generated asynchronously, for example when the session is flushed.*/
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        
    }
}


/*
SessionFactory – фабрика по производству сессий.
    - SessionFactory читает файл hibernate.cfg.xml. После чего SessionFactory знает, как должны создаваться сессии.
    - В Java приложении достаточно создать объект SessionFactory 1 раз и затем можно его переиспользовать.

Session – это обёртка вокруг подключения к базе с помощью JDBC.
    - Session мы получаем с помощью SessionFactory.
    - Session – это основа для работы с Базой Данных. Именно с помощью Session мы будем добавлять, получать и делать другие операции с Java Объектами в БД.
    - Жизненный цикл Session обычно не велик. Мы получаем Session, делаем с помощью неё определённые операции и она становится не нужной.

hibernate.cfg.xml - стандартна назва, тому можна було не вказувати. Але для читабельності краще вказати.



*/