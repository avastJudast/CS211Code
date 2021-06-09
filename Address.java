public class Address{
    public String streetNumber;
    public String unitNumber;
    public String state;
    public int zipCode;
    public String email;
    public Address(String streetNumber, String unitNumber, String state, int zipCode, String email){
        this.streetNumber = streetNumber;
        this.unitNumber = unitNumber;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;   
    }
    public String getStreetNumber(){
        return streetNumber;
    }
    public String getUnitNumber(){
        return unitNumber;
    }
    public String getState(){
        return state;
    }
    public int getZipCode(){
        return zipCode;
    }
    public String getEmail(){
        return email;
    }
    public void setStreetNumber(String streetNumber){ //- sets the streetNumber.
        this.streetNumber = streetNumber;
    }
    public void setUnitNumber(String unitNumber){ //- sets the unitNumber.
        this.unitNumber = unitNumber;
    }
    public void setState(String state){ //- sets the state.
        this.state = state;
    }
    public void setZipCode(int zipCode){ //- sets the zipCode.
        this.zipCode = zipCode;
    }
    public void setEmail(String email){ //- sets the email. 
        this.email = email;
    }
    public String toString(){
        return "Street Number: " +streetNumber+"; Unit Number: +"+unitNumber+"; State: "+state+"; ZipCode: "+zipCode+"; Email: "+email;
    }
}