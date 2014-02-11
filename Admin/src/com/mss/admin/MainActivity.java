package com.mss.admin;

import com.mss.admin.R;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

/**
 * 
 * @author Master Software Solutions
 * 
 */
public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("componenet_name", "1");
		
		new Handler().postDelayed(new Runnable() {   

			@Override
			public void run() {
				Intent mIntent = new Intent(MainActivity.this, About.class);
				startActivity(mIntent);
				finish();

			}
		}, 3000);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

 
}







