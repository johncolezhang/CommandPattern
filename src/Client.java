
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FBSettingWindow fbsw = new FBSettingWindow("setting");
		FunctionButton fb1, fb2;
		fb1 = new FunctionButton("1");
		fb2 = new FunctionButton("2");
		Command c1, c2;
		c1 = (Command)XMLUtil.getBean(0);
		c2 = (Command)XMLUtil.getBean(1);
		fb1.setCommand(c1);
		fb2.setCommand(c2);
		fbsw.addFunctionButton(fb1);
		fbsw.addFunctionButton(fb2);
		fbsw.display();
		fb1.onClick();
		fb2.onClick();
	}

}
