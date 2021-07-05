package AddressBookController;
/**
 * This Project Focuses on :
 * Refactor to add multiple Address Book to the System. Each Address Book
 * has a unique Name - Use Console to add new Address Book - Maintain Dictionary of Address Book Name to Address Book
 *
 * @author Krunal Lad
 * @Since 20-06-2021
 */

import AddressBookModel.ContactDetails;
import AddressBookServices.AddressBookServices;
import DAO.AddressBook;
import Util.UserInputOutput;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    HashMap<String, AddressBook> addressBookOfCompanies = new HashMap<String, AddressBook>();

    static AddressBookServices addressBookServices = new AddressBookServices();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System !!!");
        AddressBookMain addressBookMain = new AddressBookMain();
        int choice = 0;
        while (choice != 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 - To create a new address book");
            System.out.println("Press 2 - To access an existing address book");
            System.out.println("Press 3 - To Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addressBookMain.newAddressBook();
                    break;
                case 2:
                    addressBookMain.accessAddressBook();
                    break;
                case 3:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
        }
        //addressBookMain.addressBookForParticularCompany();

    }

    public void addressBookForParticularCompany() {
        ContactDetails addressBook;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = UserInputOutput.userChoice();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Person Id : ");
                    String personID = scanner.next();
                    ContactDetails contactDetails = new ContactDetails();

                    // checking for duplicate entries while entering the ID itself
                    // as Id needs to unique it cant be duplicate
                    if(addressBookServices.findByID(personID)){
                        System.out.println("Id is already present");
                    } else {
                        addressBook = addressBookServices.readDataFromConsole(contactDetails);
                        addressBookServices.addContactDetails(addressBook, personID);
                    }
                    break;
                case 2:
                    System.out.println("Enter the Person ID to edit details: ");
                    personID = scanner.next();
                    if (addressBookServices.findByID(personID)) {
                        addressBookServices.editContactDetails(personID);
                    } else {
                        System.out.println("ID Not Found !!! \nEnter Valid Person ID");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Person ID to delete contact details :");
                    personID = scanner.next();
                    if (addressBookServices.findByID(personID)) {
                        addressBookServices.deleteContactDetails(personID);
                    } else {
                        System.out.println("ID Not Found !!! \nEnter Valid Person ID");
                    }
                    break;
                case 4:
                    addressBookServices.display();
                    break;
            }
            if (choice == 5)
                break;
        }
    }

    public void newAddressBook() {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter the name of new address book : ");
        String companyName = scanner.nextLine();
        addressBookOfCompanies.put(companyName, addressBook);
        System.out.println("New Address Book for " + companyName + " successfully created !!! ");
    }

    public void accessAddressBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tha name of the company : ");
        String companyName = scanner.nextLine();
        AddressBook addressBook = addressBookOfCompanies.get(companyName);
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.addressBookForParticularCompany();
    }

}
