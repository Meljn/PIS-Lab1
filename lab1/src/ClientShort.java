public class ClientShort {
    private final String lastName;
    private final String initials;
    private final String phone;

    public ClientShort(String lastName, String initials, String phone) {
        this.lastName = lastName;
        this.initials = initials;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return initials;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return lastName + " " + initials + ", " + phone;
    }
}
