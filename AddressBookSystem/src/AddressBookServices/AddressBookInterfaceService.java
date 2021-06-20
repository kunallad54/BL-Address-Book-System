package AddressBookServices;

import AddressBookModel.AddressBook;

public interface AddressBookInterfaceService {
    public  void addContactDetails(AddressBook addressBook, String companyName);
    public void editContactDetails(String compName, String fName, String lName, String eMail, String hAddress, String cName, String sName, String mNumber, String pCode);
    public void deleteContactDetails(String compName);
    public void display();
}
