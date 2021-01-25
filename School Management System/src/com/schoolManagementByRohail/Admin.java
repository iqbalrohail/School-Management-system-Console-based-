package com.schoolManagementByRohail;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Admin extends PersonIdentity {
    Scanner scanner = new Scanner(System.in);


    void displayMessageToAdmin() {
        System.out.println("\nPress 1 for Name");
        System.out.println("\nPress 2 for age");
        System.out.println("\nPress 3 for Qualification");
        System.out.println("\nPress 4 for City");
        System.out.println("\nPress 5 for Address");
        System.out.println("\nPress 6 for Phone Number");
    }


    void personalRecordList(String adminFeatures) {
        ArrayList<String> recordsList = new ArrayList<>();
        try {
            FileReader readPersonalIdentity = new FileReader("PersonalDetails.txt");

            for (int i = 0; i < 6; i++) {

                String specific_Detail = Files.readAllLines(Paths.get("PersonalDetails.txt")).get(i);  // reading specific lines
                System.out.println(specific_Detail);
                recordsList.add(i, specific_Detail);

            }

            readPersonalIdentity.close();
        } catch (Exception e) {
            System.out.println("Success...");

        }


        if (adminFeatures.equals("1")) {
            addRecord(recordsList); // holds the control of adRecord method in Admin class
        } else if (adminFeatures.equals("2")) {
            deleteRecords(recordsList); // // holds the control of deleteRecords method in Admin class

        }

    }


    void addRecord(ArrayList<String> recordsList) // method for adding/changing records
    {

        System.out.println(recordsList);
        displayMessageToAdmin();
        List<Integer> personalRecordSelect = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("\nSearch for any personal Record");
        int personalRecordSearch = scanner.nextInt();


        if (personalRecordSelect.contains(personalRecordSearch)) {
            System.out.println("Enter new Updation\n\n");

            String updatedList = scanner.nextLine();
            updatedList = scanner.nextLine();

            recordsList.set(personalRecordSearch - 1, updatedList);
        }


        writeUpdatedList(recordsList); /// invoke method to store the updated details-------------

    }


    void deleteRecords(ArrayList<String> recordsList) {
        displayMessageToAdmin();


        List<Integer> personalRecordSelect = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("\nSearch for any Record to delete");
        int personalRecordSearch = scanner.nextInt();

        if (personalRecordSelect.contains(personalRecordSearch)) {
            recordsList.remove(personalRecordSearch - 1);
            recordsList.add(personalRecordSearch - 1, " Deleted !");
        }
        writeUpdatedList(recordsList);  /// invoke method to store the updated details-------------


    }


    void writeUpdatedList(ArrayList<String> recordsList)  // writting uodated list in a file
    {

        try {

            FileWriter writePersonalIdentity = new FileWriter("PersonalDetails.txt");
            writePersonalIdentity.write("Person's Name is " + recordsList.get(0) + "\n");
            writePersonalIdentity.write("Person's Age is " + recordsList.get(1) + "\n");
            writePersonalIdentity.write("Person's Qualification is " + recordsList.get(2) + "\n");
            writePersonalIdentity.write("Person's City is " + recordsList.get(3) + "\n");
            writePersonalIdentity.write("Person's Address is " + recordsList.get(4) + "\n");
            writePersonalIdentity.write("Person's Phone Number is " + recordsList.get(5) + "\n");
            writePersonalIdentity.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");


    }


}
