class Animal{
	String name;
	public void setName(String name) {
		this.name = name;
	}
}

public class Main {
	public static void main(String[] args) {

		Animal cat = new Animal();
		cat.setName("Tori");
		System.out.println(cat.name);
		
		Animal dog = new Animal();
		dog.name = "Bori";
//		dog.setName("Bori");
		System.out.println(dog.name);
		
	}

}
