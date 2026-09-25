public class Client {
    private long clientId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String country;
    private String city;
    private String address;

    public Client(
            long clientId,
            String lastName,
            String firstName,
            String middleName,
            String phone,
            String country,
            String city,
            String address
    ) {
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
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Фамилия обязательна.");
        }
        if (lastName.codePointCount(0, lastName.length()) > 100) {
            throw new IllegalArgumentException("Фамилия не должна превышать 100 символов.");
        }
        if (!lastName.matches("\\p{L}[\\p{L}\\p{M}]*(?:[ '\\-’]\\p{L}[\\p{L}\\p{M}]*)*")) {
            throw new IllegalArgumentException("Фамилия может содержать буквы, пробелы, дефисы и апострофы между частями.");
        }
    }

    public static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Имя обязательно.");
        }
        if (firstName.codePointCount(0, firstName.length()) > 100) {
            throw new IllegalArgumentException("Имя не должно превышать 100 символов.");
        }
        if (!firstName.matches("\\p{L}[\\p{L}\\p{M}]*(?:[ '\\-’]\\p{L}[\\p{L}\\p{M}]*)*")) {
            throw new IllegalArgumentException("Имя может содержать буквы, пробелы, дефисы и апострофы между частями.");
        }
    }

    public static void validateMiddleName(String middleName) {
        if (middleName == null) {
            return;
        }
        if (middleName.isBlank()) {
            throw new IllegalArgumentException("Для отсутствующего отчества передайте null, а не пустую строку.");
        }
        if (middleName.codePointCount(0, middleName.length()) > 100) {
            throw new IllegalArgumentException("Отчество не должно превышать 100 символов.");
        }
        if (!middleName.matches("\\p{L}[\\p{L}\\p{M}]*(?:[ '\\-’]\\p{L}[\\p{L}\\p{M}]*)*")) {
            throw new IllegalArgumentException("Отчество может содержать буквы, пробелы, дефисы и апострофы между частями.");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\+[1-9][0-9]{6,14}")) {
            throw new IllegalArgumentException("Телефон должен начинаться с + и содержать от 7 до 15 цифр, первая цифра — от 1 до 9.");
        }
    }

    public static void validateCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Страна обязательна.");
        }
        if (country.codePointCount(0, country.length()) > 100) {
            throw new IllegalArgumentException("Страна не должна превышать 100 символов.");
        }
    }

    public static void validateCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Населённый пункт обязателен.");
        }
        if (city.codePointCount(0, city.length()) > 100) {
            throw new IllegalArgumentException("Название населённого пункта не должно превышать 100 символов.");
        }
    }

    public static void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Адрес обязателен.");
        }
        if (address.codePointCount(0, address.length()) > 250) {
            throw new IllegalArgumentException("Адрес не должен превышать 250 символов.");
        }
    }

}
