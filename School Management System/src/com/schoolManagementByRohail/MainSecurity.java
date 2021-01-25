package com.schoolManagementByRohail;


import java.beans.ConstructorProperties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSecurity {
    private String registerUser, registerPassword;

    public void register() {
        Scanner scanner = new Scanner(System.in);


        try {
            FileWriter loginWritter = new FileWriter("LoginDetails.txt");
            System.out.println("Enter your user Name");
            registerUser = scanner.nextLine();
            loginWritter.write(registerUser + "\n");
            System.out.println("Enter your Password");
            registerPassword = scanner.nextLine();
            loginWritter.write(registerPassword + "\n");
            loginWritter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void run() throws IOException {
        Scanner scan = new Scanner(new File("LoginDetails.txt"));
        Scanner keyboard = new Scanner(System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan
        System.out.println("Enter your user Name");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter your Password");
        String inpPass = keyboard.nextLine(); // gets input from user
// ======================================================================================================================================================
        if (inpUser.equals(user) && inpPass.equals(pass)) {
            Scanner scanner = new Scanner(System.in);

            // creating  objects

            Teacher teacher = new Teacher();
            Admin admin = new Admin();
            Student student = new Student();


            System.out.print("You have been Logged IN!\n\n");


            System.out.println("You can login as the following domains");

            ArrayList<String> list = new ArrayList<>();//creating  arraylist

            list.add("admin");
            list.add("teacher");
            list.add("student");

            System.out.println(list);
            System.out.println("\nEnter any of the options mentioned above");
            System.out.println("\nNote that the spelling of your choice matches with the above options");
            String listChoice = scanner.nextLine();

            if (list.contains(listChoice)) {

                if (listChoice.equals(list.get(0))) {
                    // Admin methods


                    System.out.println("\n\n");
                    System.out.println("Press 1 for Records Access");

                    String adminAccess = scanner.nextLine();
                    if (adminAccess.equals("1")) {


                        System.out.println("Press 1 for Modify Records");
                        System.out.println("Press 2 for Delete Records");
                        System.out.println("Press 3 for Show Records");
                        String adminFeatures = scanner.nextLine();
                        if (adminFeatures.equals("1")) {

                            admin.personalRecordList(adminFeatures);
                        } else if (adminFeatures.equals("2")) {
                            admin.personalRecordList(adminFeatures);

                        } else if (adminFeatures.equals("3")) {
                            admin.readPersonalDetails();
                        }

                    } // main admin condition


// ==================================================================================================================================================================
                } else if (listChoice.equals(list.get(1))) {
                    // Teacher methods
                    teacher.callSetters();
                    teacher.getPersonalDetails();
                    System.out.println("\n\n");
                    System.out.println("Press 1 for Enter Attendance");
                    System.out.println("Press 2 for Enter Marks/Grades");

                    String teacherAccess = scanner.nextLine();

                    if (teacherAccess.equals("1")) {
                        teacher.attendance(); // for entering attendance record

                    } else if (teacherAccess.equals("2")) {
                        teacher.marksRecord(); // for entering marks record

                    } else {
                        System.out.println("***** Only Press 1 or 2 *****");
                    }


// ==================================================================================================================================================================
                } else if (listChoice.equals(list.get(2))) {
                    // Student methods
                    student.callSetters();
                    student.getPersonalDetails();
                    System.out.println("\n\n");
                    System.out.println("Press 1 for Attendance Details");
                    System.out.println("Press 2 for Marks/Grades Details");

                    String studentAccess = scanner.nextLine();

                    if (studentAccess.equals("1")) {
                        student.attendanceView(); // for entering attendance record

                    } else if (studentAccess.equals("2")) {
                        student.marksAndGradesView(); // for entering marks record

                    } else {
                        System.out.println("***** Only Press 1 or 2 *****");
                    }


// ==================================================================================================================================================================
                }


            }// end of Main choice condition
            else {
                System.out.println("You may have done some spelling mistake or your specified choice is not in the above list!!!");
            }


        } //========================== end of main If condition =====================
        else {
            System.out.print("your error message");
        }
    }


}
