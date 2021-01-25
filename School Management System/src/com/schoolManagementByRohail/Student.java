package com.schoolManagementByRohail;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Student extends Teacher {

    Scanner scanner = new Scanner(System.in);
    private int studentRollNumber;

    Student() {
    } // free constructor

    void attendanceView() {
        System.out.println("Enter your Roll Number");
        studentRollNumber = scanner.nextInt();


        try {
            FileReader DetailsReader = new FileReader("AttendanceRecord.txt");

            String specific_Attendence = Files.readAllLines(Paths.get("AttendanceRecord.txt")).get(studentRollNumber - 1);  // reading specific lines
            System.out.println(specific_Attendence);

            DetailsReader.close();

        } catch (Exception e) {
            System.out.println(e);

        }


    }


    void marksAndGradesView() {
        System.out.println("Enter your Roll Number");
        studentRollNumber = scanner.nextInt();


        try {
            FileReader DetailsReader = new FileReader("MarksAndGradesRecord.txt");

            String specific_Attendence = Files.readAllLines(Paths.get("MarksAndGradesRecord.txt")).get(studentRollNumber - 1);  // reading specific lines
            System.out.println(specific_Attendence);

            DetailsReader.close();

        } catch (Exception e) {
            System.out.println(e);

        }


    }


}
