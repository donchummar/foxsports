package test.donfoxsports.view.fragment;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.donfoxsports.R;
import test.donfoxsports.adapter.PlayerListAdapter;
import test.donfoxsports.databinding.FragmentPlayerStatsBinding;
import test.donfoxsports.viewmodel.PlayerListViewModel;
import test.foxsports.foxsdk.model.StatType;
import test.foxsports.foxsdk.model.TopPlayer;


public class PlayerStatsFragment extends LifecycleFragment {


    private static final String ARG_PARAM1 = "param1";


    //private FragmentPlayerStatsBinding binding;
    private PlayerListViewModel viewModel;
    private PlayerListAdapter mAdapter;
    private GridLayoutManager layoutManager;
    private View view;
    private RecyclerView playerListView;
    private int position;

    public PlayerStatsFragment() {

    }

    public static PlayerStatsFragment newInstance(int position) {
        PlayerStatsFragment fragment = new PlayerStatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player_stats, container, false);

        view = inflater.inflate(R.layout.fragment_player_stats, container, false);
        playerListView = (RecyclerView) view.findViewById(R.id.playerListView);

        playerListView.setHasFixedSize(false);

        viewModel = ViewModelProviders.of(getActivity()).get(PlayerListViewModel.class);
        layoutManager = new GridLayoutManager(playerListView.getContext(), 2);
        playerListView.setLayoutManager(layoutManager);
        //binding.playerListView.addItemDecoration(new RecyclerViewItemDecoration());

        mAdapter = new PlayerListAdapter(viewModel);
        playerListView.setAdapter(mAdapter);
        viewModel.getPlayerListLiveDataForFrag().observe(this, new Observer<List<StatType>>() {
            @Override
            public void onChanged(@Nullable List<StatType> statTypes) {
                if (statTypes != null && statTypes.size() > 0) {
                    updateAdapter((ArrayList<StatType>) statTypes);
                }
            }
        });
        if (viewModel.getPlayerListLiveDataForFrag() != null) {
            updateAdapter((ArrayList<StatType>) viewModel.getPlayerListLiveDataForFrag().getValue());
        }
        return view;
    }

    private void updateAdapter(ArrayList<StatType> statTypes) {
        if (statTypes != null) {
            StatType statTypeDetails = statTypes.get(position);
            if (statTypeDetails != null) {
                mAdapter.updateData(getTopPlayerList(statTypeDetails), statTypeDetails.getTeamA().getId(), statTypeDetails.getTeamB().getId());
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    private ArrayList<TopPlayer> getTopPlayerList(StatType statTypeDetails) {
        ArrayList<TopPlayer> topPlayerList = new ArrayList<>();
        if (statTypeDetails != null){
            for(int i=0; i < statTypeDetails.getTeamA().getTopPlayers().size(); i++){
                topPlayerList.add(statTypeDetails.getTeamA().getTopPlayers().get(i));
                topPlayerList.add(statTypeDetails.getTeamB().getTopPlayers().get(i));
            }
        }
        return topPlayerList;
    }

}
