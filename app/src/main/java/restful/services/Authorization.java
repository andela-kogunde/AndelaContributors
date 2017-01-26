package restful.services;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URI;

import restful.model.AccessToken;

/**
 * Created by CodeKenn on 26/01/2017.
 */

public class Authorization implements Interceptor {
    public static final String KEY = "Github";

    private AccessToken accessToken;

    public Authorization(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Accept", "application/vnd.github.v3+json")
                .addHeader("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken())
                .method(original.method(), original.body());

        Request request = requestBuilder.build();

        URI uri = request.uri();
        Log.d("KEY", "intercept: " + uri.toString());

        return chain.proceed(request);
    }
}
