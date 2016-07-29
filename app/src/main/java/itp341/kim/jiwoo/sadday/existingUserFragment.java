package itp341.kim.jiwoo.sadday;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class existingUserFragment extends Fragment {

    private Button yourDayButton;
    private Button yourHistoryButton;


    public existingUserFragment() {
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
        View v = inflater.inflate(R.layout.fragment_existing_user, container, false);

        yourDayButton = (Button) v.findViewById(R.id.yourDayButton);
        yourHistoryButton = (Button) v.findViewById(R.id.yourHistoryButton);

        yourDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),yourDayActivity.class);
                getActivity().startActivityForResult(intent,0);
            }
        });

        yourHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonDayList = ((intro)getActivity()).getListData();
                Log.d("clicking history button","list received; converted to string:" + jsonDayList);

                Intent intent = new Intent(getActivity(),dayListActivity.class);
                intent.putExtra("DAYLIST",jsonDayList);
                getActivity().startActivityForResult(intent,1);
            }
        });

        return v;
    }

}
