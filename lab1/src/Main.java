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

        System.out.println("Имя после отклонённого изменения: " + client.getFirstName());
        Client clientFromString = new Client(
                "2;Петров;Пётр;;+79997654321;Россия;Казань;ул. Баумана, д. 1"
        );
        System.out.println("Клиент из строки: " + clientFromString.getLastName()
                + " " + clientFromString.getFirstName());
        System.out.println("Телефон: " + clientFromString.getPhone());

        try {
            new Client("ошибка;Петров;Пётр;;+79997654321;Россия;Казань;ул. Баумана, д. 1");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка чтения строки: " + e.getMessage());
        }

        System.out.println("\nПолная версия клиента:");
        System.out.println(client);

        System.out.println("\nКраткая версия клиента:");
        System.out.println(client.toShortString());

        System.out.println("\nКлиент без отчества:");
        System.out.println(clientFromString);
        System.out.println(clientFromString.toShortString());

        Client sameClient = new Client(
                "1;Иванов;Андрей;Иванович;+79991234567;Россия;Москва;ул. Пушкина, д. 10, кв. 5"
        );

        System.out.println("\nСравнение ссылок через ==: " + (client == sameClient));
        System.out.println("Сравнение данных через equals: " + client.equals(sameClient));
        System.out.println("Сравнение с другим клиентом: " + client.equals(clientFromString));

        sameClient.setPhone("+79990000000");
        System.out.println("Равенство после изменения телефона: " + client.equals(sameClient));
    }
}
