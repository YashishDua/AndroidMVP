package yashish.android.understandingmvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yashish.android.understandingmvp.R;
import yashish.android.understandingmvp.login.ILoginView;
import yashish.android.understandingmvp.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edit_text_username) EditText editTextUseranme;
    @BindView(R.id.edit_text_password) EditText editTextpassword;
    @BindView(R.id.button_submit) Button buttonLogin;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.button_submit)
    void submitCredentials(View view){
        String username = editTextUseranme.getText().toString();
        String password = editTextpassword.getText().toString();

        loginPresenter.attemptLogin(username,password);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed() {

    }
}
