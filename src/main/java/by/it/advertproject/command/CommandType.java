package by.it.advertproject.command;

import by.it.advertproject.command.impl.*;

public enum CommandType {
    FORWARD_TO_SIGN_UP(new ForwardToSignUpCommand()),
    FORWARD_TO_SIGN_IN(new ForwardToSignInCommand()),
    FORWARD_TO_USER_PROFILE(new ForwardToUserProfileCommand()),
    SIGN_IN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    SIGN_UP(new SignUpCommand()),
    SET_LANGUAGE_COMMAND(new SetLanguageCommand()),
    CREATE_ADVERT(new CreateAdvertCommand());


    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
