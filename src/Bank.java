/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class Bank {
    public static void main(String[] args) {
        System.out.println("Hi! Welcome to the Bank :)");
        System.out.println("Currently, we only have one type of Bank supported, you are about to entering the Fancy Bank");
        FancyBank fancyBank = new FancyBank();
        fancyBank.start();
    }
}
