package restful.api;

import java.util.List;

import restful.model.Author;
import restful.model.CommitResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by CodeKenn on 26/01/2017.
 */

public interface GithubApi {

    @GET("repos/andela-tolotin/locator/contributors")
    Call<List<Author>> getAuthors();

    @GET("repos/andela-tolotin/locator/commits")
    Call<List<CommitResponse>> getCommitByAuthor(
            @Query("author") String author
    );
}
