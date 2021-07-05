/**
 * Purpose : To perform all operations of address book project and send results to service class
 */

package DAO;

import AddressBookModel.ContactDetails;
import Util.UserInputOutput;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AddressBook {
    HashMap<String, ContactDetails> addressBook = new HashMap<String, ContactDetails>();

    /**
     * getting data from user and stores in object and returns the object
     * @param contactDetails
     * @return
     */
    public ContactDetails readDataFromConsole(ContactDetails contactDetails) {
        String fName = UserInputOutput.getCustomerFirstName();
        contactDetails.setFirstName(fName);

        String lName = UserInputOutput.getCustomerLastName();
        contactDetails.setLastName(lName);

        String eMail = UserInputOutput.getCustomerEmailAddress();
        contactDetails.setEmailAddress(eMail);

        String hAddress = UserInputOutput.getCustomerHomeAddress();
        contactDetails.setHomeAddress(hAddress);

        String cName = UserInputOutput.getCustomerCityName();
        contactDetails.setCity(cName);

        String sName = UserInputOutput.getCustomerStateName();
        contactDetails.setState(sName);

        String mNUmber = UserInputOutput.getCustomerMobileNumber();
        contactDetails.setMobileNumber(mNUmber);

        String pCode = UserInputOutput.getCustomerPinCode();
        contactDetails.setPinCode(pCode);

        return contactDetails;
    }

    /**
     * @param contactDetails is object that holds all details of single  person it gets added as value in hashmap
     * @param personID       is key in hashmap
     */
    public void addContactDetails(ContactDetails contactDetails, String personID) {
        addressBook.put(personID, contactDetails);
    }

    /**
     * gets person id from @hashmap addressBook and passes it to readDataConsole to edit
     *
     * @param personID
     */
    public void editContactDetails(String personID) {
        ContactDetails object;
        object = addressBook.get(personID);
        object = readDataFromConsole(object);
    }

    /**
     * Simply performs delete operation by using remove keyword
     *
     * @param personID
     */
    public void deleteContactDetails(String personID) {
        addressBook.remove(personID);
        System.out.println("Contact details successfully deleted");
    }

    /**
     * Checks whether ID is present or not
     *
     * @param personID
     * @return
     */
    public boolean findByID(String personID) {
        boolean isPresent = addressBook.containsKey(personID);
        return isPresent;
    }

    /**
     * Displays the addressBook details
     */
    public void display() {
        System.out.println(addressBook);
    }

    /**
     * Purpose : To get person details of same city ,multiple persons can be in same city
     *
     * @param cityName input from service class
     */
    public void searchPersonsInCity(String cityName){
        int count = 0;
        Iterator<Map.Entry<String, ContactDetails>> iterator = addressBook.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, ContactDetails> entry = iterator.next();
            if(entry.getValue().getCity().equals(cityName)){
                count++;
                System.out.println("\nPerson ID : \n"+entry.getKey());
                System.out.println("Person Details : \n"+entry.getValue());
            }
        }
        System.out.println("\nTotal Count of Persons from City "+cityName+" is : "+count);
        System.out.println("\nSuccessfully Searched whole Address Book\n");
    }

    /**
     * Purpose : To get person details of same state,multiple persons can be in same state
     *
     * @param stateName input from service class
     */
    public void searchPersonsInState(String stateName){
        int count = 0;
        Iterator<Map.Entry<String, ContactDetails>> iterator = addressBook.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, ContactDetails> entry = iterator.next();
            if(entry.getValue().getState().equals(stateName)){
                count++;
                System.out.println("\nPerson ID : \n"+entry.getKey());
                System.out.println("Person Details : \n"+entry.getValue());
            }
        }
        System.out.println("\nTotal Count of Persons From State "+stateName+" is : "+count);
        System.out.println("\nSuccessfully Searched whole Address Book\n");
    }

}
