package test.foxsports.foxsdk.utils;


import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericViewHolder extends RecyclerView.ViewHolder {
    public View mView;
    public GenericViewHolder(View v) {
	super(v);
	this.mView = v;
    }
}