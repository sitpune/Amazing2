package com.example.sharang.amazing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Clue_swipe extends AppCompatActivity {

    RelativeLayout rl;
    float oldTouchValue;
    int ctr = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue_harry);
        int level = getIntent().getIntExtra("level",0);
        rl = (RelativeLayout)findViewById(R.id.activity_clue);
        switch (level)
        {
            case 1 : rl.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (event.getAction())

                    {
                        case MotionEvent.ACTION_DOWN:

                            oldTouchValue = event.getX();
                        break;

                        case MotionEvent.ACTION_UP:

                            float currentX = event.getX();
                            if (oldTouchValue < currentX)
                            {
                                if(ctr!=0) ctr--;
                            }
                            if (oldTouchValue > currentX )
                            {
                                if(ctr==4) ctr=0;
                                else ctr++;
                            }
                            switch(ctr)
                            {

                                case 0 : startActivity(new Intent(Clue_swipe.this,WifiSearcher.class));
                                    break;

                                case 1 : rl.setBackground(getResources().getDrawable(R.drawable.daigon));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            rl.setBackground(getResources().getDrawable(R.drawable.hpclue1));
                                        }
                                    }, 3000);
                                    break;

                                case 2 : rl.setBackground(getResources().getDrawable(R.drawable.final_dumbledore));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            rl.setBackground(getResources().getDrawable(R.drawable.hpclue2));
                                        }
                                    }, 3000);
                                    break;

                                case 3 : rl.setBackground(getResources().getDrawable(R.drawable.mcgonal_final));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            rl.setBackground(getResources().getDrawable(R.drawable.hpclue3));
                                        }
                                    }, 3000);
                                    break;

                                case 4 : rl.setBackground(getResources().getDrawable(R.drawable.hermoine));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            rl.setBackground(getResources().getDrawable(R.drawable.hpclue4));
                                        }
                                    }, 3000);
                                    break;
                            }

                        break;

                    }

                    return Clue_swipe.super.onTouchEvent(event);
                }
            });

                break;

            case 2 : setContentView(R.layout.activity_clue_batman);
                ctr = 0;
                rl = (RelativeLayout) findViewById(R.id.activity_clue_batmanrl);
                rl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction())

                        {
                            case MotionEvent.ACTION_DOWN:

                                oldTouchValue = event.getX();
                                break;

                            case MotionEvent.ACTION_UP:

                                float currentX = event.getX();
                                if (oldTouchValue < currentX)
                                {
                                    if(ctr!=0) ctr--;
                                }
                                if (oldTouchValue > currentX )
                                {
                                    if(ctr==3) ctr=0;
                                    else ctr++;
                                }
                                switch(ctr)
                                {

                                    case 0 : startActivity(new Intent(Clue_swipe.this,WifiSearcher.class));
                                        break;

                                    case 1 : rl.setBackground(getResources().getDrawable(R.drawable.batmobile));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.batclue1));
                                            }
                                        }, 3000);
                                        break;

                                    case 2 : rl.setBackground(getResources().getDrawable(R.drawable.joker));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.batclue2));
                                            }
                                        }, 3000);
                                        break;

                                    case 3 : rl.setBackground(getResources().getDrawable(R.drawable.twofaced));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.batclue3));
                                            }
                                        }, 3000);
                                        break;
                                }

                                break;

                        }

                        return Clue_swipe.super.onTouchEvent(event);
                    }
                });

                break;

            case 3 :  setContentView(R.layout.activity_clue_friends);
                ctr = 0;
                rl = (RelativeLayout) findViewById(R.id.activity_clue_friends_rl);
                rl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction())

                        {
                            case MotionEvent.ACTION_DOWN:

                                oldTouchValue = event.getX();
                                break;

                            case MotionEvent.ACTION_UP:

                                float currentX = event.getX();
                                if (oldTouchValue < currentX)
                                {
                                    if(ctr!=0) ctr--;
                                }
                                if (oldTouchValue > currentX )
                                {
                                    if(ctr==4) ctr=0;
                                    else ctr++;
                                }
                                switch(ctr)
                                {

                                    case 0 : startActivity(new Intent(Clue_swipe.this,WifiSearcher.class));
                                        break;

                                    case 1 : rl.setBackground(getResources().getDrawable(R.drawable.phebes));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.fclue1));
                                            }
                                        }, 3000);
                                        break;

                                    case 2 : rl.setBackground(getResources().getDrawable(R.drawable.monica));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.fclue2));
                                            }
                                        }, 3000);
                                        break;

                                    case 3 : rl.setBackground(getResources().getDrawable(R.drawable.frame));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.fclue3));
                                            }
                                        }, 3000);
                                        break;

                                    case 4 : rl.setBackground(getResources().getDrawable(R.drawable.joey));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.fclue4));
                                            }
                                        }, 3000);
                                        break;
                                }

                                break;

                        }

                        return Clue_swipe.super.onTouchEvent(event);
                    }
                });

                break;

            case 4 :
                setContentView(R.layout.activity_clue_sherlock);
                ctr = 0;
                rl = (RelativeLayout) findViewById(R.id.acsherlockrl);
                rl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction())

                        {
                            case MotionEvent.ACTION_DOWN:

                                oldTouchValue = event.getX();
                                break;

                            case MotionEvent.ACTION_UP:

                                float currentX = event.getX();
                                if (oldTouchValue < currentX)
                                {
                                    if(ctr!=0) ctr--;
                                }
                                if (oldTouchValue > currentX )
                                {
                                    if(ctr==3) ctr=0;
                                    else ctr++;
                                }
                                switch(ctr)
                                {

                                    case 0 : startActivity(new Intent(Clue_swipe.this,WifiSearcher.class));
                                        break;

                                    case 1 : rl.setBackground(getResources().getDrawable(R.drawable.sherlock));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.sclue1));
                                            }
                                        }, 3000);
                                        break;

                                    case 2 : rl.setBackground(getResources().getDrawable(R.drawable.sherlock2));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                rl.setBackground(getResources().getDrawable(R.drawable.sclue2));
                                            }
                                        }, 3000);
                                        break;
                                }

                                break;

                        }

                        return Clue_swipe.super.onTouchEvent(event);
                    }
                });

                break;
        }

    }
}
