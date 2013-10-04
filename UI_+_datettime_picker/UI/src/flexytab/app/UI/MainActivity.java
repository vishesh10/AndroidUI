package flexytab.app.UI;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
//import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
	}



	public void camp(View view)
	{
		 //Toast.makeText(MainActivity.this,"correct",Toast.LENGTH_LONG).show();

		Intent i = new Intent(MainActivity.this,NewScreen.class);
		startActivity(i);
	}
	
}