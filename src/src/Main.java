import java.util.Scanner;

public class Main 
{
	static Driver driver = new Driver();
	static Scanner sc = new Scanner(System.in);
	static Main M = new Main();
	
	public static void main(String args[]) throws Exception
	{
		driver.loadFile();
		System.out.println(driver.size());
		//driver.loadFile();
		//driver.buildFamily();
		//driver.load();
		M.run();	
	}
	
	public void run()
	{
		System.out.println("Choose Option");
    	int option = mainMenu();
    	while(option != 0)
    	{
    		switch(option)
    		{
    		case 1:
    			driver.display();
    			break;
    		case 2:
    			M.add();
    			break;
    		case 3:
    			String name2 = sc.nextLine();
    			driver.updateProfile(name2);
    			break;
    		case 4:
    			String name = sc.nextLine();
    			driver.delPerson(name);
    			break;
    		case 5:
    			try 
    			{
					driver.write();
				} 
    			catch (Exception e) 
    			{
					e.printStackTrace();
				}
    			break;
    		}
    	}
	}
	
	private int mainMenu()
    {
    	System.out.println("1) Choose people");
    	System.out.println("2) Add People");
    	System.out.println("3) Update People");
    	System.out.println("4) Delete People");
    	System.out.println("5) Save");
    	int option = sc.nextInt();
    	return option;
    }
	
	public void add()
	{
		System.out.println("Name: ");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("Gender: ");
		String gender = sc.nextLine();
		sc.nextLine();
		System.out.println("Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Mother's Name: ");
		String SM = sc.nextLine();
		sc.nextLine();
		System.out.println("Father's Name: ");
		String SF = sc.nextLine();
		driver.addPerson(name, gender, age, SM, SF);
	}
}
