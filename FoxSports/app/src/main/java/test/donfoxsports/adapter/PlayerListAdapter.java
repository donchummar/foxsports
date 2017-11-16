package test.donfoxsports.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import test.donfoxsports.R;
import test.donfoxsports.viewholder.PlayerListViewHolder;
import test.donfoxsports.viewmodel.PlayerListViewModel;
import test.foxsports.foxsdk.model.TopPlayer;
import test.foxsports.foxsdk.utils.ViewHolderItemEmpty;

/**
 * Created by don.chummar on 16/11/17.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListViewHolder> {

    private final PlayerListViewModel viewModel;

    private ArrayList<TopPlayer> mItems;
    private Long teamAId;
    private Long teamBId;

    public PlayerListAdapter(PlayerListViewModel viewModel) {
        mItems = new ArrayList<>();
        this.viewModel = viewModel;
    }

    @Override
    public PlayerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_item, parent, false);
        return new PlayerListViewHolder(parentView, viewModel);
    }

    @Override
    public void onBindViewHolder(PlayerListViewHolder holder, int position) {
        final TopPlayer topPlayer = (TopPlayer) mItems.get(position);
        PlayerListViewHolder holderItem = (PlayerListViewHolder) holder;
        Long teamId;
        if (position % 2 == 0){
            teamId = teamAId;
        }else {
            teamId = teamBId;
        }
        holderItem.bind(holderItem, topPlayer, teamId);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void updateData(ArrayList<TopPlayer> list, Long teamAId, Long teamBId) {
        mItems = list;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        notifyDataSetChanged();
    }
}
