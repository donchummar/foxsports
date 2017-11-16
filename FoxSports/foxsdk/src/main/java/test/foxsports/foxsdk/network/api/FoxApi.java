package test.foxsports.foxsdk.network.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test.foxsports.foxsdk.model.StatType;
import test.foxsports.foxsdk.model.PlayerDetailStats;

/**
 * Created by don.chummar on 15/11/17.
 */

public interface FoxApi {
    @GET(FoxApiUrl.PLAYER_STATUS_LIST_URL)
    Call<List<StatType>> getPlayerList();


    @GET(FoxApiUrl.PLAYER_STATUS_DETAIL_URL)
    Call<PlayerDetailStats> getPlayerDetails(@Path("team_id") long teamId, @Path("player_id") long playerId);
}
