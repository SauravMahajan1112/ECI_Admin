package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.dao.Candidatesdao;
import com.entity.Candidates;
import com.service.CandidatesService;

public class Candidatescontroller {
	CandidatesService candidatesservice = null;
	List<Candidates> allCandidatesList = new ArrayList<Candidates>();

	public List<Candidates> viewallCandidates() {
		candidatesservice = new CandidatesService();
		allCandidatesList = candidatesservice.viewallCandidates();
		return allCandidatesList;
	}
	public List<Candidates> candidatebynames(String names) {
		candidatesservice = new CandidatesService();
		for (Candidates candidates : candidatesservice.viewallCandidates()) {
			if (candidates.getNames().equalsIgnoreCase(names))
				allCandidatesList.add(candidates);
		}
		return allCandidatesList;
	}
	public List<Candidates>candidatesbypartyname(String partyname) {
		candidatesservice = new CandidatesService();
		List<Candidates> candidatebypartynameslist = new ArrayList<Candidates>();
		for (Candidates candidates : candidatesservice.viewallCandidates()) {
			if (candidates.getPartyname().equalsIgnoreCase(partyname))
				candidatebypartynameslist.add(candidates);
		}
		return candidatebypartynameslist;
	}

	public List<Candidates> candidatebyassemblyname(String assemblyname) {
		candidatesservice = new CandidatesService();
		List<Candidates> candidatebyassemblylist = new ArrayList<Candidates>();
		for (Candidates candidates : candidatesservice.viewallCandidates()) {
			if (candidates.getAssembly().equalsIgnoreCase(assemblyname))
				candidatebyassemblylist.add(candidates);
		}
		return candidatebyassemblylist;
	}

	public Candidates insertnewcandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		candidatesservice = new CandidatesService();
		Candidates insertnewcandidate = candidatesservice.insertnewcandidate(id, names, assembly, partyname, statename,
				age, gender);
		return insertnewcandidate;
	}

	public Candidates updatecandidate(int id, String names, String assembly, String partyname, String statename,
			int age, String gender) {
		candidatesservice = new CandidatesService();
		Candidates updatenewcandidate = candidatesservice.updatecandidate(id, names, assembly, partyname, statename,
				age, gender);
		return updatenewcandidate;
	}

	public Candidates deletecandidate(int id) {
		candidatesservice = new CandidatesService();
		Candidates deleteexistingcandidate = candidatesservice.deletecandidate(id);
		return deleteexistingcandidate;
	}

}
