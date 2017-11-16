
package test.foxsports.foxsdk.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import test.foxsports.foxsdk.R;

public class TeamA{

    @SerializedName("code")
    private String mCode;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("short_name")
    private String mShortName;
    @SerializedName("top_players")
    private List<TopPlayer> mTopPlayers;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public ArrayList<TopPlayer> getTopPlayers() {
        return (ArrayList<TopPlayer>) mTopPlayers;
    }

    public void setTopPlayers(List<TopPlayer> topPlayers) {
        mTopPlayers = topPlayers;
    }
}
