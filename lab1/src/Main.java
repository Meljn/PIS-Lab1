public class Main {
    public static void main(String[] args) {
        Client client = new Client(
                1,
                "Иванов",
                "Иван",
                "Иванович",
                "+79991234567",
                "Россия",
                "Москва",
                "ул. Пушкина, д. 10, кв. 5"
        );

        System.out.println("Идентификатор: " + client.getClientId());
        System.out.println("Имя: " + client.getFirstName());

        client.setFirstName("Андрей");
        System.out.println("Новое имя: " + client.getFirstName());

        try {
            new Client(
                    0, "Иванов", "Иван", null, "+79991234567",
                    "Россия", "Москва", "ул. Пушкина, д. 10, кв. 5"
            );
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка создания: " + exception.getMessage());
        }

        try {
            client.setFirstName("");
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка изменения: " + exception.getMessage());
        }


    }
}
