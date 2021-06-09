public class CovidPatient{
    public String firstName;
    public String lastName;
    public String id;
    public Address address;
    public int admittedPatients;
    public CovidPatient(){
        firstName = "";
        lastName = "";
        id = "";
        address = new Address("","","",0,"");
        admittedPatients = 0;
    }
    public CovidPatient(String firstName, String lastName, String id, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        admittedPatients++;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getId(){
        return id;
    }
    public Address getAddress(){
        return address;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public int getAdmittedPatient(){
        return admittedPatients;
    }
    public static void reset(){
        admittedPatients = 0;
    }
    public static int getAdmittedPatients(){
        return admittedPatients;
    }
}