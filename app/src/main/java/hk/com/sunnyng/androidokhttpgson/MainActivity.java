package hk.com.sunnyng.androidokhttpgson;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends ListActivity {


    private static final String TAG = "OkHttp";
    ListAdapter adapter = null;
    ListView lv = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lv = getListView();
        MyAsyncTask task = new MyAsyncTask(this);
        task.execute("http://www.imagenation.com.hk/contacts.json");
    }


    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        ListActivity la;
        public MyAsyncTask(ListActivity la) {
            this.la = la;
        }

        @Override
        protected String doInBackground(String... params) {
            String dataString = "";
            try {
                URL url = new URL(params[0]);
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = client.newCall(request).execute();
                dataString = response.body().string();

            }
            catch (Exception e) {
                Log.e(TAG, "loadContent: " + e.getMessage());
                e.printStackTrace();
            }
            return dataString;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String dataString) {
            super.onPostExecute(dataString);
            Gson gson = new Gson();
            Contact contacts[] = gson.fromJson(dataString, Contact[].class);

            ContactsAdapter adapter = new ContactsAdapter(this.la,
                    R.layout.row,
                    contacts);
            lv.setAdapter(adapter);
        }

    }

}
