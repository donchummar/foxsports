package test.foxsports.foxsdk.network.teamstats.contract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.foxsports.foxsdk.model.StatType;
import test.foxsports.foxsdk.model.PlayerDetailStats;
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
        foxApi.getPlayerList().enqueue(new Callback<List<StatType>>() {
            @Override
            public void onResponse(Call<List<StatType>> call, Response<List<StatType>> response) {
                presenter.onSuccessOrder(response);
            }

            @Override
            public void onFailure(Call<List<StatType>> call, Throwable t) {
                presenter.onFailedOrderUpdate(call);
            }
        });
    }

    @Override
    public void getPlayerStatsDetails(final TeamStatsContract.Presenter presenter, long teamId, long playerId) {
        foxApi.getPlayerDetails(teamId, playerId).enqueue(new Callback<PlayerDetailStats>() {
            @Override
            public void onResponse(Call<PlayerDetailStats> call, Response<PlayerDetailStats> response) {
                presenter.onSuccessOrder(response);
            }

            @Override
            public void onFailure(Call<PlayerDetailStats> call, Throwable t) {
                presenter.onFailedOrderUpdate(call);
            }
        });
    }
}
