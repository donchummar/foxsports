package test.donfoxsports.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import test.donfoxsports.R;
import test.donfoxsports.databinding.ActivityPlayerDetailBinding;
import test.donfoxsports.utils.Constants;
import test.donfoxsports.viewmodel.PlayerDetailViewModel;
import test.foxsports.foxsdk.model.PlayerDetailStats;
import test.foxsports.foxsdk.model.ResultWrapper;
import test.foxsports.foxsdk.model.TopPlayer;
import test.foxsports.foxsdk.utils.CircleTransform;

public class PlayerDetailActivity extends BaseActivity {

    private PlayerDetailViewModel viewModel;
    private long teamId;
    private TopPlayer player;
    private PlayerDetailStats playerDetailStats;
    private ActivityPlayerDetailBinding dataBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_player_detail);
        if (getIntent().hasExtra(Constants.EXTRA_ITEM_TEAM_ID)) {
            teamId = getIntent().getLongExtra(Constants.EXTRA_ITEM_TEAM_ID, -1);
        }
        if (getIntent().hasExtra(Constants.EXTRA_ITEM_PLAYER)) {
            player = (TopPlayer) getIntent().getSerializableExtra(Constants.EXTRA_ITEM_PLAYER);
        }
        initUI();
        viewModel = ViewModelProviders.of(this).get(PlayerDetailViewModel.class);
        viewModel.getPlayerDetailsStats(teamId, player.getId());
        viewModel.playerDetailLiveData.observe(this, new Observer<ResultWrapper>() {
            @Override
            public void onChanged(@Nullable ResultWrapper resultWrapper) {
                if (resultWrapper != null) {
                    playerDetailStats = (PlayerDetailStats) resultWrapper.resultObject;
                    updateUI();
                }
            }
        });
    }

    private void initUI() {
        setSupportActionBar(dataBinding.toolbar);
        dataBinding.toolbarLayout.setExpandedTitleColor(Color.GREEN);
        dataBinding.toolbarLayout.setTitle(player.getFullName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String imageUrl = String.format(Constants.PLAYER_IMAGE_URL, player.getId());
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(ContextCompat.getDrawable(this, R.drawable.dp_default))
                .error(ContextCompat.getDrawable(this, R.drawable.dp_default))
                .transform(new CircleTransform())
                .into(dataBinding.expandedImage);
    }

    private void updateUI() {
        if (playerDetailStats != null) {
            if (playerDetailStats.getLastMatchStats() != null) {
                HashMap matchStatsMap = playerDetailStats.getLastMatchStats();
                Iterator iterator = matchStatsMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator.next();
                    inflateItem(pair);
                }
            }
        }
    }

    // can be display in recyclerview in optimised way
    private void inflateItem(Map.Entry pair) {
        View view = LayoutInflater.from(this).inflate(R.layout.stat_list_item, null);
        ((TextView) view.findViewById(R.id.header)).setText(pair.getKey().toString());
        ((TextView) view.findViewById(R.id.value)).setText(pair.getValue()+"");
        dataBinding.playerStatContainer.addView(view);
    }

    public static void show(Context context, Long teamId, TopPlayer player) {
        Intent intent = new Intent(context, PlayerDetailActivity.class);
        intent.putExtra(Constants.EXTRA_ITEM_TEAM_ID, teamId);
        intent.putExtra(Constants.EXTRA_ITEM_PLAYER, player);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
