package flexytab.app.UI;


public class Cdetail{
    
    //private variables
    String phone_no;
    String _time;
    String dispo;
    String camp_id;
    String unique_id;
    String agent_id;
    String f_name;
    String l_name;
    int flag;
    String call_duration;
    String call_start_time;
    
    
    // Empty constructor
    public Cdetail(){
         
    }
     
    // constructor
    /*public Cdetail( int agent_id){
        
        this.agent_id= agent_id;
    }*/
   
    public Cdetail(String dispo , String phone_no , String f_name){
      this.dispo = dispo;
        this.phone_no= phone_no;
        this.f_name=f_name;
    }
    
    public Cdetail(String dispo , String phone_no , String f_name , String l_name){
        this.dispo = dispo;
          this.phone_no= phone_no;
          this.f_name=f_name;
          this.l_name=l_name;
      }
    
    // getting agent id
    public String getAgentId(){
        return this.agent_id;
    }
     
    // setting agent id
    public void setAgentId(String agent_id){
        this.agent_id= agent_id;
    }
    
 
    // getting campaign id
    public String getCampId(){
        return this.camp_id;
    }
 
    // setting campaign id
    public void setCampId(String camp_id){
        this.camp_id= camp_id;
    }
    
    
    // getting phone number
    public String getPhone(){
        return this.phone_no;
    }
    // setting phone number
    public void setPhone(String phone_no){
        this.phone_no= phone_no;
    }
    
    // getting disposition
    public String getDisposition(){
        return this.dispo;
    }
    // setting disposition
    public void setDisposition(String dispo){
        this.dispo= dispo;
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
    public void setLastName(String l_name){
        this.l_name= l_name;
    }
    
    // getting call duration
    public String getCallDuration(){
        return this.call_duration;
    }
    // setting call duration
    public void setCallDuration(String call_duration){
        this.call_duration= call_duration;
    }
    
 // getting call start time
    public String getCallStartTime(){
        return this.call_start_time;
    }
    // setting call start time
    public void setCallStartTime(String call_start_time){
        this.call_start_time= call_start_time;
    }
    
 // getting unique id
    public String getUniqueId(){
        return this.unique_id;
    }
     
    // setting unique id
    public void setUniqueId(String unique_id){
        this.unique_id= unique_id;
    }
    
/*  
    
    
    
  
    
    // getting activity
    public String getActivity(){
        return this.activity;
    }
     
    // setting activity
    public void setActivity(String activity){
        this.activity= activity;
    }
     
   
    
    
  */  
    
}
