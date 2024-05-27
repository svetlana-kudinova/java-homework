public class Staff {
    private String Name;
    private String title;
    private String email;
    private String phone;
    private double pay;
    private int age;

    public Staff(String Name, String title, String email, String phone, double pay, int age) {
        this.Name = Name;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(Name);
        System.out.println(title);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(pay);
        System.out.println(age);
    }
}
