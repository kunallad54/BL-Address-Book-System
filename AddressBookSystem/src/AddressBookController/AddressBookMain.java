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
 *               - Ability to sort the entries in the address book by City,
 *                 State, or Pin code
 *               - Ability to Read or Write the Address Book with
 *                 Persons Contact into a File using File IO,in CSV File
 *                 using openCSV,in Json File using GSon library
 *
 *
 * @author Krunal Lad
 * @Since 09-07-2021
 *
 ***************************************************************************************************/

package AddressBookController;

import AddressBookFileOperations.CSVFileReadWriter;
import AddressBookFileOperations.FileReaderWriter;
import AddressBookFileOperations.JSonFileReadWriter;
import AddressBookModel.ContactDetails;
import AddressBookServices.AddressBookServices;
import Util.UserInputOutput;
import com.opencsv.CSVWriter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class AddressBookMain {
    static AddressBookServices addressBookServices = new AddressBookServices();
    static Scanner input = new Scanner(System.in);

    /**
     * Purpose : Main Method perform all address book operations
     */
    public static void main(String args[]) {
        Hashtable<String, ArrayList<ContactDetails>> contactInfo = new Hashtable<>();
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        CSVFileReadWriter csvFileReadWriter = new CSVFileReadWriter();
        JSonFileReadWriter jSonFileReadWriter = new JSonFileReadWriter();

        String filePath = "C:\\Users\\Kunal\\IdeaProjects\\AddressBookSystem\\src\\Files\\AddressBookDataInCSV";

        boolean flag = true;
        int option;
        while (flag) {
            option = UserInputOutput.userChoice();
            switch (option) {
                case 1:
                    System.out.println("\n" + "Add a new Address Book\n");
                    System.out.println("Press 1 - To write in normal file");
                    System.out.println("Press 2 - To write in .csv file");
                    System.out.println("Press 3 - To write in .json file");
                    int choice = input.nextInt();
                    contactInfo = addressBookServices.addContactDetails();
                    if(choice == 1)
                        fileReaderWriter.writeData(filePath, contactInfo);
                    else if(choice == 2)
                        csvFileReadWriter.writeCSVFile(contactInfo);
                    else if(choice == 3)
                        jSonFileReadWriter.writeJsonFile(contactInfo);
                    else
                        System.out.println("Enter Valid Choice !!!");

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
                    //addressBookServices.display(contactInfo);
                    System.out.println("Press 1 - To read data of normal file");
                    System.out.println("Press 2 - To read data of .csv file");
                    System.out.println("Press 3 - To read data of .json file");
                    int userChoice = input.nextInt();
                    if(userChoice == 1)
                        fileReaderWriter.readData(filePath);
                    else if(userChoice == 2)
                        csvFileReadWriter.readCSVFile();
                    else if (userChoice == 3)
                        jSonFileReadWriter.readJSonFile();
                    else
                        System.out.println("Enter Valid Choice !!!");
                    break;
                case 5:
                    System.out.println("\n" + "Search Address Book based on City\n");
                    addressBookServices.searchPersons();
                    flag = true;
                    break;
                case 6:
                    System.out.println("\n" + "Sort Data in Address Book\n");
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