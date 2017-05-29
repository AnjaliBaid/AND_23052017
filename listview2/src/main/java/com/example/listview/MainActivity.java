package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();
        //simple();
    }

    private  void simple(){
        List<String> data = new ArrayList<>();
        data.add("SAD");
        data.add("NO EMOTION");
        data.add("HAPPY");
        data.add("NOT SATISFIED");
        data.add("SATISFIED");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        ((ListView)findViewById(R.id.lsview)).setAdapter(adapter);

        ((ListView)findViewById(R.id.lsview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapt = (ArrayAdapter<String>)parent.getAdapter();
                String Lang = adapt.getItem(position);
                ((EditText)findViewById(R.id.ettxt)).setText(Lang);
            }
        });
    }

    private void custom(){
        List<Myitem> item = new ArrayList<>();
        item.add(new Myitem(R.drawable.ic_sentiment_dissatisfied_black_24dp,"SAD"));
        item.add(new Myitem(R.drawable.ic_sentiment_neutral_black_24dp,"NO EMOTION"));
        item.add(new Myitem(R.drawable.ic_sentiment_satisfied_black_24dp,"HAPPY"));
        item.add(new Myitem(R.drawable.ic_sentiment_very_dissatisfied_black_24dp,"NOT SATISFIED"));
        item.add(new Myitem(R.drawable.ic_sentiment_very_satisfied_black_24dp,"SATISFIED"));

        Myadapter myadapter = new Myadapter(this,item);
        ((ListView)findViewById(R.id.lsview)).setAdapter(myadapter);

    }
    public void addEmotion(View view){
        ArrayAdapter<String> adapter =(ArrayAdapter<String>)((ListView)findViewById(R.id.lsview)).getAdapter();
        adapter.add(((EditText)findViewById(R.id.ettxt)).getText().toString());
        adapter.notifyDataSetChanged();
    }
}
