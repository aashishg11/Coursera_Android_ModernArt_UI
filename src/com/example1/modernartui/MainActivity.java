package com.example1.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
	SeekBar sb;
	LinearLayout l_up, l_down, r_up, r_mid, r_down;
	int color, color1;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		l_up = (LinearLayout) findViewById(R.id.left_top);
		l_down = (LinearLayout) findViewById(R.id.left_bottom);
		r_up = (LinearLayout) findViewById(R.id.right_top);
		r_mid = (LinearLayout) findViewById(R.id.right_mid);
		r_down = (LinearLayout) findViewById(R.id.right_bottom);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setOnSeekBarChangeListener(this);

	}

	public void updatebackground() {
		color = sb.getProgress();
		
		  l_up.setBackgroundColor(Color.rgb(49+color*2,59+color,214-(Integer)color/2));
		  l_down.setBackgroundColor(Color.rgb(242,61+color,168-(Integer)color/3));
		  r_up.setBackgroundColor(Color.rgb(68,40+color,98+color));
		  r_down.setBackgroundColor(Color.rgb(125,40+color,105));
		/* 
		l_up.setBackgroundColor(getResources().getColor(R.color.ltop));
		l_down.setBackgroundColor(getResources().getColor(R.color.lbottom)
				+ color * 0x0000FF);
		r_up.setBackgroundColor(getResources().getColor(R.color.rtop) + color
				* 0x00FF00);
		r_down.setBackgroundColor(getResources().getColor(R.color.rbottom)
				+ color * 0x0000FF);*/

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

		updatebackground();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.testmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.info:
			infoMenuItem();
			break;
		}
		return true;
	}

	private void infoMenuItem() {

		tv = new TextView(this);
		tv.setGravity(Gravity.CENTER_HORIZONTAL);
		tv.setText("\n Inspired by the works of artists such as Piet Mondrian and Ben Nicholeson."
				+ "\n\n Click below to learn more!\n");
		new AlertDialog.Builder(this)
				.setView(tv)
				.setNegativeButton("Visit MOMA",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								Intent webIntent = null;

								Uri webpage = Uri.parse("http://www.moma.org");
								webIntent = new Intent(Intent.ACTION_VIEW,
										webpage);
								startActivity(webIntent);
							}
						})

				.setNeutralButton("Not now",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();

	}

}
