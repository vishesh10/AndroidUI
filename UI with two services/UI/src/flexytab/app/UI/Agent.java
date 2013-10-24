package flexytab.app.UI;

public class Agent{
    
    //private variables
    int _id;
    String _time;
    String activity;
    String camp_id;
    int agent_id;
    String unique_id;
    int flag;
    
    // Empty constructor
    public Agent(){
         
    }
    // constructor
   /* public Agent(int id, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }*/
     
    // constructor
    public Agent(String activity, int agent_id){
        this.activity = activity;
        this.agent_id= agent_id;
    }
   
    public Agent(int agent_id){
      //  this.activity = activity;
        this.agent_id= agent_id;
    }
 
    // getting flag value
    public int getFlag(){
        return this.flag;
    }
    // setting flag value
    public void setFlag(){
        this.flag= 1;
    }
    
    
    
    // getting campaign id
    public String getCampId(){
        return this.camp_id;
    }
 
    // setting campaign id
    public void setCampId(String camp_id){
        this.camp_id= camp_id;
    }
    
    // getting activity
    public String getActivity(){
        return this.activity;
    }
     
    // setting activity
    public void setActivity(String activity){
        this.activity= activity;
    }
     
    // getting agent id
    public int getAgentId(){
        return this.agent_id;
    }
     
    // setting agent id
    public void setAgentId(int agent_id){
        this.agent_id= agent_id;
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