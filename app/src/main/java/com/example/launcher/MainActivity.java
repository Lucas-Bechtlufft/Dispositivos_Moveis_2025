package com.example.launcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AppAdapter adapter;
    List<AppModel> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerApps);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        loadApps();
        adapter = new AppAdapter(this, appList);
        recyclerView.setAdapter(adapter);

        setupDock();
    }

    private void loadApps() {
        appList = new ArrayList<>();
        PackageManager pm = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        Collections.sort(resolveInfos, new ResolveInfo.DisplayNameComparator(pm));

        for (ResolveInfo info : resolveInfos) {
            String label = info.loadLabel(pm).toString();
            String packageName = info.activityInfo.packageName;
            Drawable icon = info.loadIcon(pm);
            appList.add(new AppModel(label, packageName, icon));
        }
    }

    private void setupDock() {
        ImageButton app1 = findViewById(R.id.app1);
        ImageButton app2 = findViewById(R.id.app2);
        ImageButton app3 = findViewById(R.id.app3);
        ImageButton app4 = findViewById(R.id.app4);

        // Exemplo: YouTube, Chrome, WhatsApp, Configurações
        setDockApp(app1, "com.google.android.youtube");
        setDockApp(app2, "com.android.chrome");
        setDockApp(app3, "com.whatsapp");
        setDockApp(app4, "com.android.settings");
    }

    private void setDockApp(ImageButton button, String packageName) {
        try {
            Drawable icon = getPackageManager().getApplicationIcon(packageName);
            button.setImageDrawable(icon);
            button.setOnClickListener(v -> {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
