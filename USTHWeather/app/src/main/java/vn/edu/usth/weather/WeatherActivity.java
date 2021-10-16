package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
            Toast.makeText(this, "Refresh everything", Toast.LENGTH_SHORT).show();
            return true;
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
