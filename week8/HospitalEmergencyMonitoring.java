class EmergencyAlert extends Thread {

    public EmergencyAlert() {
        super("EmergencyAlert");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Critical patient alert"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

class VitalMonitor extends Thread {

    public VitalMonitor() {
        super("VitalMonitor");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Checking vital signs"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

class ReportGenerator extends Thread {

    public ReportGenerator() {
        super("ReportGenerator");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Preparing routine report"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class HospitalEmergencyMonitoring {

    public static void main(String[] args) {

        EmergencyAlert emergencyAlert = new EmergencyAlert();
        VitalMonitor vitalMonitor = new VitalMonitor();
        ReportGenerator reportGenerator = new ReportGenerator();

        // Set thread priorities
        emergencyAlert.setPriority(Thread.MAX_PRIORITY);  // 10
        vitalMonitor.setPriority(Thread.NORM_PRIORITY);    // 5
        reportGenerator.setPriority(Thread.MIN_PRIORITY);  // 1

        // Display thread names and priorities
        System.out.println("===== HOSPITAL EMERGENCY MONITORING SYSTEM =====");

        System.out.println(
            emergencyAlert.getName() +
            " - Priority: " +
            emergencyAlert.getPriority()
        );

        System.out.println(
            vitalMonitor.getName() +
            " - Priority: " +
            vitalMonitor.getPriority()
        );

        System.out.println(
            reportGenerator.getName() +
            " - Priority: " +
            reportGenerator.getPriority()
        );

        System.out.println("\n===== THREAD EXECUTION =====");

        // Start all threads
        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}