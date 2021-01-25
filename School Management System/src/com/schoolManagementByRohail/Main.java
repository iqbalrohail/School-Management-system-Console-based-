package com.schoolManagementByRohail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

@FunctionalInterface
interface LoginMessage {
    void displayLoginMessage();
}

@FunctionalInterface
interface MethodsCall {

    void mainControl(String loginDecision) throws IOException;
}


public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        //:::: using lambda expressions for functional interfaces ::::
        LoginMessage loginMessage = () -> {
            System.out.println("Press 1 for Register");
            System.out.println("Press 2 for Login");
            System.out.println("Press any key for Exit");
        };


//==================================================================================================
        MainSecurity mainSecurity = new MainSecurity();
        MethodsCall methodsCall = loginDecision -> {

            if (loginDecision.equals("1")) {
                mainSecurity.register();

            } else if (loginDecision.equals("2")) {

                try {
                    mainSecurity.run();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Program being closed!****!");
            }
        };
        //==============================================================================================


        String loginDecision;

        do {

            loginMessage.displayLoginMessage();
            loginDecision = scanner.nextLine(); // takes one character
            methodsCall.mainControl(loginDecision);

        } while (loginDecision.equals("1") || loginDecision.equals("2")); // terminating state


    }
}
