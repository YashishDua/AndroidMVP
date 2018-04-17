package yashish.android.understandingmvp.login;

public class LoginPresenter {
    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void attemptLogin(String username, String password){
        if(username.contains(" ")) view.loginFailed(); else view.loginSuccess();
    }
}
