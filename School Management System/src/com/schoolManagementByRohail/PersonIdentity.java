package com.schoolManagementByRohail;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonIdentity extends MainSecurity {
    Scanner scanner = new Scanner(System.in);
    protected String name, age, qualification, city, address, phoneNumber;

    public void callSetters() // calling methods for getting input
    {
        setName();
        setAge();
        setCity();
        setAddress();
        setQualification();
        setPhoneNumber();


    }
// getters and setters

    public void setName() {
        System.out.println("Enter Name");
        this.name = scanner.nextLine();
    }

    public void setAge() {
        System.out.println("Enter Age");
        this.age = scanner.nextLine();
    }

    public void setQualification() {
        System.out.println("Enter Qualification");
        this.qualification = scanner.nextLine();
    }

    public void setCity() {
        System.out.println("Enter city");
        this.city = scanner.nextLine();
    }

    public void setAddress() {

        System.out.println("Enter Address");
        this.address = scanner.nextLine();

    }

    public void setPhoneNumber() {

        System.out.println("Enter PhoneNumber");
        this.phoneNumber = scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void getPersonalDetails() {

        System.out.println("Person's Name is " + getName());
        System.out.println("Person's Age is " + getAge());
        System.out.println("Person's Qualification is " + getQualification());
        System.out.println("Person's City is " + getCity());
        System.out.println("Person's Address is " + getAddress());
        System.out.println("Person's Phone Number is " + getPhoneNumber());

        writePersonalDetails(); // calling method to write details in a file

    }

    public void writePersonalDetails() {
        try {


            FileWriter writePersonalIdentity = new FileWriter("PersonalDetails.txt");


            writePersonalIdentity.write(  name + "\n");
            writePersonalIdentity.write( age + "\n");
            writePersonalIdentity.write(qualification + "\n");
            writePersonalIdentity.write( city + "\n");
            writePersonalIdentity.write( address + "\n");
            writePersonalIdentity.write( phoneNumber + "\n");

            writePersonalIdentity.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }


    public void readPersonalDetails() {
        try {
            FileReader readPersonalIdentity = new FileReader("PersonalDetails.txt");
            int i;
            while ((i = readPersonalIdentity.read()) != -1)
                System.out.print((char) i);
            readPersonalIdentity.close();
        } catch (Exception e) {
            System.out.println("Success...");

        }
    }


}





