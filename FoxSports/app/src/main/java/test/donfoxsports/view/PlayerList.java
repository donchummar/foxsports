package test.donfoxsports.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.donfoxsports.R;
import test.foxsports.foxsdk.Player;

public class PlayerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        Player p = new Player();
    }
}
