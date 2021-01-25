package com.schoolManagementByRohail;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Teacher extends Admin {
    private int numberOfStudents, marksOfStudent;
    private String presentOrAbsent;


    Scanner scanner = new Scanner(System.in);

    void attendance() throws IOException {

        System.out.println("Enter the number of students in your class");
        numberOfStudents = scanner.nextInt();


        System.out.println("press P for present");
        System.out.println("press A for Absent");

        FileWriter fileWriter = new FileWriter("AttendanceRecord.txt");

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.println("Enter attendance for Roll number " + i);
            presentOrAbsent = scanner.next();


            if (presentOrAbsent.equals("P")) {
                fileWriter.write("Roll number " + i + " is Present\n");
                System.out.println("Roll number " + i + " is Present\n");
            } else if (presentOrAbsent.equals("A")) {
                fileWriter.write("Roll number " + i + " is Absent\n");
                System.out.println("Roll number " + i + " is Absent\n");
            }
        }
        fileWriter.close();


    }

    void marksRecord() throws IOException {


        System.out.println("Enter the number of students in your class");
        numberOfStudents = scanner.nextInt();


        FileWriter fileWriter = new FileWriter("MarksAndGradesRecord.txt");

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.println("Enter marks for Roll Number " + i);
            marksOfStudent = scanner.nextInt();


            if (marksOfStudent >= 90) {
                fileWriter.write("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (A)\n");
                System.out.println("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (A+)\n");
            } else if (marksOfStudent >= 80 && marksOfStudent < 90) {
                fileWriter.write("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (B)\n");
                System.out.println("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (B)\n");
            } else if (marksOfStudent < 80 && marksOfStudent >= 70) {
                fileWriter.write("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (C)\n");
                System.out.println("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (C)\n");

            } else if (marksOfStudent < 70 && marksOfStudent >= 60) {

                fileWriter.write("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (D)\n");
                System.out.println("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (D)\n");

            } else {
                fileWriter.write("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (F)\n");
                System.out.println("Marks for Roll number " + i + " are " + marksOfStudent + " and grade is (F)\n");

            }


        }
        fileWriter.close();


    }


}
