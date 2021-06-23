package AddressBookServices;

import AddressBookModel.ContactDetails;
import DAO.AddressBook;

// this class takes request from controller and sends it to DOA
public class AddressBookServices implements AddressBookInterfaceService {

    AddressBook addressBook = new AddressBook();

    /**
     * Requesting from DOA AddressBook and returns it to Controller AddressBookMain
     *
     * @param contactDetails
     * @return
     */
    @Override
    public ContactDetails readDataFromConsole(ContactDetails contactDetails) {
        return addressBook.readDataFromConsole(contactDetails);
    }

    @Override
    public void addContactDetails(ContactDetails contactDetails, String personID) {
        addressBook.addContactDetails(contactDetails, personID);
    }

    @Override
    public void editContactDetails(String personID) {
        addressBook.editContactDetails(personID);
    }

    @Override
    public void deleteContactDetails(String personID) {
        addressBook.deleteContactDetails(personID);
    }

    @Override
    public void display() {
        addressBook.display();
    }

    @Override
    public boolean findByID(String personID) {
        return addressBook.findByID(personID);
    }


}
