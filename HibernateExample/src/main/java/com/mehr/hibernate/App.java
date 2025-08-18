package com.mehr.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mehr.hibernate.entity.User;
import com.mehr.hibernate.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            System.out.print("How many users do you want to enter? ");
            int count = sc.nextInt();
            sc.nextLine(); // consume newline

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            for (int i = 0; i < count; i++) {
                System.out.println("\nEnter details for user " + (i + 1));

                System.out.print("Roll No: ");
                int rollNo = sc.nextInt(); sc.nextLine();

                System.out.print("First Name: ");
                String firstName = sc.nextLine();

                System.out.print("Last Name: ");
                String lastName = sc.nextLine();

                System.out.print("Username: ");
                String username = sc.nextLine();

                System.out.print("Gender (MALE/FEMALE/OTHER): ");
                Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("Date of Birth (yyyy-MM-dd): ");
                Date dob = sdf.parse(sc.nextLine());

                User user = new User(rollNo, firstName, lastName, username, gender, address, dob);
                session.persist(user);
            }

            tx.commit();
            session.close();
            sc.close();
            System.out.println("All users saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    	//curd------------->create,update,read,deleted
    	
    	
    	
    	
    	//Inserting data in databases
    	/**
    	Session session=HibernateUtil.getSessionFactory().openSession();
    	Transaction tx=session.beginTransaction();
    	
    	User user=new User("Rk","test@com.in");
    	session.persist(user);
    	tx.commit();
    	session.close();
    	System.out.println("this user data inserted into Database"+ user);
    	
    	
    	
    	
    	//reading
    	session=HibernateUtil.getSessionFactory().openSession();
    	
    	User userData=session.get(User.class, user.getId());
    	System.out.println("this user data fetched from Database"+ userData);
    	session.close();
    	
    	
    	
    	//update
    	session=HibernateUtil.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	userData.setName("User name Updated");
    	session.merge(userData);
    	tx.commit();
    	session.close();
    	System.out.println("User got Updated"+ userData);
    	
    	
    	
    	
    	//Delte
    	
    	session=((SessionFactory) HibernateUtil.getSessionFactory()).openSession();
    	tx=session.beginTransaction();
    	session.remove(userData);
    	tx.commit();
    	session.close();
    	
    	System.out.println("User got Deleted"+ userData);
    	**/
    	

 
