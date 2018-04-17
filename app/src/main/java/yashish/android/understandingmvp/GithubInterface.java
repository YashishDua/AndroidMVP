package yashish.android.understandingmvp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import yashish.android.understandingmvp.models.Repo;

public interface GithubInterface {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
}
