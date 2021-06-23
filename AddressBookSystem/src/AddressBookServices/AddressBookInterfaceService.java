package AddressBookServices;

import AddressBookModel.ContactDetails;

public interface AddressBookInterfaceService {

    public ContactDetails readDataFromConsole(ContactDetails contactDetails);

    public void addContactDetails(ContactDetails contactDetails, String personID);

    public void editContactDetails(String personID);

    public void deleteContactDetails(String personID);

    public void display();

    public boolean findByID(String personID);

}
