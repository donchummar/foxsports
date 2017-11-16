
package test.foxsports.foxsdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerDetailStats extends Model {

    @SerializedName("career_stats")
    private CareerStats mCareerStats;
    @SerializedName("date_of_birth")
    private String mDateOfBirth;
    @SerializedName("full_name")
    private String mFullName;
    @SerializedName("height_cm")
    private Long mHeightCm;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_match_id")
    private String mLastMatchId;
    @SerializedName("last_match_stats")
    private HashMap mLastMatchStats;
    @SerializedName("other_names")
    private String mOtherNames;
    @SerializedName("position")
    private String mPosition;
    @SerializedName("series_season_stats")
    private SeriesSeasonStats mSeriesSeasonStats;
    @SerializedName("short_name")
    private String mShortName;
    @SerializedName("surname")
    private String mSurname;
    @SerializedName("weight_kg")
    private Long mWeightKg;

    public CareerStats getCareerStats() {
        return mCareerStats;
    }

    public void setCareerStats(CareerStats careerStats) {
        mCareerStats = careerStats;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Long getHeightCm() {
        return mHeightCm;
    }

    public void setHeightCm(Long heightCm) {
        mHeightCm = heightCm;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastMatchId() {
        return mLastMatchId;
    }

    public void setLastMatchId(String lastMatchId) {
        mLastMatchId = lastMatchId;
    }

    public HashMap getLastMatchStats() {
        return (HashMap) mLastMatchStats;
    }

    public void setLastMatchStats(LinkedHashMap lastMatchStats) {
        mLastMatchStats = lastMatchStats;
    }

    public String getOtherNames() {
        return mOtherNames;
    }

    public void setOtherNames(String otherNames) {
        mOtherNames = otherNames;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public SeriesSeasonStats getSeriesSeasonStats() {
        return mSeriesSeasonStats;
    }

    public void setSeriesSeasonStats(SeriesSeasonStats seriesSeasonStats) {
        mSeriesSeasonStats = seriesSeasonStats;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public Long getWeightKg() {
        return mWeightKg;
    }

    public void setWeightKg(Long weightKg) {
        mWeightKg = weightKg;
    }
}
