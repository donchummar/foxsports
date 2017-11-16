package test.donfoxsports.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import test.donfoxsports.adapter.PlayerStatsPagerAdapter;
import test.donfoxsports.view.activity.PlayerDetailActivity;
import test.donfoxsports.view.activity.PlayerListActivity;
import test.donfoxsports.view.fragment.PlayerStatsFragment;
import test.foxsports.foxsdk.model.StatType;
import test.foxsports.foxsdk.model.ResultWrapper;
import test.foxsports.foxsdk.model.TopPlayer;
import test.foxsports.foxsdk.network.teamstats.contract.PlayerListInteractor;
import test.foxsports.foxsdk.network.teamstats.contract.TeamStatsContract;

/**
 * Created by don.chummar on 15/11/17.
 */

public class PlayerListViewModel extends ViewModel {



    private MutableLiveData<List<StatType>> playerListLiveDataForFrag;

    private MutableLiveData<ResultWrapper> playerListLiveData;

    private PlayerListInteractor interactor;


    public PlayerListViewModel() {
        super();
        playerListLiveData =  new MutableLiveData<>();
        playerListLiveDataForFrag = new MutableLiveData<>();
        interactor = new PlayerListInteractor();
    }

    public void getPlayerList() {
        interactor.getPlayerList(new TeamStatsContract.Presenter() {

            @Override
            public void onSuccessOrder(Object result) {
                Response response = (Response) result;
                if (response.code() == 200) {
                    ArrayList<StatType> statTypes = (ArrayList<StatType>) response.body();
                    playerListLiveData.setValue(new ResultWrapper(statTypes, null, response.code(), null));
                }
            }

            @Override
            public void onFailedOrderUpdate(Object result) {
                Response response = (Response) result;
                playerListLiveData.setValue(new ResultWrapper(null, null,response.code(), response.message()));
            }
        });
    }

    public MutableLiveData<ResultWrapper> getPlayerListLiveData() {
        return playerListLiveData;
    }

    public MutableLiveData<List<StatType>> getPlayerListLiveDataForFrag() {
        return playerListLiveDataForFrag;
    }

    public void startDetailPage(Context context, Long teamId, TopPlayer player) {
        PlayerDetailActivity.show(context, teamId, player);
    }
}
