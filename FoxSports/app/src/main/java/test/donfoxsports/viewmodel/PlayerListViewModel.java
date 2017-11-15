package test.donfoxsports.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import test.foxsports.foxsdk.model.Player;
import test.foxsports.foxsdk.model.ResultWrapper;
import test.foxsports.foxsdk.network.teamstats.contract.PlayerListInteractor;
import test.foxsports.foxsdk.network.teamstats.contract.TeamStatsContract;

/**
 * Created by don.chummar on 15/11/17.
 */

public class PlayerListViewModel extends AndroidViewModel {

    private List<Player> playerList;
    public MutableLiveData<ResultWrapper> playerLiveData;

    private PlayerListInteractor interactor;

    public PlayerListViewModel(Application application) {
        super(application);
        playerLiveData =  new MutableLiveData<>();
        interactor = new PlayerListInteractor();
    }

    public void getPlayerList() {
        interactor.getPlayerList(new TeamStatsContract.Presenter() {

            @Override
            public void onSuccessOrder(Object result) {
                Response response = (Response) result;
                if (response.code() == 200) {
                    playerList = (ArrayList<Player>) response.body();
                    playerLiveData.setValue(new ResultWrapper(playerList, response.code(), null));
                }
            }

            @Override
            public void onFailedOrderUpdate(Object result) {
                Response response = (Response) result;
                playerLiveData.setValue(new ResultWrapper(null,response.code(), response.message()));
            }
        });
    }
}
