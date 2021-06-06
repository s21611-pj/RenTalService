package model;


public class Movie {

    private Long ID;
    private String name;
    private String director;
    private MovieCategory category;
    private int year;
    private boolean available = false;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String movieName) {
        this.name = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String movieDirector) {
        this.director = movieDirector;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory movieCategory) {
        this.category = movieCategory;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int movieYear) {
        this.year = movieYear;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        available = available;
    }

    public Movie(String movieName, String director, MovieCategory category, int year, boolean available) {
        this.name = movieName;
        this.director = director;
        this.category = category;
        this.year = year;
        this.available = available;
    }

    public Movie(String movieName, String director, MovieCategory category, int year) {
        this.name = movieName;
        this.director = director;
        this.category = category;
        this.year = year;
    }

    public Movie() {

    }
}
