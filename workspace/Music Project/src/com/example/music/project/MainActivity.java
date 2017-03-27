package com.example.music.project;

import java.io.File;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.FileA3D.IndexEntry;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	String choosenSong;
	String mySong;
	String kid = "AC DC Thunderstruck";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Declaring Everything
        final Spinner selectedSong = (Spinner)findViewById(R.id.txt_Song);
        Button purchase = (Button)findViewById(R.id.bt_Purchase);
        Button play = (Button)findViewById(R.id.bt_Play);
        final TextView choosenSong = (TextView)findViewById(R.id.txtSong);
        final MediaPlayer mp = new MediaPlayer();     
        final AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        final AlertDialog.Builder alt_bld2 = new AlertDialog.Builder(this);
        final ImageView kidRock = (ImageView)findViewById(R.id.imageView1);
        final ImageView hinder = (ImageView)findViewById(R.id.ImageView01);
        final ImageView acdc = (ImageView)findViewById(R.id.ImageView02);
        
        // Getting whatever song was selected from the drop down
        mySong = selectedSong.getSelectedItem().toString();
        
        // Play Song when play button is clicked
        play.setOnClickListener(new OnClickListener()
        {			
			public void onClick(View v) 
			{		
				// Selected Song
				mySong = selectedSong.getSelectedItem().toString();
				
				// Find the selected song on the phone if the names are the same
				String file = "/sdcard/testing/" + mySong + ".mp3";

				try 
				{
					   mp.stop();
					   mp.setDataSource(file);
					   mp.prepare();

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Starting to play the song
				mp.start();
				
				// Setting the choosenSong label to the selected song
			    choosenSong.setText(mySong);   
			}
		});     
        
        // After clicking purchase this will ask you if you want to actually purchase the song with a yes or no.
        alt_bld.setPositiveButton("Yes", new DialogInterface.OnClickListener() 
        {
        	public void onClick(DialogInterface dialog, int id) 
        	{
        	// If yes is clicked does this
        		// Prompts a message that says thank you and says the song
        		alt_bld2.setMessage("Thank You For Purchasing " + mySong.toString());				
				AlertDialog alert2 = alt_bld2.create();
				// Another congratulations alert
				alert2.setTitle("CONGRATULATIONS!");
				alert2.show();
        	}
        });
        
        alt_bld.setNegativeButton("No", new DialogInterface.OnClickListener() 
        {
        	public void onClick(DialogInterface dialog, int id) 
        	{
        	// If no is clicked do nothing  		
        	}
        });
         
        purchase.setOnClickListener(new OnClickListener()
        {			
			public void onClick(View v) 
			{	
				// Tells you the amount
				alt_bld.setMessage("Your Total Amount Comes to $1.00");				
				AlertDialog alert = alt_bld.create();
				alert.setTitle("Attention!");
				alert.show();				
			}
        });
            
       // Setting an image to the selected songs album cover 
        selectedSong.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
            {
            	Integer indexValue = selectedSong.getSelectedItemPosition();
            	
                // your code here
            	if (indexValue == 0)
            	{
            		kidRock.setVisibility(View.VISIBLE);
            		hinder.setVisibility(View.INVISIBLE);
            		acdc.setVisibility(View.INVISIBLE);
            	}
            	
            	if (indexValue == 1)
            	{
            		hinder.setVisibility(View.VISIBLE);
            		kidRock.setVisibility(View.INVISIBLE);
            		acdc.setVisibility(View.INVISIBLE);
            	}
            	
            	if (indexValue == 2)
            	{
            		acdc.setVisibility(View.VISIBLE);
            		kidRock.setVisibility(View.INVISIBLE);
            		hinder.setVisibility(View.INVISIBLE);
            	}
            }            
            @Override
            public void onNothingSelected(AdapterView<?> parentView) 
            {
                // your code here
            }
        });
          
        // if you click the album art it will go the artist site.
        kidRock.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kidrock.com/")));
            }
        });
        
        hinder.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hindermusic.com/home/index.shtml")));
            }
        });
        
        acdc.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.acdc.com/us")));
            }
        });
        
    }  		    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
