public class Main {
    public static void main(String[] args) {

        Staff[] persArray = new Staff[5];
        persArray[0] = new Staff("Иванов Иван", "Инженер", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Staff("Петров Петр", "Инженер", "petr@mailbox.com", "811111111", 40000, 31);
        persArray[2] = new Staff("Сидоров Сидор", "Инженер", "sidor@mailbox.com", "822222222", 50000, 32);
        persArray[3] = new Staff("Кузнецов Кузнец", "Инженер", "kuznets@mailbox.com", "833333333", 60000, 33);
        persArray[4] = new Staff("Смирнов Смирн", "Инженер", "smirn@mailbox.com", "844444444", 70000, 34);

        for (Staff employee : persArray) {
            employee.printInfo();
            System.out.println();
        }

        Amusement park = new Amusement();
        Amusement.Attraction[] attractions = new Amusement.Attraction[3];
        attractions[0] = park.new Attraction("Ромашка", "10:00 - 20:00", 1);
        attractions[1] = park.new Attraction("Машики", "10:00 - 20:00", 2);
        attractions[2] = park.new Attraction("Самолетик", "10:00 - 20:00", 3);

        for (Amusement.Attraction attraction : attractions) {
            attraction.printInfo();
            System.out.println();
        }
    }
}
