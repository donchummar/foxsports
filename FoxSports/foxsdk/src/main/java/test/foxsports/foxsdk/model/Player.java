
package test.foxsports.foxsdk.model;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("match_id")
    private String mMatchId;
    @SerializedName("stat_type")
    private String mStatType;
    @SerializedName("team_A")
    private TeamA mTeamA;
    @SerializedName("team_B")
    private TeamB mTeamB;

    public String getMatchId() {
        return mMatchId;
    }

    public void setMatchId(String matchId) {
        mMatchId = matchId;
    }

    public String getStatType() {
        return mStatType;
    }

    public void setStatType(String statType) {
        mStatType = statType;
    }

    public TeamA getTeamA() {
        return mTeamA;
    }

    public void setTeamA(TeamA teamA) {
        mTeamA = teamA;
    }

    public TeamB getTeamB() {
        return mTeamB;
    }

    public void setTeamB(TeamB teamB) {
        mTeamB = teamB;
    }

}
