package AddressBookServices;

import AddressBookModel.AddressBook;
import DAO.AddressBookDAO;

// this class takes request from controller and sends it to DOA
public class AddressBookServices implements AddressBookInterfaceService {

    AddressBookDAO addressBookDAO = new AddressBookDAO();

    public void addContactDetails(AddressBook addressBook, String companyName) {
         addressBookDAO.addContactDetails(addressBook, companyName);
    }

    public void editContactDetails( String compName, String fName, String lName, String eMail, String hAddress, String cName, String sName, String mNumber, String pCode) {
        addressBookDAO.editContactDetails(compName, fName, lName, eMail, hAddress, cName, sName, mNumber, pCode);
    }

    public void deleteContactDetails(String compName) {
        addressBookDAO.deleteContactDetails(compName);
    }

    public void display() {
        addressBookDAO.display();
    }


}
