import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ContactServiceTest {
// each of these tests test exactly what the name would indicate
	@Test
	void testingAddID() {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331","Seattle, WA");
		Assertions.assertNotNull(contactService.getContactList().get(0).getContactID());
		Assertions.assertEquals(1, contactService.getContactList().size());
		
	}

	@Test
	void testingAddMultipleIDs() {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331","Seattle, WA");
		contactService.addContact("Lauren", "Smith","8001231234", "Pennsylvania, PA");
		Assertions.assertNotNull(contactService.getContactList().get(0).getContactID());
		Assertions.assertNotNull(contactService.getContactList().get(1).getContactID());
		Assertions.assertEquals(2, contactService.getContactList().size());
	}
	
	@Test
	void testAddContactDuplicateID() throws Exception{
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("0000000001", "Blat", "Bloop", "0001113333", "Blee");
		contactService.addContact(testContact);
		Contact testContact2 = new Contact("0000000001", "Different", "Stuff", "1112223333", "Here");
		contactService.addContact(testContact2);
		Assertions.assertNotEquals("0000000001", contactService.getContactList().get(1).getContactID());
	}
	
	@Test
	void testAddContactDuplicateContact() throws Exception{
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("0000000001", "Dupe", "Duper", "0001113333", "Dupetest");
		contactService.addContact(testContact);
		Contact testContact2 = new Contact("0000000001", "Dupe", "Duper", "0001113333", "Dupetest");
		contactService.addContact(testContact2);
		Contact testContact3 = new Contact("0000000001", "Dupee", "Duper", "0001113333", "Dupetest");
		contactService.addContact(testContact3);
		Contact testContact4 = new Contact("0000000001", "Dupe", "Duperr", "0001113333", "Dupetest");;
		contactService.addContact(testContact4);
		Contact testContact5 = new Contact("0000000001", "Dupe", "Duper", "0001114444", "Dupetest");;
		contactService.addContact(testContact5);
		Contact testContact6 = new Contact("0000000001", "Dupe", "Duper", "0001113333", "Dupetestt");;
		contactService.addContact(testContact6);
		Assertions.assertNotEquals(6, contactService.getContactList().size());
		Assertions.assertEquals(5, contactService.getContactList().size());
		Assertions.assertNotEquals(4, contactService.getContactList().size());
		Assertions.assertNotEquals(3, contactService.getContactList().size());
		Assertions.assertNotEquals(2, contactService.getContactList().size());
	}
	
	@Test
	void testingDeleteID() throws Exception {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331","Seattle, WA");
		contactService.deleteContact(contactService.getContactList().get(0).getContactID());
		Assertions.assertEquals(0, contactService.getContactList().size());
		
	}
	
	@Test
	void testingUpdateFirstName() throws Exception {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331", "Seattle, WA");
		contactService.updateFirstName(contactService.getContactList().get(0).getContactID(), "Bobby");
		Assertions.assertEquals("Bobby", contactService.getContactList().get(0).getFirstName());
	}
	
	@Test
	void testingUpdateLastName() throws Exception {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331", "Seattle, WA");
		contactService.updateLastName(contactService.getContactList().get(0).getContactID(), "Magee");
		Assertions.assertEquals("Magee", contactService.getContactList().get(0).getLastName());
	}
	
	@Test
	void testingUpdatePhoneNumber() throws Exception {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331", "Seattle, WA");
		contactService.updatePhoneNumber(contactService.getContactList().get(0).getContactID(), "0008675309");
		Assertions.assertEquals("0008675309", contactService.getContactList().get(0).getPhoneNumber());
	}
	
	@Test
	void testingUpdateAddressField() throws Exception {
		ContactService contactService = new ContactService();
		
		contactService.addContact("Jeff", "Besos", "8882804331","Seattle, WA");
		contactService.updateAddressField(contactService.getContactList().get(0).getContactID(), "Florida, USA");
		Assertions.assertEquals("Florida, USA", contactService.getContactList().get(0).getAddressField());
	}
}
