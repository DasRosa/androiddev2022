package vn.edu.usth.weather;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private final Activity contextParent;

    public MyAsyncTask(Activity contextParent) {
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextParent, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(Bitmap param) {
        super.onPostExecute(param);
        Toast.makeText(contextParent, "Finished", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Bitmap doInBackground(String... param) {
        URL url = new URL("http://ict.usth.edu.vn/wp-content/" +
                "uploads/usth/usthlogo.png");
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();

        int response = connection.getResponseCode();
        Log.i("USTHWeather", "The response is: " + response);
        InputStream is = connection.getInputStream();

        Bitmap bitmap = BitmapFactory.decodeStream(is);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setImageBitmap(bitmap);
        connection.disconnect();

        return null;
    }
}
