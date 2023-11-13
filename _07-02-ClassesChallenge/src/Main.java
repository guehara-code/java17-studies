public class Main {
    public static void main(String[] args) {
        Account bobsAccount = new Account("12345", 1000.00,  "Bob Brown", "mymail@bob.com", "(087) 123-4567");
//        bobsAccount.setNumber("12345");
//        bobsAccount.setCustomerEmail("Bob Brown");
//        bobsAccount.setCustomerEmail("mymail@bob.com");
//        bobsAccount.setGetCustomerPhone("(087) 123-4567");

        bobsAccount.withdrawFunds(100.0);
        bobsAccount.depositFunds(250);
        bobsAccount.withdrawFunds(50);

        bobsAccount.withdrawFunds(200);
        bobsAccount.depositFunds(100);
        bobsAccount.withdrawFunds(45.55);
        bobsAccount.withdrawFunds(54.46);

    }
}
