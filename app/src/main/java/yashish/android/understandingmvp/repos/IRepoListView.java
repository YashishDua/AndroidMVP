package yashish.android.understandingmvp.repos;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;
import yashish.android.understandingmvp.models.Repo;

public interface IRepoListView {
    void onReposLoadSucces(List<Repo> list, Response response);
    void onReposLoadFailure(RetrofitError error);
}
