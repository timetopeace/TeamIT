package anton.ttp.myapplication.presenter.contract

interface LoginContract {
    interface View {
        fun goToMain()
        fun goToRegister()
    }

    interface Presenter{
        fun onLoginClick(login: String, password: String)
        fun onRegisterCkick()
    }
}
