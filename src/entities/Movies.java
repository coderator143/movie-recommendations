package entities;

public class Movies {
    private int movie_id, isUnknown, isAction, isAdventure, isAnimation, isChildren, isComedy, isCrime,
                isDocumentary, isDrama, isFantasy, isFilmNoir, isHorror, isMusical, isMystery, isRomance,
                isSci, isThriller, isWar, isWestern, release_date;
    private String movie_title, video_release_date, imdb_url;

    public Movies(int movie_id, String movie_title, int release_date, String video_release_date,
                  String imdb_url, int isUnknown, int isAction, int isAdventure, int isAnimation, int isChildren,
                  int isComedy, int isCrime, int isDocumentary, int isDrama, int isFantasy, int isFilmNoir,
                  int isHorror, int isMusical, int isMystery, int isRomance, int isSci, int isThriller, int isWar,
                  int isWestern) {
        this.movie_id = movie_id;
        this.isUnknown = isUnknown;
        this.isAction = isAction;
        this.isAdventure = isAdventure;
        this.isAnimation = isAnimation;
        this.isChildren = isChildren;
        this.isComedy = isComedy;
        this.isCrime = isCrime;
        this.isDocumentary = isDocumentary;
        this.isDrama = isDrama;
        this.isFantasy = isFantasy;
        this.isFilmNoir = isFilmNoir;
        this.isHorror = isHorror;
        this.isMusical = isMusical;
        this.isMystery = isMystery;
        this.isRomance = isRomance;
        this.isSci = isSci;
        this.isThriller = isThriller;
        this.isWar = isWar;
        this.isWestern = isWestern;
        this.movie_title = movie_title;
        this.release_date = release_date;
        this.video_release_date = video_release_date;
        this.imdb_url = imdb_url;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getIsUnknown() {
        return isUnknown;
    }

    public void setIsUnknown(int isUnknown) {
        this.isUnknown = isUnknown;
    }

    public int getIsAction() {
        return isAction;
    }

    public void setIsAction(int isAction) {
        this.isAction = isAction;
    }

    public int getIsAdventure() {
        return isAdventure;
    }

    public void setIsAdventure(int isAdventure) {
        this.isAdventure = isAdventure;
    }

    public int getIsAnimation() {
        return isAnimation;
    }

    public void setIsAnimation(int isAnimation) {
        this.isAnimation = isAnimation;
    }

    public int getIsChildren() {
        return isChildren;
    }

    public void setIsChildren(int isChildren) {
        this.isChildren = isChildren;
    }

    public int getIsComedy() {
        return isComedy;
    }

    public void setIsComedy(int isComedy) {
        this.isComedy = isComedy;
    }

    public int getIsCrime() {
        return isCrime;
    }

    public void setIsCrime(int isCrime) {
        this.isCrime = isCrime;
    }

    public int getIsDocumentary() {
        return isDocumentary;
    }

    public void setIsDocumentary(int isDocumentary) {
        this.isDocumentary = isDocumentary;
    }

    public int getIsDrama() {
        return isDrama;
    }

    public void setIsDrama(int isDrama) {
        this.isDrama = isDrama;
    }

    public int getIsFantasy() {
        return isFantasy;
    }

    public void setIsFantasy(int isFantasy) {
        this.isFantasy = isFantasy;
    }

    public int getIsFilmNoir() {
        return isFilmNoir;
    }

    public void setIsFilmNoir(int isFilmNoir) {
        this.isFilmNoir = isFilmNoir;
    }

    public int getIsHorror() {
        return isHorror;
    }

    public void setIsHorror(int isHorror) {
        this.isHorror = isHorror;
    }

    public int getIsMusical() {
        return isMusical;
    }

    public void setIsMusical(int isMusical) {
        this.isMusical = isMusical;
    }

    public int getIsMystery() {
        return isMystery;
    }

    public void setIsMystery(int isMystery) {
        this.isMystery = isMystery;
    }

    public int getIsRomance() {
        return isRomance;
    }

    public void setIsRomance(int isRomance) {
        this.isRomance = isRomance;
    }

    public int getIsSci() {
        return isSci;
    }

    public void setIsSci(int isSci) {
        this.isSci = isSci;
    }

    public int getIsThriller() {
        return isThriller;
    }

    public void setIsThriller(int isThriller) {
        this.isThriller = isThriller;
    }

    public int getIsWar() {
        return isWar;
    }

    public void setIsWar(int isWar) {
        this.isWar = isWar;
    }

    public int getIsWestern() {
        return isWestern;
    }

    public void setIsWestern(int isWestern) {
        this.isWestern = isWestern;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public String getVideo_release_date() {
        return video_release_date;
    }

    public void setVideo_release_date(String video_release_date) {
        this.video_release_date = video_release_date;
    }

    public String getImdb_url() {
        return imdb_url;
    }

    public void setImdb_url(String imdb_url) {
        this.imdb_url = imdb_url;
    }
}
