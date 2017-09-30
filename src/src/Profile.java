import java.util.LinkedList;

public class Profile 
{
	String name;
	int age;
	String gender;
	Profile F,M;
	String SF,SM;
	Profile P;
	LinkedList<Profile> child = new LinkedList<>();
	LinkedList<Profile> SB = new LinkedList<>();
	
	
	public Profile(){};
	
	public Profile(String name, String gender, int age,String SF, String SM, Profile F, Profile M, LinkedList<Profile> SB, LinkedList<Profile> child, Profile P)
	{
		this.name = name;
		this.age = age;
		this.F = F;
		this.M = M;
		this.SM = SM;
		this.SF = SF;
		this.gender = gender;
		this.SB = SB;
		this.child = child;
		this.P = P;
	}	
	

	public Profile getP() {
		return P;
	}

	public void setP(Profile p) {
		P = p;
	}

	public LinkedList<Profile> getChild() {
		return child;
	}

	public void setChild(LinkedList<Profile> child) {
		this.child = child;
	}

	public LinkedList<Profile> getSB() {
		return SB;
	}

	public void setSB(LinkedList<Profile> sB) {
		SB = sB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSF() {
		return SF;
	}

	public void setSF(String sF) {
		SF = sF;
	}

	public String getSM() {
		return SM;
	}

	public void setSM(String sM) {
		SM = sM;
	}

	public LinkedList<Profile> getB() {
		return SB;
	}

	public void setB(LinkedList<Profile> SB) {
		this.SB = SB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Profile getF() {
		return F;
	}

	public void setF(Profile f) {
		F = f;
	}

	public Profile getM() {
		return M;
	}

	public void setM(Profile m) {
		M = m;
	}
	
	
}
