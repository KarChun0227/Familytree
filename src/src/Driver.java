import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Profile> people = new ArrayList<Profile>();
	
	File Filetree = new File("tree.xml");
	XMLSerliaizer XMLS = new XMLSerliaizer(Filetree);
	
	public void loadFile() 
	  {
		File usersFile = new File("../Family/src/large-database.txt");    
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = " ";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);

		        if (userTokens.length == 5)
		        {
		        	String name = userTokens[0];
		        	int age = Integer.parseInt(userTokens[2]);
		        	String gender = userTokens[1];
		        	String SF = userTokens[3];
		        	String SM = userTokens[4];
		        	Profile profile = new Profile(name, gender, age, SF, SM, null, null, null, null, null);
		        	people.add(profile);
		        }
			}
			
	      } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	  }
	
	public void buildFamily()
	{
		for(int i = 0; i < people.size(); i++)
		{
			for(int j = 0; j < people.size(); i++)
			{
				if(people.get(i).SF.equals(people.get(j).name));
				{
					people.get(i).setF(people.get(j));
					//people.get(j).child.add(people.get(i));
				}
				if( people.get(i).SM == people.get(j).name)
				{
					people.get(i).setM(people.get(j));
					people.get(j).child.add(people.get(i));
				}
			}
		}
		for(int j = 0; j < people.size(); j++)
		{
			for(int i = 0; i < people.size(); i++)
			{
				if(people.get(j).M.name.equals(people.get(i).M.name) && people.get(j).F.name.equals(people.get(i).F.name))
				{
					people.get(j).SB.add(people.get(i));
				}
			}
		}
		for(int k = 0; k < people.size(); k++)
		{
			for(int j = 0; j < people.size(); j++)
			{
				if(people.get(k).child.equals(people.get(j).child))
				{
					people.get(k).setP(people.get(j));
				}
			}
		}
	}
	
	
	public void addPerson(String name, String gender, int age, String SM, String SF)
	{
		Profile profile = new Profile(name, gender, age, SF, SM, null, null, null, null, null);
		people.add(profile);
		Profile newProfile = people.get(people.size());
		for(int i = 0; i < people.size(); i++)
		{
			if(people.get(i).name.equals(newProfile.SF))
			{
				newProfile.setF(people.get(i));
				people.get(i).child.add(newProfile);
			}
			if(people.get(i).name.equals(newProfile.SM))
			{
				newProfile.setM(people.get(i));
				people.get(i).child.add(newProfile);
			}
		}
		for(int i = 0; i < people.size(); i++)
		{
			if(people.get(i).M.name.equals(newProfile.M.name) && people.get(i).F.name.equals(newProfile.F.name))
			{
				newProfile.SB.add(people.get(i));
			}
			if(people.get(i).child.equals(newProfile.child))
			{
				newProfile.setP(people.get(i));
			}
		}
	}
	
	public String delPerson(String name)
	{
		for(int i = 0; i < people.size(); i++)
		{
			if(!people.get(i).name.equals(name))continue;
				people.remove(i);
				return ("User had remove");
		}
		return ("No existing user");
	}
	
	public String updateProfile(String name)
	{
		Profile profile = null;
		for(int i = 0; i < people.size(); i ++)
		{
			if(!people.get(i).name.equals(name))continue;
			profile = people.get(i);
			break;
		}
		if(profile == null)
		{
			return ("No such as profile exist");
		}
		updateCase(profile);
		return ("Profile Changed");
	}
	
	public void updateCase(Profile profile)
	{
		System.out.println("choose Option");
		int option = menu();
		while(option != 0)
		{
			Profile chooseProfile = null;
			switch(option)
			{
			case 1:
				System.out.println("What's the new Name");
				String newName = sc.nextLine();
				profile.setName(newName);
				break;
			case 2:
				System.out.println("Partner's Name");
				String partnerName = sc.nextLine();
				for(int i = 0; i < people.size(); i++)
				{
					if(!people.get(i).name.equals(partnerName))continue;
					chooseProfile = people.get(i);
					break;
				}
				if(chooseProfile != null)
				{
					profile.setP(chooseProfile);
				}
				break;
			case 3:
				System.out.println("Father's Name");
				String fatherName = sc.nextLine();
				for(int i = 0; i < people.size(); i++)
				{
					if(!people.get(i).name.equals(fatherName))continue;
					chooseProfile = people.get(i);
					break;
				}
				if(chooseProfile != null)
				{
					profile.setF(chooseProfile);
				}
				break;
			case 4:
				System.out.println("Mother's Name");
				String motherName = sc.nextLine();
				for(int i = 0; i < people.size(); i++)
				{
					if(!people.get(i).name.equals(motherName))continue;
					chooseProfile = people.get(i);
					break;
				}
				if(chooseProfile != null)
				{
					profile.setF(chooseProfile);
				}
				break;
			case 5:
				System.out.println("Enter new Age");
				int newAge = sc.nextInt();
				profile.setAge(newAge);
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
	}
	
	public int menu()
	{
		System.out.println("1) Update Name");
    	System.out.println("2) Update Partner");
    	System.out.println("3) Update Father");
    	System.out.println("4) Update Mother");
    	System.out.println("5) Update Age");
    	System.out.println("6) Update Sli");
    	System.out.println("7) Update Chilren");
		int option = sc.nextInt();
		return option;
	}
	
	public int size()
	{
		return people.size();
	}
	
	public void display()
	{
		String profileName = sc.nextLine();
		Profile selectProfile = null;
		for(int i = 0; i < people.size(); i++)
		{
			if(!people.get(i).name.equals(profileName))continue;
			selectProfile = people.get(i);
			break;
		}
		if(selectProfile != null)
		{
			System.out.println("Name: " + selectProfile.name + "/nAge: " + selectProfile.age 
					+ "/nFather: " + selectProfile.F.name + "/nMother: " + selectProfile.M.name
					+ "/nChild: " + selectProfile.child);
		}
		
	}
	
	public void write() throws Exception 
	{
		XMLS.push(people);
		XMLS.write();
	}
	
	public void load() throws Exception 
	{
		XMLS.read();
		people = (ArrayList<Profile>)	XMLS.pop();
	}
}