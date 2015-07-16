package ca.st.selenium.applogic;

import ca.st.selenium.model.User;


public interface UserHelper {

        void loginAs(User user);
        void logout();
        boolean isLoggedIn();
        boolean isLoggedInAs(User user);
        boolean isNotLoggedIn();

}

