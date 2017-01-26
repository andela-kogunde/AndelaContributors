package restful.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by CodeKenn on 26/01/2017.
 */

public class Client {
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private List<String> keys;

    public Client() {
        okHttpClient = new OkHttpClient();
        keys = new ArrayList<>();
    }

    public Client getClient(String baseUrl) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return this;
    }

    public Client addAuthorization(String key, Interceptor interceptor) {
        if (keys.contains(key)) {
            throw new RuntimeException("Key already added");
        }

        okHttpClient.interceptors().add(interceptor);

        return this;
    }

    public <S> S createService(Class<S> sClass) {
        return retrofit.create(sClass);
    }
}
