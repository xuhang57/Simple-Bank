/**
 * @author Hang Xu
 */
public class Name {
    private String firstName;
    private String lastName;

    /**
     * Setup only first name
     *
     * @param first : String
     */
    public Name(String first) {
        this.firstName = first;
        this.lastName = null;
    }

    /**
     * Setup both first and last name
     *
     * @param first : String
     * @param last : String
     */
    public Name(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Get only First Name
     *
     * @return firstName : String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get only Last Name
     *
     * @return lastName : String
     */
    public String getLastName() {
        return this.lastName;
    }
}
