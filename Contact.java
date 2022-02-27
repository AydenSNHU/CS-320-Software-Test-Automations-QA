public class Contact {
   
   public String contactID; // not longer than 10 and not null
   public String firstName; // not longer than 10 and not null
   public String lastName; // not longer than 10 and not null
   public String phoneNumber; // EXACTLY 10 and not null
   public String addressField; // not longer than 30 and not null
// variables above, constructor below
   
   public Contact(String contactID, String firstName, String lastName, String phoneNumber, String addressField) {
	   // checking to see if it fits the criteria or not with each of these
	   if(contactID == null || contactID.length() > 10)
		   throw new IllegalArgumentException("Invalid contact ID: Length over 10 or NULL");
		   
	   if(firstName == null || firstName.length() > 10) 
		   throw new IllegalArgumentException("Invalid first name: Length over 10 or NULL");
		   
	   if(lastName == null || lastName.length() > 10) 
		   throw new IllegalArgumentException("Invalid last name: Length over 10 or NULL");
		   
	   if(phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10)
		   throw new IllegalArgumentException("Invalid phone number: Length is not exactly 10 or is NULL");
		   
	   if(addressField == null || addressField.length() > 30)
		   throw new IllegalArgumentException("Invalid address: Length over 30 or NULL");
	   // if everything fits criteria, below will resolve
	   
       this.contactID = contactID;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.addressField = addressField;
   }

   // accessors and mutators below
   public String getContactID() {
       return contactID;
   }
// above ContactID is not allowed to be changed later, hence no mutator
   public String getFirstName() {
       return firstName;
   }

   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   public String getLastName() {
       return lastName;
   }

   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   public String getPhoneNumber() {
       return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
   }
   
   public String getAddressField() {
       return addressField;
   }

   public void setAddressField(String addressField) {
       this.addressField = addressField;
   }

}

