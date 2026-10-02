public class ClientMapper {
    public static ClientShort toShort(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Клиент не должен быть null.");
        }

        String initials = getInitial(client.getFirstName());
        if (client.getMiddleName() != null) {
            initials += " " + getInitial(client.getMiddleName());
        }

        return new ClientShort(client.getLastName(), initials, client.getPhone());
    }

    private static String getInitial(String name) {
        // Находим конец первой буквы с учётом Unicode.
        int end = name.offsetByCodePoints(0, 1);
        return name.substring(0, end) + ".";
    }
}
