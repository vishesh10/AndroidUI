package flexytab.app.UI;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
 


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DatabaseHelper extends SQLiteOpenHelper {
 
    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "flexytab";
 
    // Table Names
    private static final String TABLE_AGENT = "agent";
    private static final String TABLE_CDETAIL = "cdetail";
    private static final String TABLE_CONTACT = "contact";

    // column names common to agent table and cdetail table
   
    private static final String KEY_CAMP_ID = "campaign_id";
    private static final String KEY_AGENT_ID= "agent_id";
    
    // column names common to contact table and cdetail table
    private static final String KEY_FIRST_NAME= "first_name";
    private static final String KEY_LAST_NAME= "last_name";
    private static final String KEY_PHONE_NO = "phone_number";
    
    // agent table column names
    
    private static final String KEY_ACTIVITY = "activity";
    private static final String KEY_TIME= "time";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_UNIQUE_ID= "unique_id";
    
    
    // cdetail table column names
    private static final String KEY_SNO= "Sno";
    private static final String KEY_CALL_START_TIME = "call_start_time";
    private static final String KEY_CALL_DURATION= "call_duration";
    private static final String KEY_DISPOSITION= "disposition";
    
 // contact table column names
    private static final String KEY_ALT_NO= "alt_no";
    private static final String KEY_AGE= "age";
    private static final String KEY_DIALED= "dialed";
    
    
 // Table Create Statements
    
    // agent table create statement
    private static final String CREATE_TABLE_AGENT = "CREATE TABLE "
            + TABLE_AGENT + "(" + KEY_UNIQUE_ID + " TEXT , " + KEY_CAMP_ID 
            + " TEXT , " + KEY_AGENT_ID + " TEXT NOT NULL , " + KEY_TIME
            + " DATETIME , " + KEY_ACTIVITY + " TEXT NOT NULL , " + KEY_FLAG + " INTEGER DEFAULT 0 " 
            + " ,PRIMARY KEY" + "(" + KEY_ACTIVITY + "," + KEY_AGENT_ID + ")" + ")";
    
    // cdetail table create statement
    private static final String CREATE_TABLE_CDETAIL = "CREATE TABLE "
            + TABLE_CDETAIL + "(" + KEY_SNO + " INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_CAMP_ID 
            + " TEXT , " + KEY_AGENT_ID + " TEXT  , " + KEY_PHONE_NO 
            + " TEXT NOT NULL , " + KEY_FIRST_NAME + " TEXT , " + KEY_LAST_NAME + " TEXT DEFAULT NULL, " 
            + KEY_CALL_START_TIME  + " DATETIME , " + KEY_CALL_DURATION + " DATETIME , " 
            + KEY_DISPOSITION + " TEXT NOT NULL , " + KEY_FLAG + " INTEGER DEFAULT 0 " + ")";
    
 // contact table create statement
    private static final String CREATE_TABLE_CONTACT  = "CREATE TABLE "
            + TABLE_CONTACT + "(" + KEY_SNO + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
    		+ KEY_PHONE_NO + " TEXT NOT NULL , " + KEY_FIRST_NAME + " TEXT , " + KEY_LAST_NAME 
    		+ " TEXT , " + KEY_ALT_NO + " TEXT , " + KEY_AGE + " TEXT, " + KEY_DIALED + " TEXT DEFAULT N " + ")";

    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_AGENT);
        db.execSQL(CREATE_TABLE_CDETAIL);
        db.execSQL(CREATE_TABLE_CONTACT);
    }
 
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AGENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CDETAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
 
        // create new tables
        onCreate(db);

    }
    
 // ------------------------ "agent" table methods ----------------//
    
    /**
     * Creating a agent entry for login
     */
    public void createActivity(Agent agent) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
    //    values.put(KEY_TIME, agent.getTime());
        values.put(KEY_ACTIVITY, agent.getActivity());
      //  values.put(KEY_CAMP_ID, agent.getCampId());
        values.put(KEY_AGENT_ID, agent.getAgentId());
     //   values.put(KEY_UNIQUE_ID, agent.getUniqueId());
        
        
// insert row
        db.insert(TABLE_AGENT, null, values);
 
        db.close();
    }

 

    
    
    
    
    /**
     * Get all the rows with flag=0
     */
    public List<Agent> getAgentDetail() {
        List<Agent> contactList = new ArrayList<Agent>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AGENT + " WHERE "
                + KEY_FLAG + " = 0" ;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Agent agentd = new Agent();
                agentd.setActivity(cursor.getString(cursor.getColumnIndex(KEY_ACTIVITY)));
                agentd.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_AGENT_ID))));
                //agentd.setUniqueId(cursor.getString(cursor.getColumnIndex(KEY_UNIQUE_ID)));
                //agentd.setCampId(cursor.getString(cursor.getColumnIndex(KEY_CAMP_ID)));
                //agentd.setTime(cursor.getString(cursor.getColumnIndex(KEY_TIME)));
                //agentd.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_FLAG))));
                
                //Adding contact to list
                contactList.add(agentd);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
    
    
        
 /*   // Updating single contact
    public void updateFlag(int agent_id) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_FLAG, agent1.getFlag());
        													// unique and activity
 
        // updating row
     // db.update(TABLE_AGENT, values, KEY_AGENT_ID + " = ?",
      //   );
   //  String strSQL = "UPDATE agent SET flag = 1 WHERE agent_id =  "+ agent_id;

     //   db.execSQL(strSQL , null);
        
    }
    
 */   
      
    
    
    
    	// Deleting rows with flag = "1"			1 indicates that json msg sent successfully
    
    public void deleteAgentRow(Integer agent_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        String strQuery = "delete from agent where agent_id= "
                + agent_id;
        
        Log.w("strQuery", strQuery);
        db.execSQL(strQuery);
       
        
        //db.delete(TABLE_AGENT, KEY_FLAG + " = ?",
          //      flag,null);
        
        
        db.close();
    }
    
    
    
 // ------------------------ "cdetail" table methods ----------------//
    
    /**    
     * Creating a entry for call detail
     */
    public void createCall(Cdetail cdetail) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();

        values.put(KEY_DISPOSITION, cdetail.getDisposition());
      //  values.put(KEY_CAMP_ID, cdetail.getCampId());
       //values.put(KEY_AGENT_ID, cdetail.getAgentId());
        values.put(KEY_PHONE_NO, cdetail.getPhone());
        values.put(KEY_FIRST_NAME, cdetail.getFirstName());
//        values.put(KEY_LAST_NAME, cdetail.getLastName());
     //   values.put(KEY_CALL_START_TIME, cdetail.getCallStartTime());
     //   values.put(KEY_CALL_DURATION, cdetail.getCallDuration());
     //   values.put(KEY_UNIQUE_ID, cdetail.getUniqueId());
        
        
// insert row
        db.insert(TABLE_CDETAIL, null, values);
 
        db.close();
    }
    
    
    /**
     * Get single the rows with flag=0
     */
    public List<Cdetail> getSingleCallDetail() {
        List<Cdetail> callList = new ArrayList<Cdetail>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CDETAIL; /*+ " WHERE "
                + KEY_FLAG + " = 0" ; */
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            //do {
        	 Cdetail calld = new Cdetail();
                calld.setDisposition(cursor.getString(cursor.getColumnIndex(KEY_DISPOSITION)));
                calld.setAgentId((cursor.getString(cursor.getColumnIndex(KEY_AGENT_ID))));
                //calld.setUniqueId(cursor.getString(cursor.getColumnIndex(KEY_UNIQUE_ID)));
                //calld.setCampId(cursor.getString(cursor.getColumnIndex(KEY_CAMP_ID)));
                //calld.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_FLAG))));
                calld.setPhone((cursor.getString(cursor.getColumnIndex(KEY_PHONE_NO))));
                calld.setFirstName(cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)));
                calld.setLastName(cursor.getString(cursor.getColumnIndex(KEY_LAST_NAME)));
                //calld.setCallStartTime(cursor.getString(cursor.getColumnIndex(KEY_CALL_START_TIME)));
                
                
                
                
                //Adding contact to list
                callList.add(calld);
            //} while (cursor.moveToNext());
        }
 db.close();
        // return contact list
        return callList;
    }

    /**
     * Get all the rows with flag=0
     */
    public List<Cdetail> getCallDetail() {
        List<Cdetail> callList = new ArrayList<Cdetail>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CDETAIL; /*+ " WHERE "
                + KEY_FLAG + " = 0" ; */
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cdetail calld = new Cdetail();
                calld.setDisposition(cursor.getString(cursor.getColumnIndex(KEY_DISPOSITION)));
                calld.setAgentId((cursor.getString(cursor.getColumnIndex(KEY_AGENT_ID))));
                //calld.setUniqueId(cursor.getString(cursor.getColumnIndex(KEY_UNIQUE_ID)));
                //calld.setCampId(cursor.getString(cursor.getColumnIndex(KEY_CAMP_ID)));
                //calld.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_FLAG))));
                calld.setPhone((cursor.getString(cursor.getColumnIndex(KEY_PHONE_NO))));
                calld.setFirstName(cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)));
                calld.setLastName(cursor.getString(cursor.getColumnIndex(KEY_LAST_NAME)));
                //calld.setCallStartTime(cursor.getString(cursor.getColumnIndex(KEY_CALL_START_TIME)));
                
                
                
                
                //Adding contact to list
                callList.add(calld);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return callList;
    }
    
    
    
	// Deleting rows with flag = "1"			1 indicates that json msg sent successfully

    public void deleteCdetailRow(Integer phone_no) {
    SQLiteDatabase db = this.getWritableDatabase();
    
    String strQuery = "delete from cdetail where phone_number= "
            + phone_no;
    
    Log.w("strQuery", strQuery);
    db.execSQL(strQuery);
   
    
    //db.delete(TABLE_AGENT, KEY_FLAG + " = ?",
      //      flag,null);
    
    
    db.close();
}
    
    
 // ------------------------ "Contact" table methods ----------------//
    
    /**    
     * Creating a entry for call detail
     */
    public void createContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
      
        values.put(KEY_PHONE_NO, contact.getPhone());
        values.put(KEY_FIRST_NAME, contact.getFirstName());
        values.put(KEY_LAST_NAME, contact.getLastName());     
        values.put(KEY_AGE, contact.getAge());
        values.put(KEY_ALT_NO, contact.getAltNo());
        
        
// insert row
        db.insert(TABLE_CONTACT, null, values);
 
        db.close();
    }
    
    /**
     * Get single row with dialed = N
     */
    public List<Contact> getSingleContactDetail() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACT + " WHERE "
                + KEY_DIALED + " = 'N'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            //do {
        	{  Contact contact = new Contact();
             //   contact.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_FLAG))));
                contact.setPhone((cursor.getString(cursor.getColumnIndex(KEY_PHONE_NO))));
                contact.setFirstName(cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)));
                //contact.setLastName(cursor.getString(cursor.getColumnIndex(KEY_LAST_NAME)));
                contact.setAge((cursor.getInt(cursor.getColumnIndex(KEY_AGE))));
                contact.setSno((cursor.getInt(cursor.getColumnIndex(KEY_SNO))));
                
                
                
                //Adding contact to list
                contactList.add(contact);
            }// while (cursor.moveToNext());
        }
 db.close();
        // return contact list
        return contactList;
    }
    
    
    
    
    
    /**
     * Get all the rows with flag=0
     */
    public List<Contact> getContactDetail() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACT + " WHERE "
                + KEY_DIALED + " = 'N'";
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
        	  Contact contact = new Contact();
             //   contact.setAgentId((cursor.getInt(cursor.getColumnIndex(KEY_FLAG))));
                contact.setPhone((cursor.getString(cursor.getColumnIndex(KEY_PHONE_NO))));
                contact.setFirstName(cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME)));
                //contact.setLastName(cursor.getString(cursor.getColumnIndex(KEY_LAST_NAME)));
                contact.setAge((cursor.getInt(cursor.getColumnIndex(KEY_AGE))));
                
                
                
                
                //Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
    
    // Updating single contact
    public void update(int s_no) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        //ContentValues values = new ContentValues();
        //values.put(KEY_FLAG, agent1.getFlag());
        													// unique and activity
 
        // updating row
     // db.update(TABLE_AGENT, values, KEY_AGENT_ID + " = ?",
      //   );
    String strSQL = "UPDATE contact SET dialed = 'Y' WHERE Sno =  " + s_no;

        db.execSQL(strSQL);
     
        db.close(); 
    }

    
	// Deleting rows with flag = "1"			1 indicates that json msg sent successfully

    public void deleteContactRow(Integer phone_no) {
    SQLiteDatabase db = this.getWritableDatabase();
    
    String strQuery = "delete from contact where phone_number= "
            + phone_no;
    
    Log.w("strQuery", strQuery);
    db.execSQL(strQuery);
   
    
    //db.delete(TABLE_AGENT, KEY_FLAG + " = ?",
      //      flag,null);
    
    
    db.close();
}
    
    
    
}
    

