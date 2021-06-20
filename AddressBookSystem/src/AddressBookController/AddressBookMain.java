package AddressBookController;
/**
 * This Project Focuses on :
 * Refactor to add multiple Address Book to the System. Each Address Book
 * has a unique Name - Use Console to add new Address Book - Maintain Dictionary of Address Book Name to Address Book
 *
 * @author Krunal Lad
 * @Since 20-06-2021
 */

import AddressBookModel.AddressBook;
import AddressBookServices.AddressBookServices;
import Util.UserInputOutput;
import java.util.Scanner;

public class AddressBookMain {

    static Scanner scanner = new Scanner(System.in);

    static AddressBookServices addressBookServices = new AddressBookServices();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System !!!");
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.setAddressBookForCompanies(addressBookMain);

    }

    public void setAddressBookForCompanies(AddressBookMain addressBookMain){
        AddressBook addressBook ;
        while (true) {
            int choice = UserInputOutput.userChoice();
            switch (choice) {
                case 1:
                    System.out.println("Enter the company Name : ");
                    String companyName = scanner.next();
                    addressBook = readDataFromConsole();
                    addressBookServices.addContactDetails(addressBook,companyName);
                    break;
                case 2:
                    System.out.println("Enter the company Name : ");
                    String cName = scanner.next();
                    addressBookMain.editParameters(cName);
                    break;
                case 3:
                    System.out.println("Enter the company Name : ");
                    String compName = scanner.next();
                    addressBookServices.deleteContactDetails(compName);

                    break;
                case 4:
                    addressBookServices.display();
                    break;
            }
            if (choice == 5)
                break;
        }

    }

    // getting data from user and stores in object and returns the object
    public static AddressBook readDataFromConsole() {

        AddressBook addressBook = new AddressBook();

        String pID = UserInputOutput.getCustomerPersonID();
        addressBook.setPersonID(pID);

        String fName = UserInputOutput.getCustomerFirstName();
        addressBook.setFirstName(fName);

        String lName = UserInputOutput.getCustomerLastName();
        addressBook.setLastName(lName);

        String eMail = UserInputOutput.getCustomerEmailAddress();
        addressBook.setEmailAddress(eMail);

        String hAddress = UserInputOutput.getCustomerHomeAddress();
        addressBook.setHomeAddress(hAddress);

        String cName = UserInputOutput.getCustomerCityName();
        addressBook.setCity(cName);

        String sName = UserInputOutput.getCustomerStateName();
        addressBook.setState(sName);

        String mNUmber = UserInputOutput.getCustomerMobileNumber();
        addressBook.setMobileNumber(mNUmber);

        String pCode = UserInputOutput.getCustomerPinCode();
        addressBook.setPinCode(pCode);

        return addressBook;
    }

    //getting data to edit parameters
    public void editParameters(String compName) {

        String fName = UserInputOutput.getCustomerFirstName();
        String lName = UserInputOutput.getCustomerLastName();
        String eMail = UserInputOutput.getCustomerEmailAddress();
        String hAddress = UserInputOutput.getCustomerHomeAddress();
        String cName = UserInputOutput.getCustomerCityName();
        String sName = UserInputOutput.getCustomerStateName();
        String mNumber = UserInputOutput.getCustomerMobileNumber();
        String pCode = UserInputOutput.getCustomerPinCode();

        addressBookServices.editContactDetails(compName, fName, lName, eMail, hAddress, cName, sName, mNumber, pCode);
    }
}
