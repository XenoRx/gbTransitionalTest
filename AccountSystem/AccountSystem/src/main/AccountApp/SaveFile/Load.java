package SaveFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Load {
	public void load() throws IOException {
		// Создаем объект FileReader для чтения из файла
		FileReader reader = new FileReader("AnimalList.txt");
		
		// Создаем объект Scanner для чтения из FileReader
		Scanner scanner = new Scanner(reader);
	}
}
