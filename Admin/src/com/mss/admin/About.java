package com.mss.admin;
 

import android.os.Bundle;
import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity {
TextView textView_uninstall_desc;
private static final int	REQUEST_ENABLE	= 9;
/*
 * 
 * DevicePolicyManager is public interface for managing policies enforced on
 * a device.
 */
DevicePolicyManager			mDPM;
ComponentName				mAdminName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mAdminName = new ComponentName(this, DeviceAdminReceiver.class);
		/*
		 * 
		 * DeviceAdminReceiver is a Base class for implementing a device administration component.
		 * 
		 */
		Log.i("componenet_name", mAdminName+"aaa");

		if (!mDPM.isAdminActive(mAdminName)) {
			Intent mIntent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			/*
			 * 
			 * ACTION_ADD_DEVICE_ADMIN: ask the user to add a new device
			 * administrator to the system.
			 */
			mIntent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName);
			/*
			 * 
			 * EXTRA_DEVICE_ADMIN: The desired policy is the ComponentName of
			 * the policy in the EXTRA_DEVICE_ADMIN extra field. This will
			 * invoke a UI to bring the user through adding the device
			 * administrator to the system
			 */
			mIntent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
					"additional text explaining why this needs to be added");
			/*
			 * 
			 * EXTRA_ADD_EXPLANATION: This feild is optional. Provide user
			 * additional explanation
			 */
			startActivityForResult(mIntent, REQUEST_ENABLE);
			
			
		}
		else {
			// Already is a device administrator, can do security operations now.
			mDPM.removeActiveAdmin(mAdminName);
		}
        textView_uninstall_desc=(TextView)findViewById(R.id.tv_uninstall_desc);
        textView_uninstall_desc.setText(Html.fromHtml(getResources().getString(R.string.procedure_to_uninstall)));        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }
    
}
