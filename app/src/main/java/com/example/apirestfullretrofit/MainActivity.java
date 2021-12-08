package com.example.apirestfullretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado=findViewById(R.id.txtResultado);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUserApi jsonUserApi=retrofit.create(JsonUserApi.class);

        Call<List<Post>> call= jsonUserApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    txtResultado.setText("Codigo: "+response.code());
                    return;
                }

                List<Post> posts=response.body();

                for(Post post:posts){
                    String content="";
                    content+= "ID:"+post.getId()+ "\n";
                    content+= "NAME:"+post.getName()+ "\n";
                    content+="EMAIL:"+post.getEmail()+ "\n";
                    content+= "GENDER:"+post.getGender()+ "\n";
                    content+="STATUS:"+post.getStatus()+ "\n";
                    content+="------------------------"+"\n";

                    txtResultado.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txtResultado.setText(t.getMessage());
            }
        });


    }
}