package flexytab.app.UI;



//import flexytab.app.UI.BroadcastService.LocalBinder;



import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.EditTextPreference;
import android.view.View;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;  
import android.widget.Toast;

import java.util.Calendar;
import android.app.Dialog;
import android.widget.RelativeLayout;


import flexytab.app.UI.DateTimePicker;

import android.app.DatePickerDialog;

//import example.drop.Drop.MainActivity.DatePickerFragment;
import android.widget.DatePicker;
import android.util.Log; 
import android.view.Window;
import android.widget.EditText;
import flexytab.app.UI.R;
//import flexytab.app.UI.DateTimePicker.DateWatcher;


import flexytab.app.UI.receive;


import java.util.List;


public class DialingScreen extends FragmentActivity{
	//DialogFragment newFragment = new DatePickerFragment();
	//private TextView tvDisplayDate;
	//private DatePicker dpResult;
	//private Button btnChangeDate;
 
	//private int year;
	//private int month;
	//private int day;
	String campq="CONTACT DETAILS";
	Intent intent;
	
	TextView date;
	
	//int s_no;
	String phone;
	String f_name;
	boolean play_pause_state;    				// true then play otherwise pause
	String test;
	
	String number;
	String name;
	String age1;
	String dispo;
	String s_no;
	String camp_id;
	//Context context = getApplicationContext();
	
	
	static final int DATE_DIALOG_ID = 999;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialingscreen);
        date = (TextView) findViewById(R.id.script);
     
     //   camp_id = intent.getStringExtra("camp_id"); 

      //  Log.d(" campaign id: ", camp_id); 
        
               intent = new Intent(this, BroadcastService.class);
        //intent.putStringArrayListExtra("check" ,  al);
    	 startService(intent);
    	 registerReceiver(broadcastReceiver, new IntentFilter(BroadcastService.BROADCAST_ACTION));
        
        
       /*Log.d(" Inserting: ", " Inserting values .."); 
		 db.createContact(new Contact( "8447056481" , "Vishesh" , 22));       
		 //db.createContact(new Contact( "9013230111" , "Manjari" , 22));
		// db.createContact(new Contact( "8130560505" , "Vinay" , 42));   */
        
        
      //	SetText(cn.getFirstName(), cn.getPhone(), cn.getAge()); 
    
//for listening the current state of call        
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	    tm.listen(mPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

// for dialing 
	    /*	String tel = (String)cn.getPhone();
	    Intent callIntent = new Intent(Intent.ACTION_CALL);
	    //   callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 callIntent.setData(Uri.parse("tel: " + tel));
	    startActivity(callIntent);
	*/   
	    
	    
//	        }
        
}

	
	/*
	 * broadcast receiver for getting data from service
	 */
		
		private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
			
			@Override
	        public void onReceive(Context context, Intent intent) {
	        	//updateUI(intent);  
	        	     

	        }
	    };
		
	/*
	* function that is called in broadcast receiver
	*/
	    
	    public void updateUI(Intent intent) {
	    	String number = intent.getStringExtra("number"); 
	    	String name = intent.getStringExtra("name"); 
	    	String age = intent.getStringExtra("age"); 
	    	String s_no = intent.getStringExtra("s_no" ); 
	    	
	    	 
	    Log.d( " Received number  " , number);
	    	Log.d( " Received name  " , name);
	    	Log.d( " Received number  " , age);
	    	Log.d( " Received  serial number  " , s_no);  
	   // 	Log.d( , time);
	    	
	    		setValueNumber(number );
	    		setValueName(name );
	    		setValueAge(age);
	    		setValueSerialNumber(s_no);
	    		
	    	SetText(name, number, Integer.valueOf(age)); 

  /*  	Intent callIntent = new Intent(Intent.ACTION_CALL);
		    //   callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 callIntent.setData(Uri.parse("tel: " + number));
		    startActivity(callIntent);
*/
	    	
	    unregisterReceiver(broadcastReceiver);	
	    	
	    }  
	    
	 
	    public void setValueSerialNumber(String s_no)
		 {
			 this.s_no= s_no;
		 }
		 
		 public String getValueSerialNumber()
		 {
			 return this.s_no;
		 }
	 public void setValueNumber(String number )
	 {
		 this.phone= number;
	 }
	 
	 public String getValueNumber()
	 {
		 return this.phone;
	 }
	 public void setValueName(String name )
	 {
		 this.name= name;
	 }
	 
	 public String getValueName()
	 {
		 return this.name;
	 }
	 public void setValueAge(String age)
	 {
		 this.age1= age;
	 }
	 
	 public String getValueAge()
	 {
		 return this.age1;
	 }
	 public void setDispo(String dispo)
	 {
		 this.dispo= dispo;
	 }
	 
	 public String getDispo()
	 {
		 return this.dispo;
	 }
	 
	 
	    /*public void disposition()
	    {
	    	
	    }*/

	    
	 /*
	 * function to handle NI disposition
	 */
	 
	    
	public void NI(View ni)
	{
		Intent intent = new Intent();
	    intent.setAction("com.test.endcall");
	    sendBroadcast(intent);
	    
/*		 intent = new Intent(this, ReceiveService.class);
		    //intent.putStringArrayListExtra("check" ,  al);
			 
			 //intent.putExtra("phone", "8447056481");
			 //intent.putExtra("name", "vishesh");
			 intent.putExtra("age", 22);
			 startService(intent);
	*/    
	    		setDispo("NI");
	    
			 String phone1 = getValueNumber();
			 String name = getValueName();
			 String age = getValueAge();
			 
		 //Log.d(" Inserting: ", " Inserting values ..");
/*		 Log.d(" checking value of received number: ", phone1);
		 Log.d(" checking value of received name: ", name);
		 Log.d(" checking value of received age: ", age);
		 
*/
		 
		 
		 //mServer.create();
		
		/*DatabaseHelper db = new DatabaseHelper(this);
				
	    contact= mServer.getSingleValue();       
	    //    Cdetail cn = new Cdetail(); 
	        for (Contact cn : contact) {
	            String log = " sno : " + cn.getSno() + " ,PHONE : " + cn.getPhone();
	          
	          // db.deleteCdetailRow(cn.getPhone());
	           
	            // Writing Contacts to log
	        Log.d(" Agent : ", log);
	        
	            s_no = cn.getSno();
	       	 phone=cn.getPhone();       
	       	 f_name=cn.getFirstName(); 
	            
	    Log.d(" Sno : ", String.valueOf(s_no));
	    mServer.update(s_no);   
	    
	    mServer.createCall("NI" , phone , f_name);

	    
		
		
	        
	        } */
	}
	
	/*
	 * function to handle NE disposition
	 */
	
	public void NE(View ne)
	{
		Intent intent = new Intent();
	    intent.setAction("com.test.endcall");
	    sendBroadcast(intent);
	    
	    
		setDispo("NE");
	    
		 String phone1 = getValueNumber();
		 String name = getValueName();
		 String age = getValueAge();
	}
	
	/*
	 * function to handle PR disposition
	 */
	
	public void PR(View pr)
	{
		Intent intent = new Intent();
	    intent.setAction("com.test.endcall");
	    sendBroadcast(intent);
	    
	    
		setDispo("PR");
	    
		 String phone1 = getValueNumber();
		 String name = getValueName();
		 String age = getValueAge();
	}
	
	/*
	 * function to handle LEAD disposition
	 */
	
	public void LEAD(View lead)
	{
		Intent intent = new Intent();
	    intent.setAction("com.test.endcall");
	    sendBroadcast(intent);
	    
	    
		setDispo("LEAD");
	    
		 String phone1 = getValueNumber();
		 String name = getValueName();
		 String age = getValueAge();
	}

	/*
	 * function to handle forward button
	 */
	
	public void forward(View v)
	{
		
		Intent intent = new Intent();
	    intent.setAction("com.test.endcall");
	    sendBroadcast(intent);
	    
	    Log.d("forward" , "entered forward");
	    
	   Intent nintent = new Intent(this, SendService.class);
	    
		 
		 nintent.putExtra("phone", getValueNumber());
		 nintent.putExtra("name", getValueName());
		 nintent.putExtra("dispo", getDispo());
		 nintent.putExtra("s_no", getValueSerialNumber());
		 
	
		 
		 startService(nintent);
		 
		 intent = new Intent(this, BroadcastService.class);
	        //intent.putStringArrayListExtra("check" ,  al);
	    	 startService(intent);
	    	 registerReceiver(broadcastReceiver, new IntentFilter(BroadcastService.BROADCAST_ACTION));
	    
	    
	    
		
	}
	
	
	
	//on click of logout button agent will sign out from app
	
public void logout(View view)		
{
Intent j = new Intent(DialingScreen.this,MainActivity.class);
startActivity(j);
	
}

/*
 * function to date time picker
 */

public void showDateTimeDialog(View nview) {
    // Create the dialog
    final Dialog mDateTimeDialog = new Dialog(this);
 // Inflate the root layout
    final RelativeLayout mDateTimeDialogView = (RelativeLayout) getLayoutInflater().inflate(R.layout.date_time_dialog, null);
    // Grab widget instance
    final DateTimePicker mDateTimePicker = (DateTimePicker) mDateTimeDialogView.findViewById(R.id.DateTimePicker);
    // Check is system is set to use 24h time (this doesn't seem to work as expected though)
    final String timeS = android.provider.Settings.System.getString(getContentResolver(), android.provider.Settings.System.TIME_12_24);
    final boolean is24h = !(timeS == null || timeS.equals("12"));

    // Update demo TextViews when the "OK" button is clicked 
    ((Button) mDateTimeDialogView.findViewById(R.id.SetDateTime)).setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            mDateTimePicker.clearFocus();
            // TODO Auto-generated method stub
            /*date.setText(mDateTimePicker.get(Calendar.YEAR) 
            	+ "/" + (mDateTimePicker.get(Calendar.MONTH)+1) + "/"
                    + mDateTimePicker.get(Calendar.DAY_OF_MONTH));         */
            
    if (mDateTimePicker.is24HourView()) {
    
    	// ((TextView) findViewById(R.id.Time)).setText(mDateTimePicker.get(Calendar.HOUR_OF_DAY) + ":" + mDateTimePicker.get(Calendar.MINUTE));
        date.setText(mDateTimePicker.get(Calendar.YEAR) 
            	+ "/" + (mDateTimePicker.get(Calendar.MONTH)+1) + "/"
                + mDateTimePicker.get(Calendar.DAY_OF_MONTH) 
                + mDateTimePicker.get(Calendar.HOUR_OF_DAY) 
                + ":" + mDateTimePicker.get(Calendar.MINUTE));
    
    } 
    else 
    {
    
    	date.setText(mDateTimePicker.get(Calendar.YEAR) 
            	+ "/" + (mDateTimePicker.get(Calendar.MONTH)+1) + "/"
                + mDateTimePicker.get(Calendar.DAY_OF_MONTH) 
                + mDateTimePicker.get(Calendar.HOUR) 
                + ":" + mDateTimePicker.get(Calendar.MINUTE) 
                + " " + (mDateTimePicker.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));
    
    }
            mDateTimeDialog.dismiss();
        }
    });

    // Cancel the dialog when the "Cancel" button is clicked
    ((Button) mDateTimeDialogView.findViewById(R.id.CancelDialog)).setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            mDateTimeDialog.cancel();
        }
    });

    // Reset Date and Time pickers when the "Reset" button is clicked
    ((Button) mDateTimeDialogView.findViewById(R.id.ResetDateTime)).setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            mDateTimePicker.reset();
        }
    });

    // Setup TimePicker
    mDateTimePicker.setIs24HourView(is24h);
    // No title on the dialog window
    mDateTimeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    // Set the dialog content view
    mDateTimeDialog.setContentView(mDateTimeDialogView);
    // Display the dialog
    mDateTimeDialog.show();
}

public void call(View v)
{
	Intent callIntent = new Intent(Intent.ACTION_CALL);
    //   callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    callIntent.setData(Uri.parse("tel:8447056481"));
    startActivity(callIntent);
}

/*
 * class to listen to current call state
 */

private final PhoneStateListener mPhoneListener = new PhoneStateListener() {
    public void onCallStateChanged(int state, String incomingNumber) {
        try {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    Toast.makeText(getApplicationContext(), "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Intent check=new Intent(getApplicationContext(),DialingScreen.class);
                    startActivity(check);
                 /*   Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.maindialog);
                    dialog.setTitle("This is my custom dialog box");
                    dialog.setCancelable(true);
                    dialog.show(); */
                    Toast.makeText(getApplicationContext(), "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Toast.makeText(getApplicationContext(), "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
                    break;//CaptureCall.this
                default:
                    Toast.makeText(getApplicationContext(), "default", Toast.LENGTH_SHORT).show();
                    Log.i("Default", "Unknown phone state=" + state);
            }
        } catch (Exception e) {
            Log.i("Exception", "PhoneStateListener() e = " + e);
        }
    }
};

/*
 * function to end a call
 */

public void end(View aview)
{
	Intent intent = new Intent();
    intent.setAction("com.test.endcall");
    sendBroadcast(intent);
}

/*
 * function to set text on screen dynamically
 */

public void SetText( String f_name , String phone , int Age )
{
	
	 TextView camp = (TextView) findViewById(R.id.camp);
     camp.setText("CAMPAIGN : Campaign One");
     //camp.setText(campq);
     camp.setTextSize(16 * getResources().getDisplayMetrics().density);
     
     TextView contact1 = (TextView) findViewById(R.id.contact);
//     contact.setText("CONTACT DETAILS");
     contact1.setText(campq);
     contact1.setTextSize(16 * getResources().getDisplayMetrics().density);
     
     TextView name = (TextView) findViewById(R.id.name);
     name.setText("NAME : " + f_name);
     name.setTextSize(16 * getResources().getDisplayMetrics().density);
     
     TextView number = (TextView) findViewById(R.id.number);
     number.setText("MOBILE : " + phone);
     number.setTextSize(16 * getResources().getDisplayMetrics().density);
     
     TextView age = (TextView) findViewById(R.id.age);
     age.setText("AGE : " + Age );
     age.setTextSize(16 * getResources().getDisplayMetrics().density);
     
     String scripttext="Hi " + f_name + " .Did I catch you at good time? We are marketing company that helps companies like yours with branding,PR and positioning";
     
     TextView script = (TextView) findViewById(R.id.script);
      script.setText(scripttext);
      script.setTextSize(16 * getResources().getDisplayMetrics().density);
	
}


}




















/*
 * 
 * for date and time paicker simultaneously but not properly showing
 * 
 * 
public void button_click(View view){  
	// Create the dialog
	final Dialog mDateTimeDialog = new Dialog(this);
	// Inflate the root layout
	final RelativeLayout mDateTimeDialogView = (RelativeLayout) getLayoutInflater().inflate(R.layout.date_time_dialog, null);
	// Grab widget instance
	final DateTimePicker mDateTimePicker = (DateTimePicker) mDateTimeDialogView.findViewById(R.id.DateTimePicker);
	mDateTimePicker.setDateChangedListener(this); 
	 
	// Update demo TextViews when the "OK" button is clicked 
	((Button) mDateTimeDialogView.findViewById(R.id.SetDateTime)).setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			mDateTimePicker.clearFocus();
			// TODO Auto-generated method stub 
			String result_string = mDateTimePicker.getMonth() + "/" + String.valueOf(mDateTimePicker.getDay()) + "/" + String.valueOf(mDateTimePicker.getYear())
					+ "  " + String.valueOf(mDateTimePicker.getHour()) + ":" + String.valueOf(mDateTimePicker.getMinute());
//			if(mDateTimePicker.getHour() > 12) result_string = result_string + "PM";
//			else result_string = result_string + "AM";
			date.setText(result_string);
			mDateTimeDialog.dismiss();
		}
	});

	// Cancel the dialog when the "Cancel" button is clicked
	((Button) mDateTimeDialogView.findViewById(R.id.CancelDialog)).setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			mDateTimeDialog.cancel();
		}
	});

	// Reset Date and Time pickers when the "Reset" button is clicked

	((Button) mDateTimeDialogView.findViewById(R.id.ResetDateTime)).setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			mDateTimePicker.reset();
		}
	});
	  
	// Setup TimePicker
	// No title on the dialog window
	mDateTimeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	// Set the dialog content view
	mDateTimeDialog.setContentView(mDateTimeDialogView);
	// Display the dialog
	mDateTimeDialog.show();				
}
public void onDateChanged(Calendar c) {
	Log.e("",
			"" + c.get(Calendar.MONTH) + " " + c.get(Calendar.DAY_OF_MONTH)
					+ " " + c.get(Calendar.YEAR));
}



}


*/









/*

public static class DatePickerFragment extends DialogFragment
implements DatePickerDialog.OnDateSetListener {

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
//Use the current date as the default date in the picker
final Calendar c = Calendar.getInstance();
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int day = c.get(Calendar.DAY_OF_MONTH);

//Create a new instance of DatePickerDialog and return it
return new DatePickerDialog(getActivity(), this, year, month, day);
}

public void onDateSet(DatePicker view, int year, int month, int day) {
//Do something with the date chosen by the user
}
}
public void showDatePickerDialog(View v) {
    //DialogFragment newFragment = new DatePickerFragment();
    newFragment.show(getSupportFragmentManager(), "datePicker");
}
}

*/






	
	
	
	
	
	
	
