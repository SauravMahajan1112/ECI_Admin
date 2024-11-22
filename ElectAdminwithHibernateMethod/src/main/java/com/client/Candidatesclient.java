package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.controller.Candidatescontroller;
import com.entity.Candidates;

public class Candidatesclient {

	public static void main(String[] args) {
		System.out.println("======================================");
		System.out.println("       !!! Welcome to Our System !!!");
		System.out.println("======================================");
		System.out.println("               Main Menu              ");
		System.out.println("--------------------------------------");
		System.out.println("1. Show All Candidates");
		System.out.println("2. Insert New Candidate");
		System.out.println("3. Update Candidate Details");
		System.out.println("4. Remove Candidate");
		System.out.println("5. View Candidate by Thier Names");
		System.out.println("6. View Candidate by Thier PartyNames");
		System.out.println("7. View Candidate by Thier Assembly");
		System.out.println("8. Exit");
		System.out.println("======================================");

		Scanner sc = new Scanner(System.in);
		Candidatescontroller control = new Candidatescontroller();
		List<Candidates> allCandidatesList = new ArrayList<>();

		while (true) {
			System.out.print("\nEnter your choice (1-8): ");
			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.println("\nShowing All Candidates:");
				System.out.println("--------------------------------------");
				allCandidatesList = control.viewallCandidates();
				if (allCandidatesList.isEmpty()) {
					System.out.println("No candidates found.");
				} else {
					for (Candidates candidate : allCandidatesList) {
						System.out.println(candidate);
					}
				}
				break;

			case 2:
				System.out.println("\nEnter New Candidate Details:");
				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine(); // Consume newline
				System.out.print("Name: ");
				String names = sc.nextLine();
				System.out.print("Assembly: ");
				String assembly = sc.nextLine();
				System.out.print("Party Name: ");
				String partyname = sc.nextLine();
				System.out.print("State Name: ");
				String statename = sc.nextLine();
				System.out.print("Age: ");
				int age = sc.nextInt();
				sc.nextLine(); // Consume newline
				System.out.print("Gender: ");
				String gender = sc.nextLine();

				Candidates newCandidate = control.insertnewcandidate(id, names, assembly, partyname, statename, age,
						gender);
				System.out.println("\nCandidate Added Successfully:");
				System.out.println(newCandidate);
				break;

			case 3:
				System.out.println("\nEnter Candidate Details to Update:");
				System.out.print("ID: ");
				int uid = sc.nextInt();
				sc.nextLine(); // Consume newline
				System.out.print("Name: ");
				String unames = sc.nextLine();
				System.out.print("Assembly: ");
				String uassembly = sc.nextLine();
				System.out.print("Party Name: ");
				String upartyname = sc.nextLine();
				System.out.print("State Name: ");
				String ustatename = sc.nextLine();
				System.out.print("Age: ");
				int uage = sc.nextInt();
				sc.nextLine(); // Consume newline
				System.out.print("Gender: ");
				String ugender = sc.nextLine();

				Candidates updatedCandidate = control.updatecandidate(uid, unames, uassembly, upartyname, ustatename,
						uage, ugender);
				if (updatedCandidate != null) {
					System.out.println("\nCandidate Updated Successfully:");
					System.out.println(updatedCandidate);
				} else {
					System.out.println("\nUpdate Failed: Candidate not found.");
				}
				break;

			case 4:
				System.out.print("\nEnter Candidate ID to Delete: ");
				int rid = sc.nextInt();
				Candidates removedCandidate = control.deletecandidate(rid);
				if (removedCandidate != null) {
					System.out.println("\nCandidate Deleted Successfully:");
					System.out.println(removedCandidate);
				} else {
					System.out.println("\nDeletion Failed: Candidate not found.");
				}
				break;

			case 5:
				System.out.print(" Enter Candidates Names: ");
				String cnames = sc.nextLine();
				sc.nextLine(); // Consume newline
				System.out.println("\nShowing  Candidates by Names:");
				System.out.println("--------------------------------------");
				List<Candidates> candidatebynameslist = new ArrayList<Candidates>();
				candidatebynameslist = control.candidatebynames(cnames);
				if (candidatebynameslist.isEmpty()) {
					System.out.println("No candidates found.");
				} else {
					for (Candidates candidates : candidatebynameslist) {
						System.out.println(candidates);
					}
				}
				break;
			case 6:
				System.out.print(" Enter Candidates PartyNames: ");
				String partysname = sc.nextLine();
				sc.nextLine(); // Consume newline
				System.out.println("\nShowing All Candidates:");
				System.out.println("--------------------------------------");
				List<Candidates> candidatebypartynameslist = new ArrayList<Candidates>();
				allCandidatesList = control.candidatesbypartyname(partysname);
				if (allCandidatesList.isEmpty()) {
					System.out.println("No candidates found.");
				} else {
					for (Candidates candidates : allCandidatesList) {
						System.out.println(candidates);
					}
				}
				break;
			case 7:
				System.out.print(" Enter Candidates AssemblyName: ");
				String assemblyname = sc.nextLine();
				sc.nextLine();
				System.out.println("\nShowing All Candidates:");
				System.out.println("--------------------------------------");
				List<Candidates> candidatebyassemblylist = new ArrayList<Candidates>();
				allCandidatesList = control.candidatebyassemblyname(assemblyname);
				if (allCandidatesList.isEmpty()) {
					System.out.println("No candidates found.");
				} else {
					for (Candidates candidates : allCandidatesList) {
						System.out.println(candidates);
					}
				}
				break;

			case 8:
				System.out.println("\nExiting... Thank you for visiting. Goodbye!");
				System.out.println("======================================");
				sc.close();
				return;

			default:
				System.out.println("\nInvalid choice. Please enter a number between 1 and 5.");
			}
		}
	}
}
