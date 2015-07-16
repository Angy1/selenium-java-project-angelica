package ca.st.selenium.applogic0;

import ca.st.selenium.applogic.ApplicationManager;
import ca.st.selenium.applogic.FilmHelper;
import ca.st.selenium.applogic.UserHelper;

public class ApplicationManager0 implements ApplicationManager {

  UserHelper userHelper = new UserHelper0();
  FilmHelper filmHelper = new FilmHelper0();
 
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public FilmHelper getFilmHelper() {
    return filmHelper;
  }

}

