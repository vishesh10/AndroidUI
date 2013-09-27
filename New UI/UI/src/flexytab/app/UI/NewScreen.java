package flexytab.app.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class NewScreen extends Activity implements OnItemSelectedListener{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscreen);
     
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

     // Spinner click listener
       spinner.setOnItemSelectedListener(this);
        
        // Spinner Drop down elements
        List<String> list = new ArrayList<String>();
            list.add("Campaign One");
            list.add("Campaign Two");
            
            
         // Creating adapter for spinner
         ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
         
         // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         
      // attaching data adapter to spinner
         spinner.setAdapter(dataAdapter);
         
       
         
	}
            
    
	@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
  //      String item = parent.getItemAtPosition(position).toString();
        
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
 
    }
	
	public void onNothingSelected(AdapterView<?> arg0){
		Toast.makeText(arg0.getContext(), " NOT Selected: ", Toast.LENGTH_LONG).show();
      
    }
   
	//For starting the dialing screen on pressing "start dialing " button
	
	public void startdialing(View view)
	{
		Toast.makeText(NewScreen.this, "Selected: ", Toast.LENGTH_LONG).show();
		Intent dial_screen = new Intent(NewScreen.this,DialingScreen.class);
		startActivity(dial_screen);
	}

}