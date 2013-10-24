package flexytab.app.UI;


	import java.util.Date;


	import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

	public class SendService extends Service {
	    private static final String TAG = "SendService";
	  //  public static final String BROADCAST_ACTION = "com.websmithing.broadcasttest.displayevent";
	    //private final Handler handler = new Handler();
	    
	    DatabaseHelper db = new DatabaseHelper(this);
	    
	    Intent intent;
	    
	    @Override
	    public void onCreate() {
	        super.onCreate();
	  
	    }   
	    
	   /* @Override
	    public void onStart(Intent intent, int startId) {
	        /*handler.removeCallbacks(sendUpdatesToUI);
	        handler.postDelayed(sendUpdatesToUI, 1000); // 1 second
	   */
	        //DisplayLoggingInfo();
	        
	        
	    //}   
	    public int onStartCommand(Intent intent , int flag , int startid)
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
	    
	    private void DisplayLoggingInfo( Intent intent) {
	        Log.d(TAG, "entered DisplayLoggingInfo");

	        
	        String phone = intent.getStringExtra("phone");
	        String name = intent.getStringExtra("name");
	        String dispo = intent.getStringExtra("dispo");
	        String s_no = intent.getStringExtra("s_no");
	         
	    /*	Log.d(" Receiving: ", " Receiving values ..");
	    	Log.d(" Phone Received : ", phone);
	    	Log.d(" name Received : ", name);
	    	Log.d(" dispo Received : " , dispo);
	    	*/
	    	db.update(Integer.parseInt(s_no));
	    	 db.createCall(new Cdetail( dispo , phone , name)); 
	    	 
	    	
		   /*
	        * for getting the number of sim
	        * 
	        *  TelephonyManager phoneManager = (TelephonyManager) 
	    		    getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
	    		String phoneNumber = phoneManager.getLine1Number();
	    		Log.d(" Sending Phone number : ", phoneNumber );
	    		intent.putExtra("number" , phoneNumber);
	    */    
	    
	    }

	    @Override
	    public IBinder onBind(Intent intent) {
	        return null;
	    }

	    @Override
	    public void onDestroy() {
	        //handler.removeCallbacks(sendUpdatesToUI);
	        super.onDestroy();
	    }
	}
