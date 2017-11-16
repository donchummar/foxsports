package test.donfoxsports.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import test.donfoxsports.BR;
import test.donfoxsports.view.activity.PlayerListActivity;
import test.donfoxsports.viewmodel.PlayerListViewModel;
import test.foxsports.foxsdk.model.TopPlayer;
import test.foxsports.foxsdk.utils.GenericViewHolder;

/**
 * Created by don.chummar on 16/11/17.
 */

public class PlayerListViewHolder extends GenericViewHolder {

    private final ViewDataBinding binding;
    private Long teamId;
    private TopPlayer topPlayer;

    public PlayerListViewHolder(View v, final PlayerListViewModel viewModel) {
        super(v);
        binding = DataBindingUtil.bind(v);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.startDetailPage((PlayerListActivity)view.getContext() , teamId, topPlayer);
            }
        });
    }

    public void bind(PlayerListViewHolder holderItem, TopPlayer topPlayer, Long teamId){
        this.teamId = teamId;
        this.topPlayer = topPlayer;
        holderItem.getBinding().setVariable(BR.topPlayer, topPlayer);
        holderItem.getBinding().executePendingBindings();
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
