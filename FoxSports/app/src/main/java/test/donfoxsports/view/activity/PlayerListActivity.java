package test.donfoxsports.view.activity;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import test.donfoxsports.R;
import test.donfoxsports.adapter.PlayerStatsPagerAdapter;
import test.donfoxsports.viewmodel.PlayerListViewModel;
import test.foxsports.foxsdk.model.ResultWrapper;
import test.foxsports.foxsdk.model.StatType;

/**
 * Created by don.chummar on 15/11/17.
 */
public class PlayerListActivity extends BaseActivity {


    private PlayerListViewModel viewModel;
    private ViewPager viewPager;
    private PlayerStatsPagerAdapter pagerAdapter;
    private TabLayout slidingTab;
    private View contentLyt;
    private View loadingLyt;


    // private ActivityPlayerListBinding dataBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        viewModel = ViewModelProviders.of(this).get(PlayerListViewModel.class);
        //dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_player_list);
        initViews();
        loadData();
    }

    private void initViews() {
        setTitle("Top 5 players");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        slidingTab = (TabLayout) findViewById(R.id.slidingTab);
        contentLyt = findViewById(R.id.contentLyt);
        loadingLyt = findViewById(R.id.loadingLyt);
        pagerAdapter = new PlayerStatsPagerAdapter(getSupportFragmentManager());
        //pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        slidingTab.setupWithViewPager(viewPager);
    }

    private void loadData() {
        viewModel.getPlayerList();
        viewModel.getPlayerListLiveData().observe(this, new Observer<ResultWrapper>() {
            @Override
            public void onChanged(@Nullable ResultWrapper resultWrapper) {
                if (resultWrapper != null) {
                    updateUI((ArrayList<StatType>) resultWrapper.resultArray);
                }
            }
        });
    }

    private void updateUI(ArrayList<StatType> resultArray) {
        if (pagerAdapter != null) {
            contentLyt.setVisibility(View.VISIBLE);
            loadingLyt.setVisibility(View.GONE);
            ArrayList<String> pageTitle = new ArrayList<>();
            for (StatType statType : resultArray) {
                pageTitle.add(statType.getStatType());
            }
            pagerAdapter.updateTitle(pageTitle);
            viewModel.getPlayerListLiveDataForFrag().setValue(resultArray);
        }
    }
}
