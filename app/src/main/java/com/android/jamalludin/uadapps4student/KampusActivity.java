package com.android.jamalludin.uadapps4student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by jamal on 09/05/16.
 */
public class KampusActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Kampus 1",
            "Kampus 2",
            "Kampus 3",
            "Kampus 4",
            "Kampus 5",
    };

    Integer[] imgid={
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus);

        ListKampus adapter=new ListKampus(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];

                Intent i = new Intent(KampusActivity.this, MainActivity.class);
                startActivity(i);



            }
        });


    }

}
