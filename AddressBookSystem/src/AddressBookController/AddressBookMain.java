/************************************************************************************************
 *
 * This Project Focuses on :
 *               - To create multiple address book
 *               - Each address book and has multiple persons contact details
 *               - Person ID is unique for each person ,which acts as key
 *               - Here We can add Person details,edit,delete,display for each company
 *               - Can search persons in same city or same State
 *               - Can view persons of same city or same state
 *               - Can get the count of persons in same city or state
 *
 * @author Krunal Lad
 * @Since 05-07-2021
 *
 ***************************************************************************************************/

package AddressBookController;

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

    /**
     * Purpose : To perform all address book operations by calling service class
     */
    public void addressBookForParticularCompany() {
        ContactDetails addressBook;
        boolean flag = true;
        while (flag) {
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

                case 5 :
                    System.out.println("Press 1 to get person details in same city");
                    System.out.println("Press 2 to get person details in same state");
                    int userChoice = scanner.nextInt();
                    if(userChoice == 1){
                        System.out.println("Enter City Name : ");
                        String cityName = scanner.next();
                        addressBookServices.searchPersonsInCity(cityName);
                    } else if (userChoice == 2) {
                        System.out.println("Enter State Name : ");
                        String stateName = scanner.next();
                        addressBookServices.searchPersonsInState(stateName);
                    } else {
                        System.out.println("Enter Valid Choice");
                    }
                    break;

                case 6 :
                    System.out.println("Exited !!!");
                    flag = false;
                    break;

                default:
                    System.out.println("Enter Valid Choice ");
                    break;

            }

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
