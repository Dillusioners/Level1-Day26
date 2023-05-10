package Sperms;
// Importing necessary packages
import java.util.*;

// MemberManagement class
class GymManagement{
// Creating Scanner object to get user input
static Scanner scanner = new Scanner(System.in);

// Creating an ArrayList to store member records
static ArrayList<Member> memberList = new ArrayList<>();

// Main method
public static void main(String[] args) {
    boolean exit = false;
    
    // Displaying options to user using a while loop
    while (!exit) {
        System.out.println("\n Welcome to the Gym Management System!\n"
                         + "Please select an option:\n"
                         + "1. Add an Member\n"
                         + "2. Remove an Member\n"
                         + "3. Search for an Member\n"
                         + "4. View all Member\n"
                         + "5. Exit\n"
                         + "\n => Enter your option:- ");
        
        // Getting user input
        int choice = scanner.nextInt();
        
        // Switch case to perform different operations based on user input
        switch (choice) {
            case 1:
                addMember(); // Add a new member record
                break;
            case 2:
                removeMember(); // Remove an existing member record
                break;
            case 3:
                searchMember(); // Search for a specific member record
                break;
            case 4:
                viewAllMembers(); // View all member records
                break;
            case 5:
                exit = true; // Exit the program
                
                return;
            default:
                System.out.println("Invalid input, please try again.  \n \n \n"); // Display error message for invalid input
        }
    }
}

// Method to add a new member record
static void addMember() {
    scanner.nextLine(); // Consume the newline character left behind by scanner.nextInt()
    System.out.println("Please enter the Member's name:");
    String name = scanner.nextLine(); // Getting member name from user input
    System.out.println("Please enter the Member's address:");
    String address = scanner.nextLine(); // Getting member address from user input
    System.out.println("Please enter the Member's phone number:");
    String phone = scanner.nextLine(); // Getting member phone number from user input
    System.out.println("Please enter the Member's salary:");
    double salary = scanner.nextDouble(); // Getting member salary from user input
    
    // Creating a new Member object with the user input and adding it to memberList ArrayList
    Member newMember = new Member(name, address, phone, salary);
    memberList.add(newMember);
    System.out.println("Member added successfully! \n \n \n"); // Displaying success message
}

// Method to remove an existing member record
static void removeMember() {
    scanner.nextLine(); // Consume the newline character left behind by scanner.nextInt()
    System.out.println("Please enter the name of the Member to remove:");
    String name = scanner.nextLine(); // Getting member name to remove from user input
    
    // Looping through memberList ArrayList to search for member with specified name
    for (Member member : memberList) {
        if (member.getName().equals(name)) { // If member is found, remove it from memberList ArrayList
            memberList.remove(member);
            System.out.println("Member removed successfully!  \n \n \n"); // Displaying success message
            return;
        }
    }
    
    System.out.println("Member not found. \n \n \n"); // Displaying error message if member not found
}

// Method to search for a specific member record
static void searchMember() {
    scanner.nextLine(); // Consume the newline character left behind by scanner.nextInt()
    System.out.println("Please enter the name of the Member to search for:");
    String name = scanner.nextLine(); // Getting member name to search for from user
        
        for (Member member : memberList) {
            if (member.getName().equals(name)) { // If member is found, remove it from memberList ArrayList
                System.out.println("Member ID:- " + member);// Displaying ID
                System.out.println("Member Name:- " + member.getName());// Displaying Name
                System.out.println("Member Address:- " + member.getAddress());// Displaying Address
                System.out.println("Member Phone:- " + member.getPhone());// Displaying Phone
                System.out.println("Member Salary:- " + member.getSalary());// Displaying Salary
                return;
            }
        }
        
        System.out.println("Member not found.  \n \n \n"); // Displaying error message if member not found
    }
    
    static void viewAllMembers() {
        for (Member member : memberList) { // Looping all members
				System.out.println("\n ******************");
                System.out.println("Member ID:- " + member);// Displaying ID
                System.out.println("Member Name:- " + member.getName());// Displaying Name
                System.out.println("Member Address:- " + member.getAddress());// Displaying Address
                System.out.println("Member Phone:- " + member.getPhone());// Displaying Phone
                System.out.println("Member Salary:- " + member.getSalary());// Displaying Salary
                System.out.println("****************** \n");
                return;
        }
    }
}

class Member { // Making the class to store the member
    private String name; // Storing Name
    private String address; // Storing Address
    private String phone; // Storing Phone
    private double salary;// Storing Salary
    
    public Member(String name, String address, String phone, double salary) {
        this.name = name; // Storing Name
        this.address = address;// Storing Address
        this.phone = phone;// Storing Phone
        this.salary = salary;// Storing Salary
    }
    
    public String getName() {
        return name; // Giving Name
    }
    
    public String getAddress() {
        return address;// Giving address
    }
    
    public String getPhone() {
        return phone;// Giving Phone
    }
    
    public double getSalary() {
        return salary;//Giving Salary
    }
    
    public void setAddress(String address) {
        this.address = address;// Updating Address
    }
    
    public void setPhone(String phone) {
        this.phone = phone;//Updating Phone
    }
    
    public void setSalary(double salary) {
        this.salary = salary;//Updating Salary
    }
    
}
