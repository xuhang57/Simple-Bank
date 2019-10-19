/**
 * @author Hang Xu
 */
public class Bank {
    public static void main(String[] args) {
        System.out.println("Hi! Welcome to Hang Xu's Bank :)");
        System.out.println("Currently, we only have one type of Bank supported, you are about to entering it");
        FancyBank fancyBank = new FancyBank();
        fancyBank.start();
    }
}
