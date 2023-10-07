package Animals;

import java.util.ArrayList;
import java.util.List;

public class ZooNursery {
	public List<Animal> animals = new ArrayList<>();
	// Создаем животное
	Animal animal = null;
	public void addAnimal(String type, String name) {
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
		}
		
		// Присваиваем животному кличку
		animal.setName(name);
		animal.setType(type);
		// Добавляем животное в список
		animals.add(animal);
	}
	public List<Animal> getAnimals() {
		return animals;
	}
}
