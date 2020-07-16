package com.hibernate.map;

import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {
	private static Object Session;

	public static void main(String[]args) {
		AnnotationConfiguration config= new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory= config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Session.beginTransaction();
		
		PersonDetail anirudhDetail=new PersonDetail();
		anirudhDetail.setZipCode("500070");
		anirudhDetail.setJob("PAT");
		anirudhDetail.setIncome(22085);
		
		Person anirudh = new Person();
		anirudh.setPersonName("Anirudh Chaganty");
		
		anirudh.setpDetail(anirudhDetail);
	    session.save(anirudh);
	    
	    session.getTransaction().commit();
	}

}
