package AddressBookFileOperations;

import AddressBookModel.ContactDetails;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class CSVFileReadWriter {
    String filePath = "C:\\Users\\Kunal\\IdeaProjects\\AddressBookSystem\\src\\Files\\";

    public void writeCSVFile(Hashtable<String, ArrayList<ContactDetails>> contactInfo){
        contactInfo.keySet().stream().forEach(companyName ->{
            File file = new File(filePath + companyName + ".csv" );
            try {
                FileWriter fileWriter = new FileWriter(file);
                CSVWriter csvWriter = new CSVWriter(fileWriter);

                //Add Header to CSV
                String header [] = {"FirstName","LastName","Email Address","Home Address","City Name","State Name","Mobile Number","Pin Code"};
                csvWriter.writeNext(header);

                //Add data to csv
                contactInfo.get(companyName).stream().forEach(contactDetails -> {
                    String[] contact = {contactDetails.getFirstName(),contactDetails.getLastName()
                    ,contactDetails.getEmailAddress(),contactDetails.getHomeAddress(),contactDetails.getCity(),
                    contactDetails.getState(),contactDetails.getMobileNumber(),contactDetails.getPinCode()};

                    csvWriter.writeNext(contact);
                });

                csvWriter.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void readCSVFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nReading CSV File...");
        System.out.println("Enter the Company Name : ");
        String companyName = scanner.next();

        String filePathReader = filePath + companyName + ".csv";

        try {
            FileReader fileReader = new FileReader(filePathReader);
            CSVReader csvReader = new CSVReader(fileReader);

            String[] records;

            //Reading Data
            while ((records = csvReader.readNext()) != null){
                for (String lines : records){
                    System.out.print(lines + " \t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
