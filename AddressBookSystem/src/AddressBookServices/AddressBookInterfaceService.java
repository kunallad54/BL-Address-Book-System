package AddressBookServices;

import AddressBookModel.ContactDetails;

import java.util.ArrayList;
import java.util.Hashtable;

public interface AddressBookInterfaceService {


    Hashtable<String, ArrayList<ContactDetails>> addContactDetails();

    void editContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>> contactInfo);

    void deleteContactDetails(String addressBookName,Hashtable<String,ArrayList<ContactDetails>>contactInfo);

    void display(Hashtable<String,ArrayList<ContactDetails>>contactInfo);

    void searchPersons();



}
