package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ForecastFragment forecast = ForecastFragment.newInstance("", "");
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, forecast).commit();
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
