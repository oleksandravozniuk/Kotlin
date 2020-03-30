package com.example.lab2java;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;



public class OptionsFragment extends Fragment  {
    private OnFragmentInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_options, container, false);
        Button button = (Button) view.findViewById(R.id.update_button);

        final RadioGroup radio = view.findViewById(R.id.radio_group);
        final RadioGroup radio2 = view.findViewById(R.id.radio_group2);

        final EditText editText = view.findViewById(R.id.editText);

        // задаем обработчик кнопки
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radio.getCheckedRadioButtonId();
                int id2 = radio2.getCheckedRadioButtonId();

                String result;


                if (id!=-1 && id2!=-1 && !editText.getText().toString().isEmpty()){ // If all radio button checked from radio group
                    RadioButton radioButton = radio.findViewById(id);
                    RadioButton radioButton2 = radio2.findViewById(id2);

                    result = "Your order is completed successfully!\n"+editText.getText().toString()+" "+ radioButton.getText().toString()+" " + radioButton2.getText().toString();



                }else{

                    result="Your order is not completed successfully \n Please, fill in all fields";
                }
                updateDetail(result);
            }
        });

        Button buttonClear = view.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                editText.getText().clear();
                radio.clearCheck();
                radio2.clearCheck();
                updateDetail("");
            }

        });
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public void updateDetail(String text) {
        listener.onFragmentInteraction(text);

    }

}
