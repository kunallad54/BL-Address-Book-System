/**
 * Purpose : To perform File Operations on Address Book
 *
 * @since 09-07-2021
 */

package AddressBookFileOperations;

import AddressBookModel.ContactDetails;


import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class FileReaderWriter {

    /**
     * Purpose : To write data of address book in file
     *
     * @param filePath path of file
     * @param contactInfo input from AddressBookMain ,has data of companyName and its contact Details
     */
    public void writeData(String filePath, Hashtable<String, ArrayList<ContactDetails>> contactInfo){
        StringBuffer empBuffer = new StringBuffer();

        contactInfo.forEach((companyName,contactDetails) ->{
            String empDataString = companyName.concat(contactDetails.toString().concat("\n"));
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(filePath),empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : To read data from file
     *
     * @param filePath path of file
     */
    public void readData(String filePath){
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
