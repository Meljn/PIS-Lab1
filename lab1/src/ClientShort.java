public class ClientShort {
    private final String lastName;
    private final String initials;
    private final String phone;

    public ClientShort(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Клиент не должен быть null.");
        }

        this.lastName = client.getLastName();
        this.phone = client.getPhone();

        String shortInitials = getInitial(client.getFirstName());
        if (client.getMiddleName() != null) {
            shortInitials += " " + getInitial(client.getMiddleName());
        }
        this.initials = shortInitials;
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

    private static String getInitial(String name) {
        int end = name.offsetByCodePoints(0, 1);
        return name.substring(0, end) + ".";
    }
}
