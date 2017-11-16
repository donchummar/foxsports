package test.foxsports.foxsdk.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewHolderItemEmpty extends GenericViewHolder {
    public ViewHolderItemEmpty(View v) {
	super(v);
    }
    
    public void bind(RecyclerView.ViewHolder holder, int position, Object dataObject) {
    }

}
