package by.it.advertproject.command;

import by.it.advertproject.command.impl.*;
import by.it.advertproject.command.impl.account.*;

public enum CommandType {
    TO_SIGN_UP(new ToSignUpCommand()),
    TO_SIGN_IN(new ToSignInCommand()),
    TO_MAIN(new ToMainCommand()),
    TO_EDIT_PROFILE(new ToEditProfile()),
    TO_USER_PROFILE(new ToUserProfileCommand()),
    TO_CREATE_ADVERT(new ToCreateAdvertCommand()),
    UPDATE_PHOTO(new UpdatePhotoCommand()),
    UPDATE_PROFILE_DATA(new UpdateProfileCommand()),
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
