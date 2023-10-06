package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Doctor;

public class DoctorManagerService {

    private List<Doctor> doctorList;
    private Scanner scanner;

    public DoctorManagerService() {
        doctorList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public boolean addDoctor(String code, String name, String specialization, int availability) {
        System.out.print("Do you want to add this doctor? (Y/N): ");
        String choice = scanner.nextLine().trim();
        if (choice.equalsIgnoreCase("Y")) {
            Doctor newDoctor = new Doctor(code, name, specialization, availability);
            boolean added = doctorList.add(newDoctor);
            System.out.println("Doctor added successfully!");
            return added;
        } else {
            System.out.println("Add operation canceled.");
            return false;
        }
    }

    public boolean updateDoctor(String code, String newName, String newSpecialization, int newAvailability) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equals(code)) {
                System.out.println("Doctor Information:");
                System.out.println("Code: " + doctor.getCode());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialization: " + doctor.getSpecialization());
                System.out.println("Availability: " + doctor.getAvailability());

                System.out.print("Do you want to update this doctor? (Y/N): ");
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("Y")) {
                    doctor.setName(newName);
                    doctor.setSpecialization(newSpecialization);
                    doctor.setAvailability(newAvailability);
                    System.out.println("Doctor updated successfully!");
                    return true;
                } else {
                    System.out.println("Update operation canceled.");
                    return false;
                }
            }
        }
        System.out.println("Doctor not found.");
        return false;
    }

    public boolean deleteDoctor(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equals(code)) {
                System.out.println("Doctor Information:");
                System.out.println("Code: " + doctor.getCode());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialization: " + doctor.getSpecialization());
                System.out.println("Availability: " + doctor.getAvailability());

                System.out.print("Do you want to delete this doctor? (Y/N): ");
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("Y")) {
                    doctorList.remove(doctor);
                    System.out.println("Doctor deleted successfully!");
                    return true;
                } else {
                    System.out.println("Delete operation canceled.");
                    return false;
                }
            }
        }
        System.out.println("Doctor not found.");
        return false;
    }

    public List<Doctor> searchDoctor(String code) {
        List<Doctor> searchResults = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equals(code)) {
                searchResults.add(doctor);
            }
        }
        return searchResults;
    }
}
