package by.it.advertproject.command;

import by.it.advertproject.command.impl.*;
import by.it.advertproject.command.impl.account.*;

public enum CommandType {
    TO_SIGN_UP(new ToSignUpCommand()),
    TO_SIGN_IN(new ToSignInCommand()),
    TO_MAIN(new ToMainCommand()),
    TO_EDIT_PROFILE(new ToEditProfileCommand()),
    TO_USER_PROFILE(new ToUserProfileCommand()),
    TO_ADMIN_PROFILE(new ToAdminProfileCommand()),
    TO_CREATE_ADVERT(new ToCreateAdvertCommand()),
    TO_ERROR(new ToErrorPageCommand()),
    UPDATE_PHOTO(new UpdatePhotoCommand()),
    UPDATE_PROFILE_DATA(new UpdateProfileCommand()),
    DELETE_USER(new DeleteUserCommand()),
    SIGN_IN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    SIGN_UP(new SignUpCommand()),
    SET_LANG(new SetLanguageCommand()),
    CREATE_ADVERT(new CreateAdvertCommand());

    CommandType(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
