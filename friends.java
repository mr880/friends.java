package friends;

public class Person {
	String name;		// the person's name
	Friend firstFriend; // the first friend in the list of this
					    // person's friends
	Person nextPerson;  // the next person in the list of people
	
	public Person(String name, Person nextPerson) {
		this.name = name;
		this.nextPerson = nextPerson;
		}

	// A string representing the list of friends of this person.  
	 // O(number of friends in the list)
	public String friendString(){
		Friend ptr;
		String names="";
		for (ptr =firstFriend; ptr!=null ; ptr = ptr.nextFriend){
			names += ptr.who.name+" ";
		}
		
		return names;
	
	}
	
	// add friend as a friend of this person
	// O(1)
	public void addFriend(Person friend){
	Friend ptr= firstFriend;
		if (firstFriend == null){
		firstFriend = new Friend(friend, null);
	
		}else {
			firstFriend =new Friend (friend, firstFriend);
			
			
		}
		
	}
	
	// remove Person friend as a friend of this person
	// if friend is not a friend of this person, does nothing
	// O(number of friends of this person)
	public void removeFriend(Person friend){
		Friend ptr = firstFriend;
		Friend prev=ptr;
		while (ptr != null && ptr.who != friend) {
		   prev = ptr;
		   ptr = ptr.nextFriend;
		}
		if (ptr == null) {
		   return;
		} else if (ptr == firstFriend) {
		   firstFriend =ptr.nextFriend;
		   return;
		}
	firstFriend=	prev.nextFriend = ptr.nextFriend;
		return;	
	}
		
	
		
	
}







package friends;

// represents a list of people as a linked list of Person objects
public class PersonList {
	Person firstPerson;		// First Person object in the list

	public PersonList( ) {
		this.firstPerson = null;
	}
	
	// finds Person object in this list with given name
	// if none exists, returns null.  Runs in O(number of persons in this list) 
	public Person lookup(String name){
		Person ptr = firstPerson;
		for (ptr=firstPerson;ptr!=null; ptr=ptr.nextPerson){
			if (ptr.name == name){
				return ptr;
			}
		}
		return null; // replace this line
	
	}
	
	// creates a new Person object with name and adds it to the list of 
	// Person objects.  Runs in O(1)
	public Person addPerson(String name){
		firstPerson = new Person(name, firstPerson);
		
		return firstPerson; // replace this line
		}

}








package friends;

public class Friend {
	Friend nextFriend;	// next Friend object
	Person who;			// Person object who is the friend
	
	Friend(Person who, Friend nextFriend) {
		this.who = who;
		this.nextFriend = nextFriend;
	}
}