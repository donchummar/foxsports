
package test.foxsports.foxsdk.model;

import com.google.gson.annotations.SerializedName;

public class TopPlayer  extends Model{

    @SerializedName("full_name")
    private String mFullName;
    @SerializedName("id")
    private Long mId;
    @SerializedName("jumper_number")
    private Long mJumperNumber;
    @SerializedName("position")
    private String mPosition;
    @SerializedName("short_name")
    private String mShortName;
    @SerializedName("stat_value")
    private Long mStatValue;

    private int layoutId;

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getJumperNumber() {
        return mJumperNumber;
    }

    public void setJumperNumber(Long jumperNumber) {
        mJumperNumber = jumperNumber;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public Long getStatValue() {
        return mStatValue;
    }

    public void setStatValue(Long statValue) {
        mStatValue = statValue;
    }

}
