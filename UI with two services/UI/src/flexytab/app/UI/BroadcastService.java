package flexytab.app.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BroadcastService  extends Service {
    private static final String TAG = "BroadcastService";
    public static final String BROADCAST_ACTION = "com.websmithing.broadcasttest.displayevent";
    private final Handler handler = new Handler();
    
    DatabaseHelper db = new DatabaseHelper(this);
    
    Intent intent;
    int counter = 0;
    
    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent(BROADCAST_ACTION);  
    }   
    
    @Override
    public void onStart(Intent intent, int startId) {
        /*handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 1000); // 1 second
   */
        DisplayLoggingInfo();
        
        
    }   
    
/*    public int onStartCommand(Intent intent , int flag , int startid)
    {
    	DisplayLoggingInfo(intent);
    	return START_NOT_STICKY; 
    }
/*
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();    
            handler.postDelayed(this, 10000); // 10 seconds
        }   
    };  */    
    private void DisplayLoggingInfo( ) {
        Log.d(TAG, "entered DisplayLoggingInfo");

        
    
        
        //intent.putExtra("time", new Date().toLocaleString());
      //  intent.putExtra("counter", String.valueOf(++counter));
        
    	Log.d(" Inserting: ", " Inserting values ..");
    
    	
	
        
      /* TelephonyManager phoneManager = (TelephonyManager) 
    		    getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
    		String phoneNumber = phoneManager.getLine1Number();
    		Log.d(" Sending Phone number : ", phoneNumber );
    		intent.putExtra("number" , phoneNumber);
        */
    	
    	
    	List<Contact> contact = db.getSingleContactDetail();       
	    //    Cdetail cn = new Cdetail(); 
	        for (Contact cn : contact) {
	            String log = " sno : " + cn.getSno() + " ,PHONE : " + cn.getPhone();
	          
	          // db.deleteCdetailRow(cn.getPhone());
	           
	           // Writing Contacts to log
	        Log.d(" Agent : ", log);
	        /*
    	intent.putExtra("number", cn.getPhone());
    	intent.putExtra("name", cn.getFirstName());
    	intent.putExtra("age", Integer.toString(cn.getAge()));
    	intent.putExtra("s_no", Integer.toString(cn.getSno()));
    	*/
	        
	        }
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /*@Override
    public void onDestroy() {
        //handler.removeCallbacks(sendUpdatesToUI);
        super.onDestroy();
    }*/
}




/*import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import android.util.Log;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BroadcastService extends Service{

 IBinder mBinder = new LocalBinder();
 
 
 DatabaseHelper db = new DatabaseHelper(this);
 
 

 @Override
 public IBinder onBind(Intent intent) {
  return mBinder;
 }

 public class LocalBinder extends Binder {
  public BroadcastService
  getServerInstance() {
   return BroadcastService.this;
  }
 }

 public String getTime() {
  SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  return mDateFormat.format(new Date());
 }
 
public List<Contact> getSingleValue()
{
	// Reading all contacts
	       List<Contact> contact= db.getSingleContactDetail();       
	    	        Log.d(" Agent : ", "getting value");	
return contact;
}


public void create()
{
	Log.d(" Inserting: ", " Inserting values .."); 
	 db.createContact(new Contact( "8447056481" , "Vish" , 22));       
	 db.createContact(new Contact( "9013230111" , "Mdddari" , 22));
	 db.createContact(new Contact( "8130560505" , "Viy" , 42));
}

public void update(int s_no)
{
	db.update(s_no);
}

public void createCall(String dispo , String phone , String f_name)
{
	db.createCall(new Cdetail( "NI" , phone , f_name));     
}


}*/