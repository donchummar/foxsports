
package test.foxsports.foxsdk.model;

import com.google.gson.annotations.SerializedName;


public class CareerStats {

    @SerializedName("games")
    private Long mGames;
    @SerializedName("points")
    private Long mPoints;
    @SerializedName("tries")
    private Long mTries;
    @SerializedName("win_percentage")
    private Double mWinPercentage;

    public Long getGames() {
        return mGames;
    }

    public void setGames(Long games) {
        mGames = games;
    }

    public Long getPoints() {
        return mPoints;
    }

    public void setPoints(Long points) {
        mPoints = points;
    }

    public Long getTries() {
        return mTries;
    }

    public void setTries(Long tries) {
        mTries = tries;
    }

    public Double getWinPercentage() {
        return mWinPercentage;
    }

    public void setWinPercentage(Double winPercentage) {
        mWinPercentage = winPercentage;
    }

}
