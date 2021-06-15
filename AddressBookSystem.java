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

        PersonDetails(String personID,String firstName, String lastName, String emailAddress, String homeAddress, String cityName, String stateName, String mobileNumber, String pinCode) {

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

    // gets details of person and stores in array list
    public static void personDetails(List<PersonDetails> contacts) {

        int ADD_CONTACTS = 1;

        String pID = personID();
        String fName = firstName();
        String lName = lastName();
        String email = email();
        String hAddress = address();
        String city = cityName();
        String state = stateName();
        String mNumber = mobileNumber();
        String pCode = pinCode();

        // adding details in array list
        contacts.add(new PersonDetails(pID,fName, lName, email, hAddress, city, state, mNumber, pCode));

        System.out.println("To add new contact press 1 or press 0 to stop adding");
        int userChoice = sc.nextInt();

        // recursively calling the function
        if(userChoice == ADD_CONTACTS) {
            sc.nextLine();
            personDetails(contacts);
        }
        else{
            System.out.println();
            System.out.println("The Person Details are as follows : ");
            System.out.println();

            // displaying info on console
            for (PersonDetails c : contacts) {

                System.out.println("These are details of Person ID: "+c.personID);
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

        }

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
