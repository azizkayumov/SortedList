package uz.pager.sortedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CountryAdapter();
        recyclerView.setAdapter(adapter);

        //now add some UNSORTED countries
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Zimbabwe"));
        countries.add(new Country("Uzbekistan"));
        countries.add(new Country("Japan"));
        countries.add(new Country("Argentina"));
        countries.add(new Country("New Zealand"));
        countries.add(new Country("Malaysia"));

        adapter.addAll(countries);

    }
}
