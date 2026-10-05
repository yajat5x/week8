class OrderProcessing extends Thread {

    public OrderProcessing() {
        super("OrderProcessing");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Processing customer order"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

class DeliveryTracking extends Thread {

    public DeliveryTracking() {
        super("DeliveryTracking");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Tracking delivery location"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

class Notification extends Thread {

    public Notification() {
        super("Notification");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Sending order-status notification"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class FoodDeliveryMultithreading {

    public static void main(String[] args) {

        OrderProcessing orderProcessing = new OrderProcessing();
        DeliveryTracking deliveryTracking = new DeliveryTracking();
        Notification notification = new Notification();

        // Assign different priorities
        orderProcessing.setPriority(Thread.MAX_PRIORITY);     // 10
        deliveryTracking.setPriority(Thread.NORM_PRIORITY);   // 5
        notification.setPriority(Thread.MIN_PRIORITY);       // 1

        System.out.println("===== ONLINE FOOD DELIVERY SYSTEM =====");

        System.out.println(
            orderProcessing.getName() +
            " - Priority: " +
            orderProcessing.getPriority()
        );

        System.out.println(
            deliveryTracking.getName() +
            " - Priority: " +
            deliveryTracking.getPriority()
        );

        System.out.println(
            notification.getName() +
            " - Priority: " +
            notification.getPriority()
        );

        System.out.println("\n===== THREAD EXECUTION =====");

        // Start all threads
        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}