package test.foxsports.foxsdk.network.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import test.foxsports.foxsdk.model.Player;

/**
 * Created by don.chummar on 15/11/17.
 */

public interface FoxApi {
    @GET(FoxApiUrl.PLAYER_STATUS_URL)
    Call<List<Player>> getPlayerList();
}
