package vn.edu.usth.weather;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//        WeatherAndForecastFragment wff = WeatherAndForecastFragment.newInstance("", "");
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.container, wff).commit();
        PagerAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        InputStream is = getResources().openRawResource(R.raw.sample);
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.sample);
        mediaPlayer.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            final Handler handler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    String content = msg.getData().getString("server_response");
                    Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
                }
            };
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Bundle bundle = new Bundle();
                    Bundle.putString("server_response", "some sample json here");
                    Message msg = new Message();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                }
            });
            t.start();
        }
        else if (item.getItemId() == R.id.setting) {
            Intent intent = new Intent(WeatherActivity.this, PrefActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather", "onStart() is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather", "onStop() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather", "onDestroy() is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather", "onPause() is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather", "onResume() is called");
    }
}
