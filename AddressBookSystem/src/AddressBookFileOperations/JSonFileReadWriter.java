/**
 * Purpose : To Read and write Json File
 *
 * @Since 12-07-2021
 */
package AddressBookFileOperations;

import AddressBookModel.ContactDetails;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class JSonFileReadWriter {
    String filePath = "C:\\Users\\Kunal\\IdeaProjects\\AddressBookSystem\\src\\Files\\";


    /**
     * Purpose : To write data in json file using GSon Library
     *
     * @param contactInfo
     */
    public void writeJsonFile(Hashtable<String, ArrayList<ContactDetails>> contactInfo) {

        contactInfo.keySet().stream().forEach(companyName -> {

            String filePathReader = filePath + companyName + ".json";

            try {

                JsonArray jsonElements = new JsonArray();

                contactInfo.get(companyName).stream().forEach(contactDetails -> {

                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("First Name", contactDetails.getFirstName());
                    jsonObject.addProperty("Last Name", contactDetails.getLastName());
                    jsonObject.addProperty("Email Address", contactDetails.getEmailAddress());
                    jsonObject.addProperty("City Name", contactDetails.getCity());
                    jsonObject.addProperty("State Name", contactDetails.getState());
                    jsonObject.addProperty("Mobile Number", contactDetails.getMobileNumber());
                    jsonObject.addProperty("Pin Code", contactDetails.getPinCode());

                    jsonElements.add(jsonObject);

                });

                FileWriter writer = new FileWriter(filePathReader);
                writer.write(jsonElements.toString());
                writer.flush();

            } catch (Exception e) {

                e.printStackTrace();

            }
        });
    }

    /**
     * Purpose To read Data From Json File Using GSon Library
     */
    public void readJSonFile() {

        Scanner scanner = new Scanner(System.in);
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonElements = null;

        System.out.println("\n\nReading Data from .json file");
        System.out.print("Enter the Company Name you want to read the details from : ");
        String companyName = scanner.next();

        String filePathReader = filePath + companyName + ".json";

        try {

            FileReader reader = new FileReader(filePathReader);
            jsonElements = (JsonArray) jsonParser.parse(reader);
            System.out.println(jsonElements);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
