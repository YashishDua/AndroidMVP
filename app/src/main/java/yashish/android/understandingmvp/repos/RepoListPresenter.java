package yashish.android.understandingmvp.repos;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;
import yashish.android.understandingmvp.models.Repo;

public class RepoListPresenter implements OnRepoInteractionFinishedListener {

    IRepoListView view;
    RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view) {
        this.view = view;
        this.interactor =  new RepoListInteractor(this);
    }

    public void loadCommits(String username){
        interactor.loadCommits(username);
    }

    @Override
    public void onNetworkSuccess(List<Repo> list, Response response) {
        view.onReposLoadSucces(list,response);
    }

    @Override
    public void onNetworkFailure(RetrofitError error) {
        view.onReposLoadFailure(error);
    }
}
