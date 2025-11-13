package Assigment1;

// Purpose:
// Main class of my programn. As it contains the 'main' method which serves as the entry point for the programn.
// the programn initializes the  'HealthService' and 'Scanner' classes objects, displaying a welcome message and manages 
// the main loop that presents  the user with a menu option.
// The user's choice is mapped to specific actions using a 'Hashmap' of 'Runnable' lambdas objects.

import java.util.Scanner; //import the scanner class which is used to read the person's input
import java.util.Map; //import the map class are used to map the menu options which is going to be shown down there 
import java.util.HashMap; //import hashmap which are used to map menu options to action however it stores keyvalue

public class MedicalConsole {
    private static HealthService healthService; //grabs the health service from the HealthService class 
    //  the class is used to store all the patients, facilities, and procedures for the programn.
    private static Scanner scanner; // object to reader user input from the console
    public static void main(String[] args) {
        healthService = new HealthService("Health Service"); //creates a brand new health service object
        scanner = new Scanner(System.in); //creates a new scanner object which can be used to read out user input

        
        System.out.println ("Welcome to the Medical Console!");
        // Display a welcome message for users

        boolean exit = false; // boolean to check if the user wants to exit the program
        while (!exit) { // while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
            showMenu(); //display the menu options to the user
            int choice = getChoice(); //get the user's choices from the programn

            Map<Integer, Runnable> menuMap = new HashMap<>(); //Just like from the import this creates a map which is used to import the menu options
            menuMap.put(1, () -> addObject()); //add object to the menu map
            menuMap.put(2, () -> listObjects()); //lists objects to the menu map
            menuMap.put(3, () -> visitFacility()); //visit facility to the menu map
            menuMap.put(4, () -> operateOnPatient()); //operate on patient to the menu map
            menuMap.put(5, () -> deleteObject()); //delete object to the menu map
            menuMap.put(6, () ->  {
                System.out.println("Goodbye!"); //exit the said programn and then close the scanner
                scanner.close(); //is used to close the scanner
            });
            
            menuMap.getOrDefault(choice, () -> System.out.println("ERROR CHOICE BUDDY")).run();
            // if the user enters an invalid option then it will return the user to the main menu
        }
        scanner.close(); //closes the scanner
        // this code uses menuMap (Map<Integer, Runnable>) to map the user's choice to the corresponding action.
        // Each option is mapped to a lambda that performs a specific action. An example can be
        // calling methods like addObject(), listObjects(), visitFacility(), operateOnPatient()  etc.
    }   // If user enters an ivalid choice,   a default lambda would say "Invalid option. Returning to main menu."
        // program continue until user ends the cycle by pressing 5 which says "GoodBye" 


        // another method which is not lambda =

        // switch(choice) {

        //         while (!exit) {
            //showMenu();
            //int choice = getChoice();
            //switch (choice) {
                //case 1:
                    //addObject();
                    //break;
                //case 2:
                    //listObjects();
                    //break;
                //case 3:
                    //visitFacility();
                    //break;
                //case 4:
                    //operateOnPatient();
                    //break;
                //case 5:
                    //exit = true;
                    //break;
                //default:
                    //System.out.println("Invalid choice. Please try again.");
                    //break;

    private static void showMenu() { //class for the menu which display the menu options for the user
        //and that is where i put the show menu for the user in the choices
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"); //prints out the menu
        System.out.println("\nMenu:"); //user can use the menu
        System.out.println("1. Add Object"); // user can add object to the programn
        System.out.println("2. List Objects"); // user can list objects from the programn
        System.out.println("3. Visit Facility"); // user can visit a facility from the programn
        System.out.println("4. Operate on Patient"); // user can operate on a patient from the programn
        System.out.println("5. Delete Object"); // user can delete object from the programn
        System.out.println("6. Exit"); // user can exit the programn
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");    //prints out the menu
        System.out.print("Enter your choice here: "); //user can enter the choices 

        // Summary :
        // This method is used to display the menu to the user and get their choices
    }


    private static int getChoice() { // this is the getChoice() method which is used to get the user's choice
    int choice = -1; // Initialize choice to -1 to indicate invalid input
    while (true) { // while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
        String input = scanner.nextLine().trim(); // Read user input and trim whitespace
        if (input.isEmpty()) { // If input is empty, print error message and ask for input again
            System.out.println("Please input, try again: "); // Print error message
        } else { // If input is not empty, parse it as an integer
            try { // Try to parse input as an integer
                choice = Integer.parseInt(input); // Parse input as an integer
                break; // Exit loop if valid integer is parsed
            } catch (NumberFormatException e) { // If input is not an integer, print error message and ask for input again
                System.out.println("Invalid input. Please enter a number: ");
            } // Catch NumberFormatException to handle invalid input
        }
    }

    // Summary :
    // This method reads the user input and ensures it is an integer and if it is not the prompt will ask for another one
    // It returns the integer value of the user input
    // It uses a while loop to keep the program running until the user enters a valid integer like it is asked

    return choice;
    }
    // reads the user input and ensures it is an integer and if it  is not the prompt will ask to add for a valid number


   
    // Add Object Functionality
    private static void addObject() { //class for the add object menu which displays the menu options for the user
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nAdd Object:"); //user can add object to the programn
        System.out.println("1. Patient"); // user can add patient to the programn
        System.out.println("2. Medical Facility"); // user can add medical facility to the programn
        System.out.println("3. Add Procedure"); // user can add procedure to the programn
        System.out.println("4. Back to Main Menu"); //returns to main menu
        System.out.print("Enter your choice here: "); //what are the choices the user can enter


        int choice = getChoice();// gets the user's choice 
         
            Map<Integer, Runnable> ObjectMap = new HashMap<>(); // creates a map for the object menu
            ObjectMap.put(1, () -> addPatient()); //lambda expression for the patient option
            ObjectMap.put(2, () -> addFacility()); //Lambda expression for the medical facility option
            ObjectMap.put(3, () -> addProcedure()); //Lambda experession for to add an 
            ObjectMap.put(4, () -> backToMainMenu()); //Lambda expression for back to menu

            ObjectMap.getOrDefault(choice, () -> System.out.println("Invalid choice. Please try again.")).run();
            // in here the code uses Map<Integer, Runnable> Objectmap which is used to associate
            // the user's choice with the corresponding action to be taken. Each Lambda expression 
            // executes the corresponding action and the code then goes back to the main menu. 
            // an example of lambda in here is add Patient() or addProcedure().
            // The method is being called using .run(). If the choice is invalid, a default lambda
            // then prints an error message, as this method avoids repetitive if-else or switch statments 
            // which makes the code modular and extendable . 

            //this is the switch menu = (another method which can be used)
            //switch (choice) {
                //case 1:
                    //addPatient();
                    //break;
                //case 2:
                    //addFacility();
                    //break;
                //case 3:
                    //addProcedure();
                    //break;
                //default:
                    //System.out.println("Invalid choice. Please try again.");
                    //break;

    }


    private static void addPatient() {  
        System.out.print("<Enter to continue> ");    //add patients class which by it's name add patients                    
        scanner.nextLine();  //clear the screen
        System.out.print("Enter to Patient's name: "); //ask for the patient's name
        String name = scanner.nextLine(); //get the patient's name

        while (name.isEmpty()) { //if the name is empty then it will print the message "Patient name cannot be empty!, please try again: "
            System.out.print("Patient name cannot be empty!, please try again: "); //prints the message "Patient name cannot be empty!, please try again: "
                        name = scanner.nextLine(); //clear the screen
        }

        boolean isPrivate; //boolean to check if the patient is private
        while (true) { //while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
            System.out.print("Is patient private? (Y/N): "); //ask if the patient is private
            String input = scanner.nextLine().trim(); //get the input from the user

            if (input.equalsIgnoreCase("Y")) { //   if the user enters Y then it will set isPrivate to true
                isPrivate = true; //set isPrivate to true
                break; //break the loop
            } else if (input.equalsIgnoreCase("N")) { // if the user enters N then it will set isPrivate to false
                isPrivate = false; //set isPrivate to false
                break; //break the loop
            } else { // else again it will print an error message
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
            }
        }

        
         //ask for the patient's balance
        double balance;
        while (true) {
            System.out.print("Enter the Patient's balance:"); //ask for the patient's balance
            String balanceInput = scanner.nextLine(); //get the patient's balance

            if (balanceInput.isEmpty()) { //if the balance is empty then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue; //continue the loop
            }

            try {
                balance = Double.parseDouble(balanceInput); //parse the balance to a double
                if (balance < 0) { //if the balance is less than 0 then it will print the message "Patient balance is " + balance
                    System.out.println("Patient balance is " + balance); //prints the message "Patient balance is " + balance
                } else { //else again it will print an error message
                    break; //   break the loop
                }
        } catch (NumberFormatException e) { //if the balance is not a number then it will print the message "Invalid input. Please try again."
            System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
            continue; //continue the loop
        }
    }
    
    Patient newPatient = new Patient(name, isPrivate, balance); 
    healthService.addPatient(newPatient); // Add the patient to the health service
    System.out.println("Patient added successfully: " + newPatient); // Confirmation message
    System.out.println("Is patient name:" + name); // Display the privacy status
    System.out.println("Is patient private? " + isPrivate); // Display the privacy status
    System.out.println("Initial balance: " + balance); // Display the initial balance

    // Summary :
    // This method is used to add patients to the health service
    // It asked the user for the patient's name, whether the patient is private or not, and the initial balance
    }   
        

    private static void addFacility() { //add facility class which by it's name add facilities
        System.out.println("1. Add Hospital"); //menu display the choices for the prompt
        System.out.println("2. Add Clinic"); //menu display the choices for the prompt
        System.out.print("Enter your choice here: ");
        // menu display the choices for the prompt
        // option 1 is for hospital and option 2 is for clinic
        int choice = getChoice(); //get the user's choice from up there
        if (choice == 1) {  //if the user enters 1 then it will add a hospital
            addHospital(); //add a hospital prompt
        } else if (choice == 2) { // if not 1 then it will add a clinic
            addClinic(); //adds a clinic prompt
        } else { // else again it will print an error message
            System.out.println("Error please go back"); // prints an error message of "error pelase go back"
        }
    }


    private static void addHospital() { //add hospital class which by it's name add hospital
        System.out.print("<Enter to continue> ");
        scanner.nextLine(); //clear the screen

        System.out.print("Enter the hospital name: "); //ask for the hospital's name
        String name = scanner.nextLine(); //get the hospital's name

        while (true) {
            if (!name.isEmpty()) { //if the name is not empty then it will break the loop
                break;
            } else {
                System.out.println("Hospital name cannot be empty!"); //prints the message "Hospital name cannot be empty!"
                System.out.print("Enter the hospital name again: "); //prints the message "Enter the hospital name again: "
                name = scanner.nextLine(); //get the hospital's name again
            }
        }
        
       
        double probAdmit;

        while (true) {
            System.out.print("Enter Admission probability (0 to 1): "); //ask for the hospital's fee
            String probAdmitInput = scanner.nextLine();  //get the hospital's admission probability

            if (probAdmitInput.isEmpty()) {
                System.out.println("Invalid input. Please try again.");  //prints the message "Invalid input. Please try again."
                continue; //continue the loop
            }

            try {
                probAdmit = Double.parseDouble(probAdmitInput); //parse the admission probability to a double
                if (probAdmit < 0.0 || probAdmit > 1.0) { //if the admission probability is less than 0.0 or greater than 1.0 then it will print the message "Admission probability must be between 0.0 and 1.0!"
                    System.out.println("Admission probability must be between 0.0 and 1.0!"); //prints the message "Admission probability must be between 0.0 and 1.0!"
                    continue; //continue the loop
                }
                break; //break the loop
            } catch (NumberFormatException e) { //if the admission probability is not a number then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue;
            }

            // Summary :
            // This method is used to add hospitals to the health service 
            // It asked the user for the hospital's name and the admission probability
            // It created a new hospital object and added it to the health service
            // It prints the hospital name and the admission probability
        }


        
        Hospital newHospital = new Hospital(name, probAdmit); //create a new hospital object
        healthService.addMedicalFacility(newHospital); //add the hospital to the database
        System.out.println("Hospital added successfully: " + newHospital); //prints the hospital name and the admission probability
        System.out.println("Is hospital name:" + name); // Display the name of the hospital
        System.out.println("Is hospital private? " + probAdmit);  //Display the privacy status

        // Summary : 
        // this method is used to add hospitals to the health service 
        // it asked the user for the hospital's name and the admission probability
        // it created a new hospital object and added it to the health service
    }                                                                               


    private static void addClinic() {
        System.out.print("<Enter to continue> ");
        scanner.nextLine(); //clear the screen

        System.out.print("Enter clinic name: "); // asks you for the clinic name
        String name = scanner.nextLine(); 
        while (true) { //while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
            if (!name.isEmpty()) { //if the name is not empty then it will break the loop
                break; //break
            } else {
                System.out.println("Clinic name cannot be empty!"); //prints the message "Clinic name cannot be empty!"
                System.out.print("Enter clinic name again: "); //prints the message "Enter clinic name again: "
                name = scanner.nextLine(); //clear the screen
            }
        }
        double fee; //double to check if the clinic's fee is a number
        while (true) {
            System.out.print("Enter fee: "); //ask for the clinic's fee
            String feeInput = scanner.nextLine(); // get the clinic's fee

            if (feeInput.isEmpty()) { //if the fee is empty then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue; //continue the loop
            }

            try { //try to parse the fee to a double
                fee = Double.parseDouble(feeInput); //parse the fee to a double
                if (fee < 0.0) { //if the fee is less than 0.0 then it will print the message "Fee must be greater than or equal to 0.0"
                    System.out.println("Fee must be greater than or equal to 0.0"); //prints the message "Fee must be greater than or equal to 0.0"
                    continue; //continue the loop
                }
                break;
            } catch (NumberFormatException e) { //if the fee is not a number then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue; // continue the loop
            }
          
        }

        double gapPercent;
        while (true) { //while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
            System.out.print("Enter gap percent (for public patients): "); //ask for the clinic's gap percent
            String gapPercentInput = scanner.nextLine(); //get the clinic's gap percent

            if (gapPercentInput.isEmpty()) { //if the gap percent is empty then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
            }

            try {
                gapPercent = Double.parseDouble(gapPercentInput); //parse the gap percent to a double
                if (gapPercent < 0.0 || gapPercent > 100.0) { //if the gap percent is less than 0.0 or greater than 100.0 then it will print the message "Gap percent must be between 0.0 and 100.0!"
                    System.out.println("Gap percent must be between 0.0 and 100.0!"); //prints the message "Gap percent must be between 0.0 and 100.0!"
                    continue; //continue the loop
                }
                break;
            } catch (NumberFormatException e) { //if the gap percent is not a number then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue; //    continue the loop
            }
        }
          // Summary :
            // This method is used to add clinics to the health service 
            // It asked the user for the clinic's name and the fee
            // It created a new clinic object and added it to the health service
            // It prints the clinic name and the fee
        Clinic newClinic = new Clinic(name, fee, gapPercent); // create a new clinic object
        healthService.addMedicalFacility(newClinic); //add the clinic to the database
        System.out.println("Clinic added successfully: " + newClinic); //prints the clinic name and the fee
    }

    
    private static void addProcedure() { // class which is used to add procedure 
        System.out.print("<Enter to continue> ");
        scanner.nextLine(); //clear the screen

        System.out.print("Enter the procedure name: "); //ask for the procedure's name
        String ProcedureName = scanner.nextLine(); //get the procedure's name

        while (true) {
            if (!ProcedureName.isEmpty()) {
                break;
            } else {
                System.out.println("Procedure name cannot be empty!");
                System.out.print("Enter the procedure name again: ");
                ProcedureName = scanner.nextLine();
            }
        }
        
        System.out.print("Enter the procedure description: "); //ask for the procedure's description
        String description = scanner.nextLine(); //get the procedure's description

        while (true) {
            if (!description.isEmpty()) {
                break;
            } else {
                System.out.println("Procedure description cannot be empty!"); //prints the message "Procedure description cannot be empty!"
                System.out.print("Enter the procedure description again: "); //prints the message "Enter the procedure description again: "
                description = scanner.nextLine(); //get the procedure's description again
            }
        }
        
        boolean isElective;

        while (true) {
            System.out.print("Is the procedure elective? (Y/N): "); //ask for the procedure's elective
            String input = scanner.nextLine().trim(); //get the input from the user

            if (input.equalsIgnoreCase("Y")) { //if the user enters Y then it will set isElective to true
                isElective = true; //set isElective to true
                break;
            } else if (input.equalsIgnoreCase("N")) { //if the user enters N then it will set isElective to false
                isElective = false; //set isElective to false
                break;
            } else {
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
            }
        }

        double cost;
        while (true) {
            System.out.print("Enter the procedure cost: "); //ask for the procedure's cost
            String costInput = scanner.nextLine(); //get the procedure's cost

            if (costInput.isEmpty()) {
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue; //    continue the loop
            }

            try {
                cost = Double.parseDouble(costInput); //parse the cost to a double
                if (cost < 0.0) { //if the cost is less than 0.0 then it will print the message "Procedure cost must be greater than or equal to 0.0!"
                    System.out.println("Procedure cost must be greater than or equal to 0.0!"); //prints the message "Procedure cost must be greater than or equal to 0.0!"
                    continue; //continue the loop
                }
                break; //break the loop
            } catch (NumberFormatException e) { //if the cost is not a number then it will print the message "Invalid input. Please try again."
                System.out.println("Invalid input. Please try again."); //prints the message "Invalid input. Please try again."
                continue;
            }
        }
        
        System.out.print("Select Hospital ID for this procedure: ");
        int hospitalId = getChoice(); // get the Hospital ID
    
        MedicalFacility selectedFacility = healthService.findfacilityByID(hospitalId); // find the facility by the Hospital ID
        if (selectedFacility == null) { // if the facility is not found
            System.out.println("Hospital not found!");
            return;
        }
        
        if (!(selectedFacility instanceof Hospital)) { // Check if the selected facility is a Hospital
            System.out.println("Selected facility is not a Hospital!");
            return;
        }
    
        Hospital selectedHospital = (Hospital) selectedFacility; // Safe cast to Hospital
    
        // Now you can proceed with adding the procedure
        Procedure newProcedure = new Procedure(ProcedureName, description, cost, isElective); // create a new procedure object
        selectedHospital.addProcedure(newProcedure); // add the procedure to the hospital
        System.out.println("Procedure added successfully: " + newProcedure); // prints the procedure name and description
    }

    private static void backToMainMenu() {
        System.out.println("Exiting The Medical Console...");
        //prints the exiting message
        return;
        //returns to the main menu
    }
    //Conclusion for up here : AddHospital, AddClinic, AddProcedure, BackToMainMenu make up the functions

    // List Objects Functionality
    private static void listObjects() { //list objects
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"); // prints a divider
        System.out.println("\nList Objects:"); // prints a header
        System.out.println("1. List Patients"); // prints the first option
        System.out.println("2. List Medical Facilities"); // prints the second option
        System.out.println("3. List Procedures"); // prints the third option
        System.out.println("4. Back to Main Menu"); // prints the fourth option
        System.out.println("Enter your choice: ");// prints the promptX
 

        int choice = getChoice();
        
        Map<Integer, Runnable> listMap = new HashMap<>();
        listMap.put(1, () -> healthService.getPatients().forEach(System.out::println));
        listMap.put(2, () -> healthService.getFacilities().forEach(System.out::println));
        listMap.put(3, () -> healthService.getProcedures().forEach(System.out::println));
        listMap.put(4, () -> backToMainMenu());

        listMap.getOrDefault(choice, () -> System.out.println("Invalid option. Returning to main menu.")).run();
    }
    // code which display a console based menu that allows the user to select a list of objects such as patients,
    // facilities, or procedures. The user can then select to return to the main menu or quit the application.
    // the user input is mapped to an action using HashMap

    //alternative code for the above code
    //switch (choice) {
       // case 1:
            //healthService.getPatients().forEach(System.out::println);
            //break;
        //case 2:
            //healthService.getFacilities().forEach(System.out::println);
            //break;
        //default:
           // System.out.println("Invalid option. Returning to main menu.");
   // }



   
    private static void visitFacility() { //visit facility class which by it's name visit facility
        System.out.print("Enter Patient ID: "); //prompts the user to enter the patient id
        int patientId = getChoice(); //retreives the patient id from the user
        Patient patient = healthService.getPatients().stream().filter(f -> f.getId() == patientId).findFirst().orElse(null);
        //searches through a list of patient(healthservice.getPatient), filters the patients based on matching patientID and returns the first matching patient or null if not found.                                                                         
        if (patient == null) {
            System.out.println("Patient not found!"); //prints the patient not found message
            return; //patients not found then returns
        }


        System.out.print("Enter Facility ID: "); //asked for the facility id
        int facilityId = getChoice(); //retreives the facility id from the user
        MedicalFacility facility = healthService.getFacilities().stream().filter(f -> f.getId() == facilityId).findFirst().orElse(null);
        //searches through a list of medical facility(healthservice.getFacilities), filters the facilities based on matching facilityID and returns the first matching facility or null if not found.
        if (facility == null) {  //if the facility is not found then it will print the facility not found message
            System.out.println("Facility not found!"); //prints the facility not found message
            return; //when facility is not found then it returns
        }


        boolean success = facility.visit(patient); //calls the visit method on the facility with the patients as a parameter.                                     
        System.out.println(success ? "Visit successful!" : "Visit registered, please return for consultation."); // prints visit success or visit registered
    }




    private static void operateOnPatient() { // this is the class for the Operate on Patient Menu
        System.out.println("~~~~~~~"); 
        System.out.println("\nOperate on Patient"); // prints out the message operate on patient
        System.out.println("0. Go Back"); // press 0 to go back 
        System.out.println("Please Enter Hospital ID or (press 0 to go back): "); //please enter the hospital id or go back
        System.out.println("~~~~~~~");

        int HospitalId = getChoice(); // this is the getChoice() method which is used to get the user's choice
        if(HospitalId == 0) return; // returns when user press 1 to go back
        
        MedicalFacility facility = healthService.findfacilityByID(HospitalId); // this is the findfacility() method which is used to find the facility based on the HospitalId
        if (facility == null) { // if the facility is null then it will print the message "Hospital not found!"
            System.out.println("Hospital not found!"); // prints the message "Hospital not found!"
            return; // returns when the hospital is null/ facility is not found
        }
        
        System.out.println("Please Enter Patient ID:"); //prompts the user to enter the patient id
        int patientId = getChoice(); //retreives the patient id from the user
        Patient patient = healthService.getPatients() //searches through a list of patient(healthservice.getPatient), filters the patients based on matching patientID and returns the first matching patient or null if not found.
                .stream()  
                .filter(p -> p.getId() == patientId)
                .findFirst()
                .orElse(null);
        //The lambda expression is a short way to define the condition for filtering the 'patient' list. example is the 'p -> p.getId() == patientId'
        // it allows the code to effeciently search through the list of patients and retreive the one that matches the given ID or return 'null' if no patient exist.
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        //if the patient is not found then it will print the message "Patient not found!"
        System.out.println("Please Enter Procedure ID:");
        int procedureId = getChoice();
        Procedure procedure = healthService.getProcedures()
                .stream()
                .filter(p -> p.getId() == procedureId)
                .findFirst()
                .orElse(null);
        //The lambda expression is a short way to define the condition for filtering the 'procedure' list. example is the 'p -> p.getId() == procedureId'
        // it allows the code to effeciently search through the list of procedures and retre
        if (procedure == null) {
            System.out.println("Procedure not found!");
            return;
        }
        //if the procedure is not found then it will print the message "Procedure not found!"
        boolean success = facility.operateOnPatient(patient, procedure);
        System.out.println(success ? "Procedure successful!" : "Procedure registered, please return for consultation.");
        //prints the success message or the message "Procedure registered, please return for consultation."

        
    }
    
    public static void deleteObject() { // this is the class for the Delete Object Menu
        System.out.println("~~~~~~~"); // prints out the message operate on patient
        System.out.println("\nDelete Object");  // prints out the message delete object
        System.out.println("1. Delete Patient"); // prints out the message delete patient
        System.out.println("2. Delete Medical Facility");
        System.out.println("3. Delete Procedure");
        System.out.println("4. Back to Main Menu");
        System.out.println("Please Enter your choice here: ");

        int choice = getChoice();

        Map<Integer, Runnable> deleteMap = new HashMap<>();
        deleteMap.put(1, () -> deletePatient()); // maps the choice to the deletePatient method
        deleteMap.put(2, () -> deleteFacility()); // maps the choice to the deleteFacility method
        deleteMap.put(3, () -> deleteProcedure()); // maps the choice to the deleteProcedure method
        deleteMap.put(4, () -> backToMainMenu()); // maps the choice to the backToMainMenu method

        deleteMap.getOrDefault(choice, () -> System.out.println("Invalid choice. Please try again.")).run();
        
    
    }

    private static void deletePatient() { // deletes a patient from the database
        System.out.println("Please provide the Patient ID: ");  // prints out the message please provide the patient id
        int patientId = getChoice(); //get the patient id from the user
        
        Patient patient = healthService.findPatientById(patientId); //find the patient by the patient id
        if (patient == null) { //if the patient is not found
            System.out.println("Patient not found! like the avatar"); //prints the message "Patient not found!"
            return; 
        } else
        
        healthService.deletePatient(patient);
        System.out.println("Oh wow suddenly thePatient has dissapeared!"); //prints the message "Oh wow suddenly thePatient has dissapeared!"
        //suddenly it dissapears
       }

    private static void deleteFacility() {
        System.out.println("Please provide Facility ID: "); //prints the message "Please provide the ID for the facility: "
        int HospitalId = getChoice(); //get the facility id from the user

        MedicalFacility facility = healthService.findfacilityByID(HospitalId); //find the facility by the facility id
        if (facility == null) { //if the facility is not found
            System.out.println("Please provide the ID :"); //prints the message "Please provide the ID :"
            return; //returns when the facility is not found
        }
        
        healthService.deleteFacility(facility); //delete the facility
        System.out.println("Facilty got blown up"); //prints the message "Facilty got blown up"
    }

    private static void deleteProcedure() { 
        System.out.println("Please provide the ID :"); //prints the message "Please provide the ID :"
        int procedureId = getChoice(); //get the procedure id from the user

        Procedure procedure = healthService.findProcedureById(procedureId); //find the procedure by the procedure id
        if (procedure == null) { //if the procedure is not found
            System.out.println("Procedure not found!"); //prints the message "Procedure not found!"
            return; //returns when the procedure is not found
        }

        healthService.deleteProcedure(procedure);
        System.out.println("What procedure? theres no procedure to delete"); //prints the message "What procedure? theres no procedure to delete"
        

    }
}

// conclusion:
// MedicalConsole class is used to create a console based menu that allows the user to add, list, and delete objects from the programn which makes it Main interface.
// the 'HealthService' class is used to store all the patients, facilities, and procedures for the programn.
// classes like 'Patient', 'MedicalFacility', and 'Procedure' are used to store the objects.
// the imlementation of  lambda expressions is used to map the user's choice to the corresponding action.
// effective input validation mechanism are in place to ensure the user enters the correct data.

//overall, this code is a good example of how to use lambda expressions and how to implement them in a console based menu.

//what is the purpose of this code?
//this code is a console based menu that allows the user to add, list, and delete objects from the programn which makes it Main interface.
//the 'HealthService' class is used to store all the patients, facilities, and procedures for the programn.
//classes like 'Patient', 'MedicalFacility', and 'Procedure' are used to store the objects.
//the imlementation of  lambda expressions is used to map the user's choice to the corresponding action.
//effective input validation mechanism are in place to ensure the user enters the correct data.


// Reflection =
// overall, from this project it teaches me how to use lambda expressions and how to implement them in a console based menu.
// also getter, and setters methods which are used to access the private variables of the class.
// the imlementation of  lambda expressions is used to map the user's choice to the corresponding action.
// effective input validation mechanism are in place to ensure the user enters the correct data.
// and the use of reflection is used to access the private variables of the class.
// i also learn inhereitance and polymorphism


//Challanges:
//1. How to implement map, filter, and reduce in a console based menu.
//2. How to implement the use of reflection in a console based menu.
//3. How to implement the use of Lambda expressions in a console based menu. which i found can be hard for me to comprehend.
//4. making the delete object menu, was hard for me to do because i was not really sure on how to use lambda expression for this
//5. adding the procedure also was hard for me, because at the time i dont know how to implement it for my code