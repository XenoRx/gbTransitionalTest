package Menu;

import Animals.*;
import SaveFile.Save;
import SaveFile.Load;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner scanner;
	Save save = new Save();
	Load load = new Load();
	ZooNursery zooNursery = new ZooNursery();
	
	private Animal findAnimalByName(String name) {
		for (Animal animal : zooNursery.animals) {
			if (animal.getName().equals(name)) {
				return animal;
			}
		}
		return null;
	}
	
	public Menu() {
		scanner = new Scanner(System.in);
	}
	
	public void showMenu() throws IOException {
		boolean run = true;
		
		while (run) {
			System.out.println("Меню");
			System.out.println("1 - Добавить новое животное");
			System.out.println("2 - Показать список животных");
			System.out.println("3 - Тренировать животное");
			System.out.println("4 - Список комманд животного");
			System.out.println("5 - Сохранить список животных в файл");
			System.out.println("6 - Загрузить список животных из файла");
			System.out.println("7 - Выйти из программы");
			System.out.println("Выберите пункт меню: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
				case 1://добавление животного в список
					System.out.println("Принимаем следующие виды: собака,кошка,верблюд,хомяк,лошадь,осёл\nВведите вид животного: ");
					String type = scanner.next();
					
					Animal animal = null;
					if (type.equalsIgnoreCase("собака")) {
						animal = new Dog();
					} else if (type.equalsIgnoreCase("кошка")) {
						animal = new Cat();
					} else if (type.equalsIgnoreCase("верблюд")) {
						animal = new Camel();
					} else if (type.equalsIgnoreCase("хомяк")) {
						animal = new Hamster();
					} else if (type.equalsIgnoreCase("лошадь")) {
						animal = new Horse();
					} else if (type.equalsIgnoreCase("осёл")) {
						animal = new Donkey();
					} else {
						System.out.println("Этот вид животных не пока еще не принимаем!");
					}
					if (animal != null) {
						System.out.println("Введите кличку животного");
						String name = scanner.next();
						animal.setName(name);
						zooNursery.addAnimal(type, name);
					} else {
						System.out.println("Такого животного нет!");
					}
					break;
				case 2://вывод списка
					if (zooNursery.animals.size() == 0) {
						System.out.println("Список пуст");
					} else {
						for (Animal a : zooNursery.animals) {
							System.out.println(a.getName() + " - " + a.getType());
						}
					}
					break;
				case 3:
					// Обучение команде
					System.out.println("Введите кличку обучаемого животного");
					String name = scanner.next();
					
					// Находим животное по кличке
					animal = findAnimalByName(name);
					
					// Если животное не найдено, то выводим сообщение об ошибке
					if (animal == null) {
						System.out.println("Животное с такой кличкой не найдено");
						break;
					}
					// Вводим команду
					System.out.print("Введите команду: ");
					String command = scanner.next();
					
					// Если команда существует, то выводим сообщение об ошибке
					if (animal.getCommands().contains(command)) {
						System.out.println("Команда уже существует");
						break;
					}
					
					// Если у животного нет команд, то выводим сообщение об ошибке
//					if (animal.getCommands() == null) {
//						System.out.println("Животное не обучено никаким командам");
//						break;
//					}
					// Если у животного нет команд, то выводим сообщение об ошибке
					if (animal.getCommands() == null) {
						animal.setCommands(new ArrayList<>());
					}
					
					// Добавляем команду в список животного
					animal.addCommand(command);
					break;
				
				case 4://список команд животного
					System.out.print("Введите кличку: ");
					name = scanner.next();
					
					animal = findAnimalByName(name);
					if (animal != null) {
						System.out.println(animal.getCommands());
					} else {
						System.out.println("Животное с данными навыками не найдено");
					}
					break;
				case 5:
					// Запись в файл
					System.out.println("Сохранить список животных в файл");
					save.save();
					break;
				
				case 6:
					// Загрузка из файла
					System.out.println("Загрузить список животных из файла");
					load.load();
					break;
				case 7:
					run = false;
					break;
				default:
					System.out.println("Такого пункта в меню нет!");
			}
		}
		scanner.close();
	}
	
	
}
