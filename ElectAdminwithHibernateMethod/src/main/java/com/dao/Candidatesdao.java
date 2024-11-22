package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Candidates;

import jdk.internal.org.jline.reader.Candidate;

public class Candidatesdao {
	List<Candidates> listofallcandidates = null;

	public List<Candidates> viewallCandidates() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Candidates.class);

		SessionFactory session = cfg.buildSessionFactory();
		Session openSession = session.openSession();

		// select * from candidate Query
		Criteria criteria = openSession.createCriteria(Candidates.class);
		listofallcandidates = criteria.list();
		return listofallcandidates;
	}

	public Candidates insertnewcandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Candidates.class);

		SessionFactory session = cfg.buildSessionFactory();
		Session openSession = session.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Candidates candidate = new Candidates(id, names, assembly, partyname, statename, age, gender);
		openSession.save(candidate);
		beginTransaction.commit();
		openSession.close();
		return candidate;
	}

	public Candidates updatecandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Candidates.class);

		SessionFactory sessionfactory = cfg.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Candidates candidate = new Candidates(id, names, assembly, partyname, statename, age, gender);
		session.saveOrUpdate(candidate);
		beginTransaction.commit();
		session.close();
		return candidate;

	}

	public Candidates deletecandidate(int id) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Candidates.class);

		SessionFactory sessionfactory = cfg.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Candidates candidate = session.get(Candidates.class, id);
		session.delete(candidate);
		beginTransaction.commit();
		session.close();
		return candidate;
	}
}