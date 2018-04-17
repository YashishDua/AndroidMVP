package yashish.android.understandingmvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;
import yashish.android.understandingmvp.R;
import yashish.android.understandingmvp.models.Repo;
import yashish.android.understandingmvp.repos.IRepoListView;
import yashish.android.understandingmvp.repos.RepoListPresenter;
import yashish.android.understandingmvp.repos.adapter.ReposAdapter;

public class RepoListActivity extends AppCompatActivity implements IRepoListView {

    @BindView(R.id.list_view)
    ListView reposListsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        ButterKnife.bind(this);
        String username = getIntent().getStringExtra("Username");
        RepoListPresenter presenter = new RepoListPresenter(this);
        presenter.loadCommits(username);
    }

    @Override
    public void onReposLoadSucces(List<Repo> list, Response response) {
        Toast.makeText(this,"Repos Loaded!",Toast.LENGTH_LONG).show();
        reposListsView.setAdapter(new ReposAdapter(this,list));
    }

    @Override
    public void onReposLoadFailure(RetrofitError error) {
        Toast.makeText(this,"Repos Failed to be loaded!",Toast.LENGTH_LONG).show();
    }
}
