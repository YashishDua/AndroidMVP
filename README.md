
# Android - Model View Presenter (MVP)
### Show some :heart: and star the repo to support the project
[![GitHub stars](https://img.shields.io/github/stars/yashishdua/AndroidMVP.svg?style=social&label=Star)](https://github.com/YashishDua/AndroidMVP) [![GitHub forks](https://img.shields.io/github/forks/yashishdua/AndroidMVP.svg?style=social&label=Fork)](https://github.com/yashishdua/AndroidMVP/fork) [![GitHub followers](https://img.shields.io/github/followers/yashishdua.svg?style=social&label=Follow)](https://github.com/yashishdua/AndroidMVP)

### Screenshots (Just to know what is the flow of application) 

<img src = "./img/Screenshot_Login_UI.png" height = "400"/> <img src = "./img/Screenshot_Login_Validation.png" height = "400"/> <img src = "./img/Screenshot_Repos_Loaded.png" height = "400"/>

### What is MVP?
MVP stands for Model View Presenter and is one of the most widely used architecture while developing android applications.
MVP design pattern is a set of guidelines that if followed, decouples the code for reusability and testability. It divides the application components based on its role, called separation of concern.

This architecture creates three layers:

+ Model
+ View
+ Controller

Model is your database or data provider, View is the user interface, and Controller mediates View access to Model nad vice-versa.

<img src = "./img/MVP.png" />

### View Interface ( Implemented by First Activity | ScreenShot 1 )
```Java
public interface ILoginView {
    void loginSuccess(String username);
    void loginFailed();
}
```

### Presenter Layer ( Of First Activtiy in this repository | ScreenShot 1 )
```Java
public class LoginPresenter {
    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void attemptLogin(String username){
        if(username.contains(" ") || username.trim().compareTo("") == 0)
            view.loginFailed();
        else view.loginSuccess(username);
    }
}
```

### First Activity using LoginPresenter and implementing ILoginView
```Java
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
```
