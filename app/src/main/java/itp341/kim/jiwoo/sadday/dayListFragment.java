package itp341.kim.jiwoo.sadday;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class dayListFragment extends Fragment {

    ListView dayListView;

    List<Day> dayList = new ArrayList<Day>();

    ArrayAdapter<Day> adapter;

    Gson gson;

    public dayListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_day_list, container, false);

        String jsonData = ((dayListActivity)getActivity()).getJsonData();
        gson = new Gson();
        Type type = new TypeToken<List<Day>>(){}.getType();
        dayList = gson.fromJson(jsonData, type);
        Log.d("In dayListFragment", "In dayListFragment; dayList size: " + dayList.size());

        adapter = new ArrayAdapter<Day>(getContext(),android.R.layout.simple_list_item_1,dayList);
        dayListView = (ListView) v.findViewById(R.id.dayListView);
        dayListView.setAdapter(adapter);

        dayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // go into the dayDetailActivity
                Intent intent = new Intent(getContext(),dayDetailActivity.class);
                Day day = dayList.get(position);
                int food = day.getFood();
                int sleep = day.getSleep();
                int fun = day.getFun();
                int relationships = day.getRelationships();
                String date = day.getDate();

                intent.putExtra("FOOD", food);
                intent.putExtra("SLEEP", sleep);
                intent.putExtra("FUN", fun);
                intent.putExtra("RELATIONSHIPS", relationships);
                intent.putExtra("DATE", date);

                startActivityForResult(intent, 0);

            }
        });

        return v;
    }

}
