import java.util.List;
import java.util.Scanner;

import Controller.RaffleListHelper;

import Model.RaffleList;

/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static RaffleListHelper lih = new RaffleListHelper();

	private static void addAnEntry() {
		// TODO Auto-generated method stub
		System.out.print("Enter your first name: ");
		String firstName = in.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = in.nextLine();
		
		RaffleList toAdd = new RaffleList(firstName, lastName);
		lih.insertEntry(toAdd);

	}

	private static void deleteAnEntry() {
		// TODO Auto-generated method stub
		System.out.print("Enter your first name to delete: ");
		String firstName = in.nextLine();
		System.out.print("Enter your last name to delete: ");
		String lastName = in.nextLine();
		
		RaffleList toDelete = new RaffleList(firstName, lastName);
		lih.deleteEntry(toDelete);

	}

	private static void editAnEntry() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by first name");
		System.out.println("2 : Search by last name");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<RaffleList> foundEntries = null;
		if (searchBy == 1) {
			System.out.print("Enter your first name: ");
			String storeName = in.nextLine();
			
		} else {
			System.out.print("Enter your last name: ");
			String lastName = in.nextLine();
			

		}

		if (!foundEntries.isEmpty()) {
			System.out.println("Found Results.");
			for (RaffleList r : foundEntries) {
				System.out.println(r.getId() + " : " + r.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			RaffleList toEdit = lih.searchForEntryById(idToEdit);
			System.out.println("Retrieved " + toEdit.getFirstName() + "  " + toEdit.getLastName());
			System.out.println("1 : Update first name");
			System.out.println("2 : Update last name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New first name: ");
				String newFirst = in.nextLine();
				toEdit.setFirstName(newFirst);
			} else if (update == 2) {
				System.out.print("New last name: ");
				String newLast = in.nextLine();
				toEdit.setLastName(newLast);
			}

			lih.updateEntry(toEdit);

		} else {
			System.out.println("---- No results found");
		}
		if (searchBy == 1) {
			System.out.print("Enter first name: ");
			String firstName = in.nextLine();
			foundEntries = lih.searchForEntryByFirstName(firstName);
			} else {
			System.out.print("Enter last name: ");
			String lastName = in.nextLine();
			foundEntries = lih.searchForEntryByLastName(lastName);
			}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the raffle!! Good Luck!---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an entry");
			System.out.println("*  2 -- Edit an entry");
			System.out.println("*  3 -- Delete an entry");
			System.out.println("*  4 -- View the list of entries");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnEntry();
			} else if (selection == 2) {
				editAnEntry();
			} else if (selection == 3) {
				deleteAnEntry();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	// captures results from this method into a list & iterates through it to print them all out
	private static void viewTheList() {
		List<RaffleList>allEntries = lih.showAllEntries();
		for(RaffleList singleEntry : allEntries) {
			System.out.println(singleEntry.toString());
		}
	}

}