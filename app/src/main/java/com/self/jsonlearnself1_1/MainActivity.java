package com.self.jsonlearnself1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response)
            {
                if(!response.isSuccessful())
                {
                    textView.setText("Code" + response.code());
                    return;
                }
                //response.isSuccessful().body()
                List<Post> posts = response.body();

                for (Post post:posts)
                {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID" + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Body: " + post.getBody() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Someting wrong with server '404' Not found or execute or json do not pass into ....single java obj.", Toast.LENGTH_SHORT).show();
                textView.setText(t.getMessage());
            }
        });



    }
}

  /*
        Gson gson = new Gson();
        Address address = new Address("China","Hefei");

        //1
       // Employee employee = new Employee("jone",30,"zhal@gmail.com",address);
        //String json = gson.toJson(employee);


       //2
       String json = "{\"first_name\" : \"hongan\",\"Age\": \"20\",\"Email\": \"zhanghong@2020@gmail.com\":\"address\":{\"country\":\"China\",\"city\":\"Hefei\"}}";

       Employee employee = gson.fromJson(json, Employee.class);

        */