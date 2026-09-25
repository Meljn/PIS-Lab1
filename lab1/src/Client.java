public class Client {

    private static final String name_pattern = "\\p{L}[\\p{L}\\p{M}]*([ '\\-’]\\p{L}[\\p{L}\\p{M}]*)*";

    private long clientId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String country;
    private String city;
    private String address;

    public Client(long clientId, String lastName, String firstName, String middleName,
                  String phone, String country, String city, String address) {
        validateClientId(clientId);
        validateLastName(lastName);
        validateFirstName(firstName);
        validateMiddleName(middleName);
        validatePhone(phone);
        validateCountry(country);
        validateCity(city);
        validateAddress(address);

        this.clientId = clientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public long getClientId() {
        return clientId;
    }
    public void setClientId(long clientId) {
        validateClientId(clientId);
        this.clientId = clientId;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        validateMiddleName(middleName);
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        validateCountry(country);
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        validateCity(city);
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    public static void validateClientId(long clientId) {
        if (clientId < 0) {
            throw new IllegalArgumentException("Идентификатор клиента должен быть положительным.");
        }
    }

    public static void validateLastName(String lastName) {
        validateName(lastName, "Фамилия");
    }

    public static void validateFirstName(String firstName) {
        validateName(firstName, "Имя");
    }

    public static void validateMiddleName(String middleName) {
        if (middleName != null) {
            validateName(middleName, "Отчество");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\+[1-9][0-9]{6,14}")) {
            throw new IllegalArgumentException("Телефон должен начинаться с + и содержать от 7 до 15 цифр. Первая цифра не должна быть нулём.");
        }
    }

    public static void validateCountry(String country) {
        validateText(country, "Страна", 100);
    }

    public static void validateCity(String city) {
        validateText(city, "Город", 100);
    }

    public static void validateAddress(String address) {
        validateText(address, "Адрес", 250);
    }

    private static void validateText(String value, String fieldName, int maxLength) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Поле \"" + fieldName + "\" не заполнено.");
        }

        if (value.codePointCount(0, value.length()) > maxLength) {
            throw new IllegalArgumentException("Поле \"" + fieldName
                    + "\" не должно быть длиннее " + maxLength + " символов.");
        }
    }

    private static void validateName(String value, String fieldName) {
        validateText(value, fieldName, 100);

        if (!value.matches(name_pattern)) {
            throw new IllegalArgumentException("В поле \"" + fieldName
                    + "\" допустимы буквы, а между частями — пробел, дефис или апостроф.");
        }
    }
}

