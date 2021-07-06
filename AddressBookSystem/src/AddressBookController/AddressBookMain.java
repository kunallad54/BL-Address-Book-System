/************************************************************************************************
 *
 * This Project Focuses on :
 *               - To create multiple address book
 *               - Each address book and has multiple persons contact details
 *               - First Name is unique for each person ,which acts as key
 *               - Here We can add Person details,edit,delete,display for each company
 *               - Can search persons in same city or same State
 *               - Can view persons of same city or same state
 *               - Can get the count of persons in same city or state
 *               - Ability to sort the entries in the address book alphabetically by
 *                 Person’s name
 *
 * @author Krunal Lad
 * @Since 05-07-2021
 *
 ***************************************************************************************************/

package AddressBookController;

import AddressBookModel.ContactDetails;
import AddressBookServices.AddressBookServices;
import Util.UserInputOutput;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class AddressBookMain {
    static AddressBookServices addressBookServices = new AddressBookServices();
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]){
        Hashtable<String, ArrayList<ContactDetails>> contactInfo = new Hashtable<>();

        boolean flag = true;
        int option;
        while(flag) {
            option = UserInputOutput.userChoice();
            switch (option) {
                case 1:
                    System.out.println("\n" + "Add a new Address Book\n");
                    contactInfo = addressBookServices.addContactDetails();
                    break;
                case 2:
                    System.out.print("\n" + "Enter the name of the Address Book that you want to replace: \n");
                    String companyName = input.next();
                    addressBookServices.editContactDetails(companyName, contactInfo);
                    break;
                case 3:
                    System.out.print("\n" + "Enter the name of the Address Book that you want to delete: \n");
                    String deletedName = input.next();
                    addressBookServices.deleteContactDetails(deletedName, contactInfo);
                    break;
                case 4:
                    System.out.println("\n" + "Display all contacts in the Address Book\n");
                    addressBookServices.display(contactInfo);
                    break;
                case 5:
                    System.out.println("\n" + "Search Address Book based on City\n");
                    addressBookServices.searchPersons();
                    flag = true;
                    break;
                case 6:
                    System.out.println("\n"+"Sort Data in Address Book\n");
                    addressBookServices.sortPersonsData();
                    break;

                case 7:
                    flag = false;
                    System.out.println("\n" + "Thank you for referring the address book.");
                    break;
            }
        }
    }
}