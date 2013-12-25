package com.artal.mobile_repetitor.Activities;

import android.app.Activity;
import android.content.Intent;

import com.artal.mobile_repetitor.testEntities.SubjectsEnumeration;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

	public class MainActivity extends Activity
	{
		protected void onCreate (Bundle bundle)
		{
			super.onCreate (bundle);
//			SetContentView (R.layout.Main);

//			Button mathButton = (Button) findViewById (R.id.MathButton);
			
//			mathButton.setOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					startActivity(GetSubjectIntent(SubjectsEnumeration.Math));
//				}
//			});
//
//			((ImageButton)(FindViewById(R.Id.marketButton))).setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					MarketButtonClick();
//					
//				}
//			});
			
//			((TextView) findViewById(R.Id.marketTextView)).setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					MarketButtonClick();
//					
//				}
//			});
			

//			(FindViewById<ImageButton> (Resource.Id.vkButton)).Click += VkButtonClick;
//			(FindViewById<TextView> (Resource.Id.vkTextView)).Click += VkButtonClick;
//
//			(FindViewById<ImageButton> (Resource.Id.shareButton)).Click += ShareButtonClick;
//			(FindViewById<TextView> (Resource.Id.shareTextView)).Click += ShareButtonClick;
//
//			(FindViewById<ImageButton> (Resource.Id.almaButton)).Click += AlmaButtonClick;
//			(FindViewById<TextView> (Resource.Id.almaTextView)).Click += AlmaButtonClick;
//
//			(FindViewById<ImageButton> (Resource.Id.anketaButton)).Click += AnketaButtonClick;
//			(FindViewById<TextView> (Resource.Id.anketaTextView)).Click += AnketaButtonClick;
		}

//		private Intent GetSubjectIntent(SubjectsEnumeration subjectType)
//		{
////			Intent intent = new Intent (this, typeof(SubjectActivity));
////			intent.PutExtra ("SubjectType", subjectType.ToString());
////			return intent;
//		}

		public void onBackPressed ()
		{
			finish ();
		}

//		public bool onPrepareOptionsMenu (Menu menu) {
//			return false;
//		}

		private void MarketButtonClick()
		{
			goToURL ("https://play.google.com/store/apps/details?id=com.flaxtreme.CT");
			//GoToURL ("https://play.google.com/store/apps/details?id=com.flaxtreme.pahonia");	
		}

//		private void VkButtonClick(Object sender, EventArgs args)
//		{
//			goToURL ("http://vk.com/topic-50105858_29108685");	
//		}
//
//		private void AlmaButtonClick(Object sender, EventArgs args)
//		{
//			goToURL ("http://goo.gl/Ro8frA");	
//		}
//
//		private void AnketaButtonClick(Object sender, EventArgs args)
//		{
//			goToURL ("http://goo.gl/qvigG2");
//		}
//
//		private void ShareButtonClick(Object sender, EventArgs args)
//		{
//			Intent sharingIntent = new Intent(Intent.ActionSend);
//			sharingIntent.SetType ("text/plain");
//			String shareBody = "Тесты для подготовки к ЦТ на смартфонах и планшетах Андроид. Скачай тут: http://goo.gl/38xv4s";
//			sharingIntent.PutExtra(Intent.ExtraText, shareBody);
//			StartActivity(Intent.CreateChooser(sharingIntent, "Поделиться"));
//		}

		private void goToURL(String url)
		{
			Uri uri = Uri.parse (url);
			if (uri != null) {
				Intent launchBrowser = new Intent (Intent.ACTION_VIEW, uri);
				startActivity (launchBrowser);
			} 
		}
	}


