package ua.khpi.oop.Lunhol08;

final class Functions {
	
	private Functions() {
        //default constructor
    }

    static void chooseMenu() {
        System.out.println("\n\nВыберите необходимый вариант:");
        System.out.println("1. Добавить кадидата");
        System.out.println("2. Показать действующих кандидатов");
        System.out.println("3. Удалить кандидата");
        System.out.println("4. Очистить список кандидатов");
        System.out.println("5. Использовать XML");
        System.out.println("6. Работа с файлами");
        System.out.println("0. Завершить работу");
        System.out.print("Выберите: ");
    }

    static void chooseMenuFile() {
        System.out.println("\n\nВыберите необходимый вариант:");
        System.out.println("1. Сохранить файл в текущую директорию");
        System.out.println("2. Просмотреть содержание директории");
        System.out.println("3. Просмотреть дерево к файлу");
        System.out.println("4. Сохранить файл в необходимый путь");
        System.out.println("5. Переименовать файл");
        System.out.println("6. Прочитать файл из памяти");
        System.out.println("0. Завершить работу");
        System.out.print("Выберите: ");
    }
}
