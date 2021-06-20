package DAO;

import AddressBookModel.AddressBook;
import AddressBookServices.AddressBookInterfaceService;

import java.util.*;

//Performs CRED Operations
public class AddressBookDAO implements AddressBookInterfaceService {
    Hashtable<String, AddressBook> getContactList = new Hashtable<>();

    // stores company name as key and store contact details as value
    public  void addContactDetails(AddressBook addressBook, String companyName) {
        getContactList.put(companyName,addressBook);

    }

    //perform edit operations
    public void editContactDetails(String compName, String fName, String lName, String eMail, String hAddress, String cName, String sName, String mNumber, String pCode) {
        for (int i = 0; i < getContactList.size(); i++) {
            if(getContactList.containsKey(compName)){
                getContactList.get(compName).setFirstName(fName);
                getContactList.get(compName).setLastName(lName);
                getContactList.get(compName).setEmailAddress(eMail);
                getContactList.get(compName).setHomeAddress(hAddress);
                getContactList.get(compName).setCity(cName);
                getContactList.get(compName).setState(sName);
                getContactList.get(compName).setMobileNumber(mNumber);
                getContactList.get(compName).setPinCode(pCode);
            }

        }
    }

    // performs delete operation
    public void deleteContactDetails(String compName) {
        for (int i = 0; i < getContactList.size(); i++) {
                getContactList.remove(compName);
        }
    }

    //displays the data
    public void display() {
        System.out.println(getContactList);
    }
}
