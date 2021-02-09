package com.example.myapplication;
import android.widget.Toast;

import android.content.Context;
import android.os.Bundle;
import android.app.AlertDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import androidx.fragment.app.Fragment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import  java.io.OutputStreamWriter;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public page5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page5.
     */
    // TODO: Rename and change types and number of parameters
    public static page5 newInstance(String param1, String param2) {
        page5 fragment = new page5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_page5, container, false);
        Button button = (Button)rootView.findViewById(R.id.savebutton);
        EditText tekstsave  = (EditText) rootView.findViewById(R.id.savetext);

        button.setOnClickListener(new View.OnClickListener() {
        Context context;
            @Override
            public void onClick(View v) {
                String name = tekstsave.getText().toString();
                FileOutputStream fos = null;

                try {

                    fos = rootView.getContext().openFileOutput("Tutorial File.txt", Context.MODE_PRIVATE);
                    fos.write(name.getBytes());
                    fos.close();
                    Toast.makeText(getActivity(), "Text Saved", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return rootView;
    }
}