package test.donfoxsports.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.donfoxsports.R;
import test.donfoxsports.viewmodel.PlayerListViewModel;
import test.foxsports.foxsdk.model.ResultWrapper;

/**
 * Created by don.chummar on 15/11/17.
 */
public class PlayerList extends AppCompatActivity {

    private PlayerListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        viewModel = ViewModelProviders.of(this).get(PlayerListViewModel.class);
        viewModel.getPlayerList();
        viewModel.playerLiveData.observe(this, new Observer<ResultWrapper>() {
            @Override
            public void onChanged(@Nullable ResultWrapper resultWrapper) {

            }
        });
    }
}
