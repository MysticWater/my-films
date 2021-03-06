package com.mysticwater.myfilms.utils.filmcontentprovider;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

@Database(version = FilmsDatabase.VERSION)
public final class FilmsDatabase {
    public static final int VERSION = 1;

    @Table(FilmColumns.class) public static final String NOW_SHOWING_FILMS = "NowShowingFilms";
    @Table(FilmColumns.class) public static final String UPCOMING_FILMS = "UpcomingFilms";
    @Table(FilmColumns.class) public static final String FAVOURITE_FILMS = "FavouriteFilms";
}
