package test.donfoxsports.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import retrofit2.Response;
import test.foxsports.foxsdk.model.PlayerDetailStats;
import test.foxsports.foxsdk.model.ResultWrapper;
import test.foxsports.foxsdk.network.teamstats.contract.PlayerListInteractor;
import test.foxsports.foxsdk.network.teamstats.contract.TeamStatsContract;

/**
 * Created by don.chummar on 16/11/17.
 */

public class PlayerDetailViewModel extends ViewModel {

    private PlayerListInteractor interactor;
    private PlayerDetailStats playerDetailStats;

    public MutableLiveData<ResultWrapper> playerDetailLiveData;

    public PlayerDetailViewModel() {
        super();
        playerDetailLiveData =  new MutableLiveData<>();
        interactor = new PlayerListInteractor();
    }
    public void getPlayerDetailsStats(long teamId, long playerId) {
        interactor.getPlayerStatsDetails(new TeamStatsContract.Presenter() {

            @Override
            public void onSuccessOrder(Object result) {
                Response response = (Response) result;
                if (response.code() == 200) {
                    playerDetailStats = (PlayerDetailStats) response.body();
                    playerDetailLiveData.setValue(new ResultWrapper(null, playerDetailStats, response.code(), null));
                }
            }

            @Override
            public void onFailedOrderUpdate(Object result) {
                Response response = (Response) result;
                playerDetailLiveData.setValue(new ResultWrapper(null, null, response.code(), response.message()));
            }
        }, teamId, playerId);
    }
}
