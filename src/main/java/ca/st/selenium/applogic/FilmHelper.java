package ca.st.selenium.applogic;

import java.util.List;

import ca.st.selenium.model.Film;

public interface FilmHelper {

        void create(Film film);
        void delete(Film film);
        List<Film> search(String title);

}

