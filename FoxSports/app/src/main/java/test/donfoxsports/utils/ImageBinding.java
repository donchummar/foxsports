package test.donfoxsports.utils;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import test.donfoxsports.R;
import test.foxsports.foxsdk.utils.CircleTransform;

/**
 * Created by don.chummar on 16/11/17.
 */

public class ImageBinding {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, Long playerId) {
        String imageUrl = String.format(Constants.PLAYER_IMAGE_URL, playerId);
        Picasso.with(imageView.getContext())
                .load(imageUrl)
                .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dp_default))
                .error(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dp_default))
                .transform(new CircleTransform())
                .into(imageView);
    }
}
