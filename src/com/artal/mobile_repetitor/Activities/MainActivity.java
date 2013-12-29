package com.artal.mobile_repetitor.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.artal.mobile_repetitor.R;
import com.artal.mobile_repetitor.testEntities.SubjectsEnumeration;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;

	public class MainActivity extends Activity
	{
		protected void onCreate (Bundle bundle)
		{
			super.onCreate (bundle);
			setContentView (R.layout.main_layout);

			Button mathButton = (Button) findViewById (R.id.MathButton);
			
			mathButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					v.getContext().startActivity(GetSubjectIntent(v.getContext(), SubjectsEnumeration.Math));
				}
			});

          	((ImageButton)(findViewById(R.id.marketButton))).setOnClickListener(MarketButtonClick());
			((TextView) findViewById(R.id.marketTextView)).setOnClickListener(MarketButtonClick());
			

			((ImageButton)findViewById(R.id.vkButton)).setOnClickListener(VkButtonClick());
			((TextView) findViewById(R.id.vkTextView)).setOnClickListener(VkButtonClick());

			((ImageButton)findViewById(R.id.shareButton)).setOnClickListener(ShareButtonClick());
			((TextView) findViewById(R.id.shareTextView)).setOnClickListener(ShareButtonClick());
			
			((ImageButton)findViewById(R.id.almaButton)).setOnClickListener(AlmaButtonClick());
			((TextView) findViewById(R.id.almaTextView)).setOnClickListener(AlmaButtonClick());

			((ImageButton)findViewById(R.id.anketaButton)).setOnClickListener(AnketaButtonClick());
			((TextView) findViewById(R.id.anketaTextView)).setOnClickListener(AnketaButtonClick());
		}

		@Override
		protected void onStart(){
			super.onStart();
			FlurryAgent.onStartSession(this, "95YK9RHV94XGK4TS6996");
		}
		
		@Override
		protected void onStop(){
			super.onStop();		
			FlurryAgent.onEndSession(this);
		}

		private Intent GetSubjectIntent(Context context,SubjectsEnumeration subjectType)
		{
		  Intent intent = new Intent (context, SubjectActivity.class);
	      intent.putExtra ("SubjectType", subjectType.toString());
	      return intent;
		}

		public void onBackPressed ()
		{
			finish ();
		}

		public boolean onPrepareOptionsMenu (Menu menu) {
			return false;
		}

		private OnClickListener MarketButtonClick()
		{
			return new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					FlurryAgent.logEvent("MarketButtonClickMainActivity");
					goToURL ("https://play.google.com/store/apps/details?id=com.flaxtreme.CT");
					//GoToURL ("https://play.google.com/store/apps/details?id=com.flaxtreme.pahonia");
					
				}
			};	
		}

		private OnClickListener VkButtonClick()
		{
			return new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					goToURL ("http://vk.com/topic-50105858_29108685");
					FlurryAgent.logEvent("VKButtonClickMainActivity");
					
				}
			};
		}

		private OnClickListener AlmaButtonClick()
		{
			return new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					goToURL ("http://goo.gl/Ro8frA");	
					
				}
			};
		}

		private OnClickListener AnketaButtonClick()
		{
			return new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					goToURL ("http://goo.gl/qvigG2");
					
				}
			};
			
		}

		private OnClickListener ShareButtonClick()
		{
			return new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent sharingIntent = new Intent(Intent.ACTION_SEND);
					sharingIntent.setType ("text/plain");
					String shareBody = "Тесты для подготовки к ЦТ на смартфонах и планшетах Андроид. Скачай тут: http://goo.gl/38xv4s";
					sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
					startActivity(Intent.createChooser(sharingIntent, "Поделиться"));
				}
			};
		}

		private void goToURL(String url)
		{
			Uri uri = Uri.parse (url);
			if (uri != null) {
				Intent launchBrowser = new Intent (Intent.ACTION_VIEW, uri);
				startActivity (launchBrowser);
			} 
		}
	}