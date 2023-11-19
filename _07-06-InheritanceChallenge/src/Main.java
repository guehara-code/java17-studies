public class Main {
    public static void main(String[] args) {
        Employee tim = new Employee("Tim", "11/11/1985", "01/01/2020");
        System.out.println(tim);
        System.out.println("Age: " + tim.getAge());
        System.out.println("Pay: " + tim.collectPay());

        SalariedEmployee john = new SalariedEmployee("John", "11/11/1990", "03/03/2020",
                35000);
        System.out.println(john);
        System.out.println("Age: " + john.getAge());
        System.out.println("Joe's Paycheck = $ " + john.collectPay());
    }
}
