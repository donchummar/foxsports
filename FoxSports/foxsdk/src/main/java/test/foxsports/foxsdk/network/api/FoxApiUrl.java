package test.foxsports.foxsdk.network.api;

/**
 * Created by don.chummar on 15/11/17.
 */

public class FoxApiUrl {
    public static final String BASE_URL ="https://statsapi.foxsports.com.au/3.0/";
    public static final String PLAYER_STATUS_LIST_URL ="api/sports/league/matches/NRL20172101/topplayerstats.json;type=fantasy_points;type=tackles;type=runs;type=run_metres?limit=5&userkey=A00239D3-45F6-4A0A-810C-54A347F144C2";
    public static final String PLAYER_STATUS_DETAIL_URL ="https://statsapi.foxsports.com.au/3.0/api/sports/league/series/1/seasons/115/teams/{team_id}/players/{player_id}/detailedstats.json?&userkey=9024ec15-d791-4bfd-aa3b-5bcf5d36da4f";
}
