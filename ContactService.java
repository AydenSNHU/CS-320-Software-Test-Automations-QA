import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	
	public List<Contact> contactList = new ArrayList<>();
	
	private String generateContactID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	} 
	
	private Contact contactSearch(String contactID) throws Exception {
		int i = 0;
		while (i < contactList.size()) {
			if (contactID.equals(contactList.get(i).getContactID()))
				return contactList.get(i);
			i++;
		}
		throw new Exception("The contact you are looking for does not exist");
		
	}
	
	public void addContact(String firstName, String lastName, String phoneNumber, String addressField) {
		Contact contactToBeAdded = new Contact(generateContactID(), firstName, lastName, phoneNumber, addressField);
		contactList.add(contactToBeAdded);
	}
	
	public String duplicateIDCheck(Contact contact) {
		int i = 0;
		String duplicate = "duplicate";
		String nonDuplicate = "nonDuplicate";
		String alreadyFound = "alreadyFound";
		while (i < contactList.size()) {
			if (contact.getContactID().equals(contactList.get(i).getContactID())) {
				if (contact.getFirstName().equals(contactList.get(i).getFirstName()) && contact.getLastName().equals(contactList.get(i).getLastName()) && contact.getPhoneNumber().equals(contactList.get(i).getPhoneNumber()) && contact.getAddressField().equals(contactList.get(i).getAddressField())){
					return alreadyFound;
				}
				return duplicate;
			}
				
			i++;
		}
		return nonDuplicate;
	}
	
	public void addContact(Contact contact) throws Exception {
		if (duplicateIDCheck(contact) == "duplicate") {
			Contact newContact = new Contact(generateContactID(), contact.firstName, contact.lastName, contact.phoneNumber, contact.addressField);
			contactList.add(newContact);
			System.out.println("This contact ID is already used. Assigned new id: " + newContact.contactID);
		}
		else if (duplicateIDCheck(contact) == "alreadyFound") {
			System.out.println("This contact already exists");
		}
		else {
			contactList.add(contact);
		}	
	}
	
	
	public void deleteContact(String contactID) throws Exception {
		contactList.remove(contactSearch(contactID));
	}
	
	public void updateFirstName(String taskID, String firstName) throws Exception {
		if(firstName == null || firstName.length() > 10) 
			   throw new IllegalArgumentException("Invalid first name: Length over 10 or NULL");
		// these if statements are here to make sure you don't update it out of range
		contactSearch(taskID).setFirstName(firstName);
	}
	 
	public void updateLastName(String taskID, String lastName) throws Exception {
		if(lastName == null || lastName.length() > 10) 
			   throw new IllegalArgumentException("Invalid last name: Length over 10 or NULL");
		// these if statements are here to make sure you don't update it out of range
		contactSearch(taskID).setLastName(lastName);
	}
	
	public void updatePhoneNumber(String taskID, String phoneNumber) throws Exception {
		if(phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10)
			   throw new IllegalArgumentException("Invalid phone number: Length is not exactly 10 or is NULL");
		// these if statements are here to make sure you don't update it out of range
		contactSearch(taskID).setPhoneNumber(phoneNumber);
	}
	
	public void updateAddressField(String taskID, String addressField) throws Exception {
		if(addressField == null || addressField.length() > 30)
			   throw new IllegalArgumentException("Invalid address: Length over 30 or NULL");
		// these if statements are here to make sure you don't update it out of range
		contactSearch(taskID).setAddressField(addressField);
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}
		 
}