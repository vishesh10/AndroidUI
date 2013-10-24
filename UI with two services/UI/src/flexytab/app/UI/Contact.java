package flexytab.app.UI;


public class Contact{
    
    //private variables
    
    String _time;
    int age;
    String phone_no;
    String unique_id;
    int alt_no;
    String f_name;
    String l_name;
    int flag;
    String dialed;
    int s_no;
    // Empty constructor
    public Contact(){
         
    }
     
    // constructor
    /*public Contact( int agent_id){
        
        this.agent_id= agent_id;
    }*/
   
    public Contact(String phone_no, String f_name, String l_name , int age){
        this.phone_no= phone_no;
        this.f_name= f_name;
        this.l_name= l_name;
        this.age= age;
    }
    
    public Contact(String phone_no, String f_name , int age){
        this.phone_no= phone_no;
        this.f_name= f_name;
        this.age= age;
    }
    
    public Contact(int alt_no){
        this.alt_no= alt_no;
    }

    public Contact(String dialed){
        this.dialed= dialed;
    }
    
    
    
    // getting customer's age
    public int getAge(){
        return this.age;
    }
     
    // setting customer's age
    public void setAge(int age){
        this.age= age;
    }
    
    
    // getting Serial number
    public int getSno(){
        return this.s_no;
    }
 //setting serial number
    public void setSno(int s_no){
        this.s_no= s_no;
    }
    
    
    // getting phone number
    public String getPhone(){
        return this.phone_no;
    }
    // setting phone number
    public void setPhone(String phone_no){
        this.phone_no= phone_no;
    }
    
 // getting alternate number
    public int getAltNo(){
        return this.alt_no;
    }
    // setting alternate number
    public void setAltNo(int alt_no){
        this.alt_no= alt_no;
    }
    
 // getting First name of customer
    public String getFirstName(){
        return this.f_name;
    }
    // setting first name of customer
    public void setFirstName(String f_name){
        this.f_name= f_name;
    }

    // getting Last name of customer
    public String getLastName(){
        return this.l_name;
    }
    // setting Last  name of customer
    public void setLastName(String dispo){
        this.l_name= l_name;
    }
    
     
 // getting unique id
    public String getUniqueId(){
        return this.unique_id;
    }
     
    // setting unique id
    public void setUniqueId(String unique_id){
        this.unique_id= unique_id;
    }
    
    
}