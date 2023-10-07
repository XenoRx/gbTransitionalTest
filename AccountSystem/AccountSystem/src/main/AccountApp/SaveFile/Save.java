package SaveFile;

import Animals.Animal;
import Animals.ZooNursery;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	ZooNursery zooNursery = new ZooNursery();
	
	public void save() throws IOException {
		// Создаем объект FileWriter для записи в файл
		File file = new File("AnimalList.txt");
		if (! file.exists()) {
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		for (Animal animal : zooNursery.animals) {
			writer.write(animal.getName() + " " + animal.getType() + " " + animal.getCommands() + "\n");
		}
		
		// Закрываем FileWriter
		writer.close();
	}
}
