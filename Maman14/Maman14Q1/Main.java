import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int LIST_SIZE = 6;
		LinkList<String> stringList = new LinkList<String>();
		Scanner scan = new Scanner(System.in);
		Node<String> node;
		System.out.println("Please enter 6 strings sperated by Enter");
		for(int i = 0; i < LIST_SIZE; i++) {
			node = new Node<String>(scan.nextLine());
			stringList.add(node);
		}
		System.out.println(stringList);
		String stringArr[] = new String[LIST_SIZE];
		node = stringList.getHead();
		for(int i = 0; i < LIST_SIZE; i++) {
			stringArr[i] = node.getContent();
			node = node.getNextNode();
		}
		node = stringList.getHead();
		for(int i = LIST_SIZE-1 ; i >= 0 ; i--) {
			node.setContent(stringArr[i]);
			node = node.getNextNode();
		}
		System.out.println(stringList);



		LinkList<Person> personList = new LinkList<Person>();
		Person person1 = new Person(205804925, 1994);
		Person person2 = new Person(309997948, 1995);
		Person person3 = new Person(223032048, 1991);
		Person person4 = new Person(339664442, 2000);
		personList.add(new Node<Person>(person1));
		personList.add(new Node<Person>(person2));
		personList.add(new Node<Person>(person3));
		personList.add(new Node<Person>(person4));

		System.out.println("Ther 4 persons are:");
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(person4);
		System.out.println("Oldest person is: \n" + Max.max(personList));


	}	

}
