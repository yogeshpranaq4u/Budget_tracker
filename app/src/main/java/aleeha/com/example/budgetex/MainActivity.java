package aleeha.com.example.budgetex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout dash;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bottomClick();
    }

    private void init() {
        dash = findViewById(R.id.dashLayout);
        container = findViewById(R.id.fragmentcontainer);
    }

    private void openFragment(Fragment fragment) {
        dash.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void bottomClick() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        dash.setVisibility(View.VISIBLE);
                        container.setVisibility(View.GONE);
                        break;
                    case R.id.transaction:
                        openFragment(new TransactionFragment());
                        break;
                    case R.id.statistics:
                        openFragment(new StatsFragment());

                        break;
                    case R.id.profile:
                        openFragment(new ProfileFragment());
                        break;
                }
                return true;
            }
        });
    }
}