package com.service;

import java.util.ArrayList;
import java.util.List;
import com.dao.Candidatesdao;
import com.entity.Candidates;

public class CandidatesService {
	Candidatesdao candidatesDao = null;
	List<Candidates> allCandidatesList = new ArrayList<Candidates>();

	public List<Candidates> viewallCandidates() {
		candidatesDao = new Candidatesdao();
		allCandidatesList = candidatesDao.viewallCandidates();
		return allCandidatesList;
	}

	public List<Candidates> candidatebynames(String names) {
		candidatesDao = new Candidatesdao();
		List<Candidates> candidatebynameslist = new ArrayList<Candidates>();
		for (Candidates candidates : candidatesDao.viewallCandidates()) {
			if (candidates.getNames().equalsIgnoreCase(names))
				candidatebynameslist.add(candidates);
		}
		return candidatebynameslist;
	}

	public List<Candidates> candidatesbypartyname(String partyname) {
		candidatesDao = new Candidatesdao();
		List<Candidates> candidatebypartynameslist = new ArrayList<Candidates>();
		for (Candidates candidates : candidatesDao.viewallCandidates()) {
			if (candidates.getPartyname().equalsIgnoreCase(partyname))
				candidatebypartynameslist.add(candidates);
		}
		return candidatebypartynameslist;
	}

	public List<Candidates> candidatebyassemblyname(String assemblyname) {
		candidatesDao = new Candidatesdao();
		List<Candidates> candidatebyassemblylist = new ArrayList<Candidates>();
		for (Candidates candidates : candidatesDao.viewallCandidates()) {
			if (candidates.getAssembly().equalsIgnoreCase(assemblyname))
				candidatebyassemblylist.add(candidates);
		}
		return candidatebyassemblylist;
	}

	public Candidates insertnewcandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		candidatesDao = new Candidatesdao();
		Candidates insertnewcandidate = candidatesDao.insertnewcandidate(id, names, assembly, partyname, statename, age,
				gender);
		return insertnewcandidate;
	}

	public Candidates updatecandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		candidatesDao = new Candidatesdao();
		Candidates updatenewcandidate = candidatesDao.updatecandidate(id, names, assembly, partyname, statename, age,
				gender);
		return updatenewcandidate;
	}

	public Candidates deletecandidate(int id) {
		candidatesDao = new Candidatesdao();
		Candidates deleteexistingcandidate = candidatesDao.deletecandidate(id);
		return deleteexistingcandidate;
	}

}
