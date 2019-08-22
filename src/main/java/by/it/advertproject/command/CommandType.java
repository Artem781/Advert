package by.it.advertproject.command;

import by.it.advertproject.command.impl.*;

public enum CommandType {
    FORWARD_TO_SIGN_UP(new ForwardToSignUpCommand()),
    FORWARD_TO_SIGN_IN(new ForwardToSignInCommand()),
    SIGN_IN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    SIGN_UP(new SignUpCommand()),
    CREATE_ADVERT(new CreateAdvertCommand());

    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
