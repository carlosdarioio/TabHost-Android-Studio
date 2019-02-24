package com.example.tabhostsubmenu;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        newTab("tab1",R.id.tab1,"Alumnos");
        newTab("tab2",R.id.tab2,"Reprobados");
        newTab("tab3",R.id.tab3,"Aprobados");
        tabHost.setCurrentTab(2);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(),"identificador"+tabId,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"identificador"+tabHost.getCurrentTab(),Toast.LENGTH_LONG).show();

            }
        });

    }

    private Drawable getIcon(int idDraawble){
        return ContextCompat.getDrawable(getApplicationContext(),idDraawble);

    }

    private void newTab(String tag,int idContent,String title){
        TabHost.TabSpec spec = tabHost.newTabSpec(tag);
        spec.setContent(idContent);
        spec.setIndicator(title);
        tabHost.addTab(spec);


    }
}
