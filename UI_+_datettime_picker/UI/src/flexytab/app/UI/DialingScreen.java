package flexytab.app.UI;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;  
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



public class DialingScreen extends FragmentActivity{
	//DialogFragment newFragment = new DatePickerFragment();
	//private TextView tvDisplayDate;
	//private DatePicker dpResult;
	//private Button btnChangeDate;
 
	//private int year;
	//private int month;
	//private int day;
	String campq="CONTACT DETAILS";
	String scripttext="Hi Ravi.Did I catch you at good time? We are marketing company that helps companies like yours with branding,PR and positioning";
	TextView date;
	
	static final int DATE_DIALOG_ID = 999;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialingscreen);
        date = (TextView) findViewById(R.id.script);
        
        
        TextView camp = (TextView) findViewById(R.id.camp);
        camp.setText("CAMPAIGN : Campaign One");
        //camp.setText(campq);
        camp.setTextSize(16 * getResources().getDisplayMetrics().density);
        
        TextView contact = (TextView) findViewById(R.id.contact);
//        contact.setText("CONTACT DETAILS");
        contact.setText(campq);
        contact.setTextSize(16 * getResources().getDisplayMetrics().density);
        
        TextView name = (TextView) findViewById(R.id.name);
        name.setText("NAME : Ravi Kumar");
        name.setTextSize(16 * getResources().getDisplayMetrics().density);
        
        TextView number = (TextView) findViewById(R.id.number);
        number.setText("MOBILE : 9999123456");
        number.setTextSize(16 * getResources().getDisplayMetrics().density);
        
        TextView age = (TextView) findViewById(R.id.age);
        age.setText("AGE : 26");
        age.setTextSize(16 * getResources().getDisplayMetrics().density);
         
                
       TextView script = (TextView) findViewById(R.id.script);
        script.setText(scripttext);
        script.setTextSize(16 * getResources().getDisplayMetrics().density);
        
        
        
	}

	 
	
	
	
	
	//on click of logout button agent will sign out from app
	
public void logout(View view)		
{
Intent j = new Intent(DialingScreen.this,MainActivity.class);
startActivity(j);
	
}

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






	
	
	
	
	
	
	
