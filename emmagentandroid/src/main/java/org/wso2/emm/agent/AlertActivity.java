/*
 ~ Copyright (c) 2014, WSO2 Inc. (http://wso2.com/) All Rights Reserved.
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~      http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
*/
package org.wso2.emm.agent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AlertActivity extends ActionBarActivity {
	String message = "";
	Button btnOK;
	TextView txtMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert);
		
		btnOK = (Button)findViewById(R.id.btnOK);
		txtMessage = (TextView)findViewById(R.id.txtMessage);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			if(extras.containsKey( getResources().getString(R.string.intent_extra_message))){
				message = extras.getString( getResources().getString(R.string.intent_extra_message));
			}
		}
		
		txtMessage.setText(message);
		
		btnOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
