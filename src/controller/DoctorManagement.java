package controller;

import java.util.List;
import model.Doctor;
import view.Menu;
import util.Library;
import service.DoctorManagerService;

public class DoctorManagement extends Menu<String> {

    static String[] menuChoice = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};

    protected Library library;
    protected DoctorManagerService service;

    public DoctorManagement() {
        super("Doctor Management", menuChoice);
        library = new Library();
        service = new DoctorManagerService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                addDoctor();
                break;
            case 2:
                updateDoctor();
                break;
            case 3:
                deleteDoctor();
                break;
            case 4:
                searchDoctorByCode();
                break;
            case 5:
                return false;
            default:
                break;
        }
        return true;
    }

    private void addDoctor() {
        do {
            String code = library.getString("Enter Code");
            String name = library.getString("Enter Name");
            String specialization = library.getString("Enter Specialization");
            int availability = library.getInt("Enter Availability");

            boolean result = service.addDoctor(code, name, specialization, availability);

            if (result) {
//                System.out.println("Doctor added successfully!");
            } else {
                System.out.println("Failed to add Doctor.");
            }
            String addMore = library.getString("Do you want to add another Doctor? (Y/N)").trim();
            if (!addMore.equalsIgnoreCase("Y")) {
                break; 
            }
        } while (true);
    }

    private void updateDoctor() {
        String code = library.getString("Enter Code to Update");
        String name = library.getString("Enter New Name");
        String specialization = library.getString("Enter New Specialization");
        int availability = library.getInt("Enter New Availability");

        boolean result = service.updateDoctor(code, name, specialization, availability);

        if (result) {
//            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Failed to update Doctor.");
        }
    }

    private void deleteDoctor() {
        String code = library.getString("Enter Code to Delete");

        boolean result = service.deleteDoctor(code);

        if (result) {
//            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Failed to delete Doctor.");
        }
    }

    private void searchDoctorByCode() {
        String code = library.getString("Enter Code to Search");

        List<Doctor> searchResults = service.searchDoctor(code);

        if (searchResults.isEmpty()) {
            System.out.println("No matching Doctors found.");
        } else {
            System.out.println("Matching Doctors:");
            for (Doctor doctor : searchResults) {
                System.out.println("Code: " + doctor.getCode());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialization: " + doctor.getSpecialization());
                System.out.println("Availability: " + doctor.getAvailability());
                System.out.println("--------------------------------");
            }
        }
    }
}
