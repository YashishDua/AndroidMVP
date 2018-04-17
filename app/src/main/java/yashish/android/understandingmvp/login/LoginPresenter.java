package yashish.android.understandingmvp.login;

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
