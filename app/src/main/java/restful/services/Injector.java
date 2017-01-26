package restful.services;

import restful.api.GithubApi;
import restful.model.AccessToken;
import restful.util.Constants;

/**
 * Created by CodeKenn on 26/01/2017.
 */

public class Injector {
    public static GithubApi injectGithubApi(AccessToken accessToken) {
        return new Client()
                .getClient(Constants.BASE_URL.getValue())
                .addAuthorization(Authorization.KEY, new Authorization(accessToken))
                .createService(GithubApi.class);
    }
}
