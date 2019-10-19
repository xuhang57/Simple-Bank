/**
 * @author Hang Xu
 * @date Fall 2019
 */
public abstract class AbstractPerson {
    private Name name;
    private boolean isManager;
    private long phoneNumber;

    /**
     * Setup a new Person with person's Name
     * @param name: Name
     * @param phoneNumber: long
     */
    public AbstractPerson(Name name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setup a new Person with person's Name and Role
     * @param name: Name
     * @param phoneNumber: long
     * @param isManager: boolean
     */
    public AbstractPerson(Name name, long phoneNumber, boolean isManager) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isManager = isManager;
    }

    /**
     * Return the Name of this Person
     * @return name: Name
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Return whether this person is a Manager
     * @return isManager: boolean
     */
    public boolean isManager() {
        return this.isManager;
    }

    /**
     * Return the phone number of this Person
     * @return phoneNumber: long
     */
    public long getPhoneNumber() {
        return this.phoneNumber;
    }
}
