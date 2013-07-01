package com.manage.hibernate;

import com.manage.pub.vo.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.setStaffId(2);
        staff.setStaffCode("Jacky");
        staff.setStaffName("Jacky Wong");
        staff.setStaffPwd("bbbaaa");
        staff.setDepartmentId(321);

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(staff);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }

}
