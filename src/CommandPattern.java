import java.util.ArrayList;

public class CommandPattern {}

abstract class Command{
	public abstract void execute();
}

class FBSettingWindow{
	private String title;
	private ArrayList <FunctionButton> functionButtons= new ArrayList<FunctionButton>();

	public FBSettingWindow(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addFunctionButton(FunctionButton fb){
		functionButtons.add(fb);
	}
	
	public void removeFunctionButton(FunctionButton fb){
		functionButtons.remove(fb);
	}
	
	public void display(){
		System.out.println("show windows:" + this.title);
		System.out.println("show function button:");
		for(Object obj : functionButtons){
			System.out.println(((FunctionButton)obj).getName());
		}
		System.out.println("-------------------------------------");
	}
}

class FunctionButton{
	private String name;
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}

	public FunctionButton(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void onClick(){
		System.out.println("click function button");
		command.execute();
	}
}

class WindowHandler{
	public void minimize(){
		System.out.println("minimize the windows");
	}
}

class HelpHandler{
	public void display(){
		System.out.println("show helping doc");
	}
}

class HelpCommand extends Command{
	private HelpHandler hhObj;
	
	public HelpCommand() {
		hhObj = new HelpHandler();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		hhObj.display();
	}
}

class MinimizeCommand extends Command{
	private WindowHandler whObj;
	public MinimizeCommand() {
		// TODO Auto-generated constructor stub
		whObj = new WindowHandler();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		whObj.minimize();
	}
}