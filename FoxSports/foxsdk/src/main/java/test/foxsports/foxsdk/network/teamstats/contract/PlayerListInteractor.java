package test.foxsports.foxsdk.network.teamstats.contract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.foxsports.foxsdk.model.Player;
import test.foxsports.foxsdk.network.NetworkModule;
import test.foxsports.foxsdk.network.api.FoxApi;

/**
 * Created by don.chummar on 15/11/17.
 */

public class PlayerListInteractor implements TeamStatsContract.Interactor {


    private FoxApi foxApi ;

    public PlayerListInteractor() {
       foxApi = NetworkModule.singleton().getNetworkClient();
    }

    @Override
    public void getPlayerList(final TeamStatsContract.Presenter presenter) {
        foxApi.getPlayerList().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                presenter.onSuccessOrder(response);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                presenter.onFailedOrderUpdate(call);
            }
        });
    }
}
