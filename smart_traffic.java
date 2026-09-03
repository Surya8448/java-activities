import java.util.Scanner;

public class smart_traffic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int SPEED_FINE = 1000;
        final int HELMET_FINE = 500;
        final int SEATBELT_FINE = 500;
        final int LICENSE_FINE = 1000;
        final int UNDERAGE_FINE = 1500;

        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = sc.nextLine();

        System.out.print("Enter Vehicle Speed: ");
        int vehicleSpeed = sc.nextInt();

        System.out.print("Enter Speed Limit: ");
        int speedLimit = sc.nextInt();

        System.out.print("Enter Driver Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Helmet Status (VALID/VIOLATION): ");
        String helmetStatus = sc.nextLine();

        System.out.print("Enter Seat Belt Status (VALID/VIOLATION): ");
        String seatbeltStatus = sc.nextLine();

        System.out.print("Enter License Status (VALID/INVALID): ");
        String drivingLicenseStatus = sc.nextLine();

        System.out.print("Is this an Emergency Vehicle? (YES/NO): ");
        String emergencyVehicleStatus = sc.nextLine();

        int totalFine = 0;
        int violationFlags = 0;

        int excessSpeed = vehicleSpeed - speedLimit;

        boolean speedViolation = vehicleSpeed > speedLimit;

        if (speedViolation) {
            totalFine += SPEED_FINE;
            violationFlags++;
        }


        boolean ageViolation = age < 18;

        if (ageViolation) {
            totalFine += UNDERAGE_FINE;
            violationFlags++;
        }

        boolean helmetViolation =
                helmetStatus.equalsIgnoreCase("VIOLATION");

        if (helmetViolation) {
            totalFine += HELMET_FINE;
            violationFlags++;
        }

        boolean seatbeltViolation =
                seatbeltStatus.equalsIgnoreCase("VIOLATION");

        boolean actualSeatbeltViolation =
                seatbeltViolation &&
                !emergencyVehicleStatus.equalsIgnoreCase("YES");

        if (actualSeatbeltViolation) {
            totalFine += SEATBELT_FINE;
            violationFlags++;
        }

        boolean licenseViolation =
                drivingLicenseStatus.equalsIgnoreCase("INVALID");

        if (licenseViolation) {
            totalFine += LICENSE_FINE;
            violationFlags++;
        }

        String riskLevel;

        if (violationFlags >= 3) {
            riskLevel = "HIGH";
        }
        else if (violationFlags == 2) {
            riskLevel = "MEDIUM";
        }
        else if (violationFlags == 1) {
            riskLevel = "LOW";
        }
        else {
            riskLevel = "SAFE";
        }

        System.out.println();
        System.out.println("=============================================");
        System.out.println("           SMART TRAFFIC ANALYZER");
        System.out.println("=============================================");

        System.out.println();
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Speed          : " + vehicleSpeed + " km/h");
        System.out.println("Speed Limit    : " + speedLimit + " km/h");

        if (excessSpeed > 0) {
            System.out.println("Excess Speed   : " + excessSpeed + " km/h");
        }
        else {
            System.out.println("Excess Speed   : 0 km/h");
        }

        System.out.println();

        if (speedViolation) {
            System.out.println("Speed Status   : OVER SPEED");
        }
        else {
            System.out.println("Speed Status   : WITHIN LIMIT");
        }

        System.out.println("Helmet Status  : " + helmetStatus);

        if (actualSeatbeltViolation) {
            System.out.println("Seat Belt Status : VIOLATION");
        }
        else {
            System.out.println("Seat Belt Status : VALID");
        }

        System.out.println("License Status : " + drivingLicenseStatus);

        System.out.println("Driver Age     : " + age);

        System.out.println("Emergency Vehicle : "
                           + emergencyVehicleStatus);

        System.out.println();

        System.out.println("Total Fine     : " + totalFine);
        System.out.println("Risk Level     : " + riskLevel);
        System.out.println("Violation Flags: " + violationFlags);

        System.out.println();
        System.out.println("=============================================");

        sc.close();
    }
}