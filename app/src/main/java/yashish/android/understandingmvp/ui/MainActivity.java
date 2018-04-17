package yashish.android.understandingmvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yashish.android.understandingmvp.R;
import yashish.android.understandingmvp.login.ILoginView;
import yashish.android.understandingmvp.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edit_text_username) EditText editTextUseranme;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.button_submit)
    void submitCredentials(){
        String username = editTextUseranme.getText().toString();
        loginPresenter.attemptLogin(username);
    }

    @Override
    public void loginSuccess(String username) {
        startActivity(new Intent(this,RepoListActivity.class).putExtra("Username",username));
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this,"Login Failed!",Toast.LENGTH_LONG).show();
    }
}
