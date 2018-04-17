package yashish.android.understandingmvp.repos;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;
import yashish.android.understandingmvp.models.Repo;

public interface OnRepoInteractionFinishedListener {
    void onNetworkSuccess(List<Repo> list, Response response);
    void onNetworkFailure(RetrofitError error);
}
