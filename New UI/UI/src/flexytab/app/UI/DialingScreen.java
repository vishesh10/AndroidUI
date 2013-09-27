package flexytab.app.UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DialingScreen extends Activity {

	//private TextView tvDisplayDate;
	//private DatePicker dpResult;
	//private Button btnChangeDate;
 
	//private int year;
	//private int month;
	//private int day;
	String campq="CONTACT DETAILS";
	String scripttext="Hi Ravi.Did I catch you at good time? We are marketing company that helps companies like yours with branding,PR and positioning";
 
	static final int DATE_DIALOG_ID = 999;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        
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



}





/* public void date (View view)
 {
 
	 //setCurrentDateOnView();
		addListenerOnButton(); 
 }

//display current date
	public void setCurrentDateOnView() {

		//tvDisplayDate = (TextView) findViewById(R.id.tvDate);
		dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		tvDisplayDate.setText(new StringBuilder()
			// Month is 0 based, just add 1
			.append(month + 1).append("-").append(day).append("-")
			.append(year).append(" "));

		// set current date into datepicker
		dpResult.init(year, month, day, null);

	}
 
	public void addListenerOnButton() {
		 
		btnChangeDate = (Button) findViewById(R.id.CB);
 
		btnChangeDate.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
 
			}
 
		});
 
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, 
                         year, month,day);
		}
		return null;
	}
 
	private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
 
			// set selected date into textview
		/*	tvDisplayDate.setText(new StringBuilder().append(month + 1)
			   .append("-").append(day).append("-").append(year)
*/
			// set selected date into datepicker also
		//	dpResult.init(year, month, day, null);
 
		//}
	//};
	

	
	
	
	
	
	
	
