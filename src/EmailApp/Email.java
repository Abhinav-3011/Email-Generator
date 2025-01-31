
package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail; // Corrected: Changed the name to match getter and setter methods
    private String companySuffix = "company.com";

    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        //System.out.println("Department chosen: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
       System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
       //System.out.println("Your email is: " + email);
    }

    // Method to ask for the department
    private String setDepartment() {
        System.out.println("Enter the Department \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner no = new Scanner(System.in);
        int depChoice = no.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Dev";
        } else if (depChoice == 3) {
            return "Acc";
        } else {
            return "";
        }
    }

    // Method to generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#%$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail; // Corrected: Changed the field name to match the getter and setter
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {  // Corrected: Fixed the method name to match the field name
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    // Method to display information
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" + // Corrected: Added a concatenation operator
                "\nCOMPANY EMAIL: " + email + "\n" +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}