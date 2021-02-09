package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page3 extends Fragment {
    static String generateKey(String str, String key)
    {
        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    // This function returns the encrypted text
// generated with the help of the key
    static String cipherText(String str, String key)
    {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++)
        {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text
// and returns the original text
    static String originalText(String cipher_text, String key)
    {
        String orig_text="";

        for (int i = 0 ; i < cipher_text.length() &&
                i < key.length(); i++)
        {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public page3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page3.
     */
    // TODO: Rename and change types and number of parameters
    public static page3 newInstance(String param1, String param2) {
        page3 fragment = new page3();
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
        Button btnVigenere;
        TextView rijesenjevigenere;
        EditText tekstvigenere;
        EditText key;
        View rootView=  inflater.inflate(R.layout.fragment_page3, container, false);
        btnVigenere = (Button) rootView.findViewById(R.id.buttonvigenere);
        tekstvigenere =(EditText) rootView.findViewById(R.id.tekstvigenere);
        rijesenjevigenere = (TextView) rootView.findViewById(R.id.rijesenjevigenere);
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.grupavigenere);
        key =(EditText) rootView.findViewById(R.id.key);
        // Inflate the layout for this fragment
        btnVigenere.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = tekstvigenere.getText().toString();
            String kljuc = key.getText().toString();

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // checkedId is the RadioButton selected
                    String keyword;
                    switch(checkedId) {
                        case R.id.encrypt2:
                            keyword = generateKey(name, kljuc);
                            rijesenjevigenere.setText(cipherText(name,keyword));
                            break;
                        case R.id.decrypt2:
                            keyword = generateKey(name, kljuc);
                            rijesenjevigenere.setText( originalText(name,keyword));
                            break;
                    }
                }
            });
        }
    });
        return rootView;

    }
}