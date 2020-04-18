package com.androidtutorialpoint.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    TextView text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);

        connection();
    }

    private void connection() {
        Log.i("ahmed", "onCreate: ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("ahmed", "onCreate: ");
        GetAPI getAPI = retrofit.create(GetAPI.class);
        Log.i("ahmed", "onCreate: ");
        Call<ResultModel> conn = getAPI.getPosts();
        Log.i("ahmed", "onCreate: ");
        conn.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call <ResultModel> call, Response<ResultModel> response) {
                List<MovieModel> models =response.body().getResults();
                StringBuilder builder = new StringBuilder();
                for (MovieModel model:models){
                    builder.append(model.getTitle().toString()+"\n");
                }
                text.setText(builder);
            }

            @Override
            public void onFailure(Call <ResultModel> call, Throwable t) {
                Log.i("ahmed", "onFailure: "+t);
                Log.i("ahmed", "onFailure: "+call);

                text.setText(t.toString());
            }

        });
    }

    public interface GetAPI{
        @GET("popular?api_key=ddcab0907164e022b72ad3818937cf00")
        Call <ResultModel> getPosts() ;
    }

    public class ResultModel{
        private List<MovieModel> results ;
        public List<MovieModel> getResults(){
            return  results ;
        }
        public void setResults(List<MovieModel> results){
            this.results = results ;
        }
    }
}
