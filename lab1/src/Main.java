import java.util.ArrayList;
import java.util.List;

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

        ClientShort shortClient = ClientMapper.toShort(client);
        System.out.println("\nОбъект ClientShort через маппер:");
        System.out.println(shortClient);

        ClientShort shortClientWithoutMiddleName = ClientMapper.toShort(clientFromString);
        System.out.println("\nОбъект ClientShort без отчества через маппер:");
        System.out.println(shortClientWithoutMiddleName);

        System.out.println("\nСоздание нескольких клиентов:");
        String[] clientData = {
                "3;Сидоров;Сергей;Сергеевич;+7 999 1111111;Россия;Москва;ул. Лесная, д. 1",
                "4;Смирнов;Алексей;Иванович;7 (999)-222-22-22;Россия;Омск;ул. Мира, д. 2",
                "5;Кузнецова;Анна;;+79фыв93333333;Россия;Казань;ул. Баумана, д. 3",
                "7;Орлов;Дмитрий;Андреевич;+79995555555;Россия;Тула;ул. Советская, д. 5"
        };

        List<Client> clients = new ArrayList<>();
        int skippedClients = 0;

        for (int i = 0; i < clientData.length; i++) {
            try {
                Client newClient = new Client(clientData[i]);
                clients.add(newClient);
            } catch (IllegalArgumentException e) {
                skippedClients++;
                System.out.println("Запись №" + (i + 1) + " пропущена: " + e.getMessage());
            }
        }

        System.out.println("Успешно создано: " + clients.size());
        System.out.println("Пропущено: " + skippedClients);

        System.out.println("\nСозданные клиенты:");
        for (Client createdClient : clients) {
            System.out.println(ClientMapper.toShort(createdClient));
        }
    }
}