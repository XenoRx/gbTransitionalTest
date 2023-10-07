package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal {
	private String name;
	private String type;
	private List<String> commands;
	
	public Animal() {
	
	}
	public List<String> getCommands() {
		if (commands == null) {
			commands = new ArrayList<>();
		}
		return commands;
	}
	public void addCommand(String command) {
		if (commands == null) {
			commands = new ArrayList<>();
		}
		if (! commands.contains(command)) {
			commands.add(command);
		}
	}
	
	public Animal(String name, String type, List<String> commands) {
		this.name = name;
		this.type = type;
		this.commands = commands;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCommands(List<String> commands) {
		this.commands = commands;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
