package org.flightofstairs.adirstat;

import android.os.Bundle;
import android.os.Environment;
import com.google.inject.Inject;
import com.squareup.otto.Bus;
import org.flightofstairs.adirstat.model.Scanner;
import org.flightofstairs.adirstat.view.TreeFragment;
import roboguice.activity.RoboActivity;

import java.io.File;

public class Main extends RoboActivity {
    @Inject Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new TreeFragment())
                    .commit();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        new Scanner(bus).execute(new File(Environment.getExternalStorageDirectory(), "adirstat-test-files"));
    }
}
