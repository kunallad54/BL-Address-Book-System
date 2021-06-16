/**
 * Creating Address Book in which it stores person's contact details
 * It can add new contact,edit,delete the contact details
 * 
 * @author Krunal Lad
 * @Since 15-06-2021
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {

    private static final Scanner sc = new Scanner(System.in);

    // Creating Person Details Class
    public static class PersonDetails {

        private final String personID;
        private final String firstName;
        private final String lastName;
        private final String emailAddress;
        private final String homeAddress;
        private final String cityName;
        private final String stateName;
        private final String mobileNumber;
        private final String pinCode;

        PersonDetails(String personID, String firstName, String lastName, String emailAddress, String homeAddress, String cityName, String stateName, String mobileNumber, String pinCode) {

            this.personID = personID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.homeAddress = homeAddress;
            this.cityName = cityName;
            this.stateName = stateName;
            this.mobileNumber = mobileNumber;
            this.pinCode = pinCode;
        }

    }

    // main method
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program !!! ");
        List<PersonDetails> contacts = new ArrayList<>();
        personDetails(contacts);
    }

    // adds details of person and stores in array list
    public static void personDetails(List<PersonDetails> contacts) {


        // calling methods to get user Input
        String pID = personID();
        String fName = firstName();
        String lName = lastName();
        String email = email();
        String hAddress = address();
        String city = cityName();
        String state = stateName();
        String mNumber = mobileNumber();
        String pCode = pinCode();

        // adding details in array list as one object
        contacts.add(new PersonDetails(pID, fName, lName, email, hAddress, city, state, mNumber, pCode));

        startProcess(contacts);

    }

    // takes actions whether to add details or to edit or to stop
    private static void startProcess(List<PersonDetails> contacts) {
        int ADD_CONTACTS = 1;
        int EDIT_CONTACTS = 2;
        int REMOVE_CONTACTS = 3;
	int STOP_AND_DISPLAY = 0;

        System.out.println("To add new contact press 1 ,press 2 to edit, press 3 to delete details,or press 0 to stop adding and display");
        int userChoice = sc.nextInt();


        // recursively calling the function
        if (userChoice == ADD_CONTACTS) {
            sc.nextLine();               //---> to avoid enter button problem
            personDetails(contacts);
        } else if (userChoice == EDIT_CONTACTS) {
            //calling editDetails method to edit details
            sc.nextLine();
            System.out.println("Enter the first name to edit:");
            String name = sc.nextLine();
            editDetails(name, contacts);
        } else if (userChoice == REMOVE_CONTACTS) {
            //calling removeDetails method to delete details
            sc.nextLine();
            System.out.println("Enter the first name to delete the contact");
            String name = sc.nextLine();
            removeDetails(name,contacts);
        } else if (userChoice == STOP_AND_DISPLAY){
            System.out.println();
            System.out.println("The Person Details are as follows : ");
            System.out.println();

            // displaying info on console
            for (PersonDetails c : contacts) {

                System.out.println("These are details of Person ID: " + c.personID);
                System.out.println("First Name : " + c.firstName);
                System.out.println("Last Name : " + c.lastName);
                System.out.println("Email Address : " + c.emailAddress);
                System.out.println("Home Address : " + c.homeAddress);
                System.out.println("City : " + c.cityName);
                System.out.println("State : " + c.stateName);
                System.out.println("Mobile Number : " + c.mobileNumber);
                System.out.println("Pin Code : " + c.pinCode);
                System.out.println();

            }

        } else {
		System.out.println("INVALID INPUT,Please enter Correct Input");
	}
    }

    // checks user entered details present in list if yes then calls method edit parameter to edit details
    public static void editDetails(String name, List<PersonDetails> contacts) {

        for (int i = 0; i < contacts.size(); i++) {
            //checks if entered name matches first name of any person if yes then edit the persons details
            if (name.contains(contacts.get(i).firstName)) {

                editParameter(contacts, i);
            }

        }
        System.out.println("No user found with that name , Please re-enter the Correct Name ");
        startProcess(contacts);

    }

    // edits the parameters that user want to edit
    private static void editParameter(List<PersonDetails> contacts, int i) {

        // gets all details of that person and stores it
        String perID = contacts.get(i).personID;
        String fName = contacts.get(i).firstName;
        String lName = contacts.get(i).lastName;
        String mail = contacts.get(i).emailAddress;
        String addr = contacts.get(i).homeAddress;
        String cName = contacts.get(i).cityName;
        String sName = contacts.get(i).stateName;
        String mNO = contacts.get(i).mobileNumber;
        String pCode = contacts.get(i).pinCode;


        System.out.println("Which details you want to edit : ");
        System.out.println(" Press 1 for first Name");
        System.out.println(" Press 2 for last Name");
        System.out.println(" Press 3 for email");
        System.out.println(" Press 4 for home address");
        System.out.println(" Press 5 for city");
        System.out.println(" Press 6 for state");
        System.out.println(" Press 7 for mobile number");
        System.out.println(" Press 8 for pin code");
        int editPara = sc.nextInt();
        sc.nextLine();

	//checks the condition and accordingly perform actions
        switch (editPara) {
            case 1:
                System.out.println("Enter updated First Name :");
                fName = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter updated Last Name :");
                lName = sc.nextLine();
                break;
            case 3:
                System.out.println("Enter updated Email Address :");
                mail = sc.nextLine();
                break;
            case 4:
                System.out.println("Enter updated Home Address :");
                addr = sc.nextLine();
                break;
            case 5:
                System.out.println("Enter updated City Name :");
                cName = sc.nextLine();
                break;
            case 6:
                System.out.println("Enter updated State Name :");
                sName = sc.nextLine();
                break;
            case 7:
                System.out.println("Enter updated Mobile Number :");
                mNO = sc.nextLine();
                break;
            case 8:
                System.out.println("Enter updated Pin Code :");
                pCode = sc.nextLine();
                break;

        }

        //updates the details of the persons
        contacts.set(i, new PersonDetails(perID, fName, lName, mail, addr, cName, sName, mNO, pCode));
        startProcess(contacts);
    }

    // Deletes details of a person if first name is there inside a list else not
    public static void removeDetails(String name, List<PersonDetails> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            //checks if entered name matches first name of any person if yes then edit the persons details
            if (name.contains(contacts.get(i).firstName)) {

                contacts.remove(i);
            }

        }
        startProcess(contacts);
    }


    // this methods takes user input and returns String
    public static String personID() {
        System.out.println("Enter the Person ID : ");
        return sc.nextLine();
    }

    public static String firstName() {
        System.out.println("Enter the first name : ");
        return sc.nextLine();
    }

    public static String lastName() {
        System.out.println("Enter the last name : ");
        return sc.nextLine();
    }

    public static String email() {
        System.out.println("Enter the email address : ");
        return sc.nextLine();
    }

    public static String address() {
        System.out.println("Enter the name of the area : ");
        return sc.nextLine();
    }

    public static String cityName() {
        System.out.println("Enter the city name : ");
        return sc.nextLine();
    }

    public static String stateName() {
        System.out.println("Enter the State : ");
        return sc.nextLine();
    }

    public static String mobileNumber() {
        System.out.println("Enter Mobile Number : ");
        return sc.nextLine();
    }

    public static String pinCode() {
        System.out.println("Enter the pin code : ");
        return sc.nextLine();
    }
}

