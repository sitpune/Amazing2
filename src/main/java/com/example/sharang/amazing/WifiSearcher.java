package com.example.sharang.amazing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class WifiSearcher extends AppCompatActivity {

    WifiManager wifiManager;
    String wifis[];
    int signalStrengths[];
    WifiScanReceiver wifiScanReceiver;
    boolean levels[];
    int counter = 0;
    int level = 1;
    CoordinatorLayout cl;
    SharedPreferences preferences;              //we use this for saving the ssid set or not details in shared prefs
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_searcher);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        editor = preferences.edit();

        levels = new boolean[12];
        wifiManager=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiScanReceiver=new WifiScanReceiver();
        wifiManager.startScan();

        level = preferences.getInt("level",1);
        counter = preferences.getInt("clues",0);

        cl = (CoordinatorLayout)findViewById(R.id.cl);
        cl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){

                    return true;
                }
                return false;
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.startScan();
                Snackbar.make(view, "scanning...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onPause() {
        unregisterReceiver(wifiScanReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerReceiver(wifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        level = preferences.getInt("level",1);
        counter = preferences.getInt("clues",0);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wifi_searcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clues) {
            Toast.makeText(WifiSearcher.this,"the number of clues unlocked : " + counter + " \n Current level : " + level ,Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_clueshow) {
            Intent i = new Intent(WifiSearcher.this,Clue_swipe.class);
            i.putExtra("level",level);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class WifiScanReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

            List<ScanResult> wifiScanList = wifiManager.getScanResults();     //listArray of all the wifi hotspots
            ScanResult result[] = wifiScanList.toArray(new ScanResult[wifiScanList.size()]);  //getting an array from list
            wifis = new String[wifiScanList.size()];               //stores the ssid
            signalStrengths = new int[wifiScanList.size()];        //stores level

            for (int i = 0; i < wifiScanList.size(); i++) {
                //wifis[i] = ((wifiScanList.get(i)).toString());
                wifis[i] = ((result[i].SSID));                 //extracting ssid from result of wifi scan
                signalStrengths[i]=result[i].level;           //extracting level from result of wifi scan
            }
            for(int i=0;i<wifis.length;i++)
            {
                    if(wifis[i].contentEquals("SYMBIOSIS")){
                        if(!levels[0])
                        {
                            levels[0] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 5)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("Rangoli") && signalStrengths[i] >= -40){
                        if(!levels[1])
                        {
                            levels[1] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 5)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("DirectorsOffice") && signalStrengths[i] >= -40){
                        if(!levels[2])
                        {

                            levels[2] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 5)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("DDirectorsOffice") && signalStrengths[i] >= -40){
                        if(!levels[3])
                        {

                            levels[3] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 5)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("Schc") && signalStrengths[i] >= -40 ){
                        if(!levels[4])
                        {

                            levels[4] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 5)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }
//////////////////////////////////////////////////////////Harry Potter level 1/////////////////////////////////////////////////////////

                    else if(wifis[i].contentEquals("NaacShed") && signalStrengths[i] >= -40 && level == 2){
                        if(!levels[5])
                        {
                            levels[5] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 3)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }

                    }

                    else if(wifis[i].contentEquals("ChemistryLab") && signalStrengths[i] >= -40 && level==2){
                        if(!levels[6])
                        {
                            levels[6] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 3)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("GasContainerShed") && signalStrengths[i] >= -40 && level==2){
                        if(!levels[7])
                        {
                            levels[7] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 3)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }
//////////////////////////////////////////////////////////Batman level 2/////////////////////////////////////////////////////////
                    else if(wifis[i].contentEquals("CCD") && signalStrengths[i] >= -40 && level ==3){
                        if(!levels[8])
                        {
                            levels[8] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 4)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("CulinaryArts") && signalStrengths[i] >= -40 && level ==3){
                        if(!levels[9])
                        {
                            levels[9] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 4)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("BBlock") && signalStrengths[i] >= -40 && level ==3){
                        if(!levels[10])
                        {
                            levels[10] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 4)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("CoffeeStop") && signalStrengths[i] >= -40 && level ==3){
                        if(!levels[11])
                        {
                            levels[11] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 4)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }
//////////////////////////////////////////////////////////Friends level 3/////////////////////////////////////////////////////////
                    else if(wifis[i].contentEquals("MorgueChemLab") && signalStrengths[i] >= -40 && level ==4){
                        if(!levels[12])
                        {
                            levels[12] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 2)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

                    else if(wifis[i].contentEquals("Library") && signalStrengths[i] >= -40 && level ==4){
                        if(!levels[13])
                        {
                            levels[13] = true;
                            counter++;
                            editor.putInt("clues",counter);
                            if(counter == 2)
                            {
                                ++level;
                                editor.putInt("level",level);
                                counter=0;
                                editor.putInt("clues",counter);
                            }
                        }
                    }

//////////////////////////////////////////////////////////Sherlock level 4/////////////////////////////////////////////////////////
            }
        }
    }
}
