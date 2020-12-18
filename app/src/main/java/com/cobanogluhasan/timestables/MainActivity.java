package com.cobanogluhasan.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTables(int timesTable) {


        ArrayList<String> timesTablesContent = new ArrayList<String>();

        for(int i=1; i<=25; i++) {

            timesTablesContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTablesContent);
        timesTablesListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = (SeekBar) findViewById(R.id.timesTablesSeekBar);

        timesTablesListView = (ListView) findViewById(R.id.timesTablesListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min=1;
                int timesTable;

                if(progress<min) {

                    timesTable=min;
                    timesTablesSeekBar.setProgress(1);

                } else {

                    timesTable = progress;

                }

                generateTimesTables(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

        generateTimesTables(10);





    }
}
