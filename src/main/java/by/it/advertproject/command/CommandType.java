package by.it.advertproject.command;

import by.it.advertproject.command.impl.*;

public enum CommandType {
    TO_SIGN_UP(new ToSignUpCommand()),
    TO_SIGN_IN(new ToSignInCommand()),
    TO_INDEX(new ToIndexCommand()),
    TO_USER_PROFILE(new ToUserProfileCommand()),
    TO_CREATE_ADVERT(new ToCreateAdvertCommand()),
    SIGN_IN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    SIGN_UP(new SignUpCommand()),
    SET_LANG(new SetLanguageCommand()),
    CREATE_ADVERT(new CreateAdvertCommand());


    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
