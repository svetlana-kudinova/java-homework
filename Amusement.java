public class Amusement {
    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Attraction Name: " + name);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Price: " + price + "$");
        }
    }
}