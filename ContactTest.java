import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	@Test
	void testContact() {
		Contact contactTest = new Contact("0123456789", "Jeff", "Besos", "8882804331","Seattle, WA");
		assertTrue(contactTest.getContactID().equals("0123456789"));
		assertTrue(contactTest.getFirstName().equals("Jeff"));
		assertTrue(contactTest.getLastName().equals("Besos"));
		assertTrue(contactTest.getPhoneNumber().equals("8882804331"));
		assertTrue(contactTest.getAddressField().equals("Seattle, WA"));
	}
	// testing normal creation of contact and all of the following tests the corresponding
	// values indicated in their names, like too long, too short, and null
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("01234567891","Jeff", "Besos", "8882804331","Seattle, WA");
	});		}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact(null,"Jeff", "Besos", "8882804331","Seattle, WA");
	});		}
		
	
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeffabcdefg", "Besos", "8882804331","Seattle, WA");
	});		}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", null, "Besos", "8882804331","Seattle, WA");
	});		}
	
	
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besosabcdef", "8882804331","Seattle, WA");
	});		}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", null, "8882804331","Seattle, WA");
	});		}
	
	
	
	@Test
	void testPhoneNumberAboveTen() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besos", "88828043310","Seattle, WA");
	});		}
	
	@Test
	void testPhoneNumberBelowTen() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besos", "888280433","Seattle, WA");
	});		}
	
	@Test
	void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besos", null,"Seattle, WA");
	});		}
	
	
	
	@Test
	void testAddressFieldTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besos", "8882804331","Seattle, WAabcdefghijklmnopqrst");
	});		}
	
	@Test
	void testAddressFieldNull() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			new Contact("0123456789", "Jeff", "Besos", "8882804331", null);
	});		}
}
