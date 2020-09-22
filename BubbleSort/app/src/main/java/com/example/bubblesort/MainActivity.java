package com.example.bubblesort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    TextView inputArray;
    TextView outputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        inputArray = (TextView)findViewById(R.id.inputArray);
        outputNumber = (TextView)findViewById(R.id.outputNumber);
    }

    public void sortButton(View view){
        //get the text from the input field
        String[] enteredNumber = inputNumber.getText().toString().split(" ");
        String output = "";

        int[] numberList = new int[enteredNumber.length];

        //convert the string to int array
        for(int i =0; i<enteredNumber.length; i++){
            numberList[i]= Integer.parseInt(enteredNumber[i]);
        }
        output = printArray(numberList);
        inputArray.setText("Input Array: " + output);
        bubbleSort(numberList, numberList.length);
    }

    private void bubbleSort (int[] input, int n){
        int i, j, temp;
        boolean swapped;
        StringBuilder output = new StringBuilder();

        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for(j=n-1; j >0; j--){
                if(input[j-1] > input[j]){
                    //swap elements
                    temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                    swapped = true;
                }
            }
             // IF no two elements were
             // swapped by inner loop, then break
            if (swapped == false)
                break;
            output.append(printArray(input) + "\n");
            outputNumber.setText(output);
        }
    }

    String printArray(int arr[])
    {
        int n = arr.length;
        StringBuilder output = new StringBuilder();
        for (int i=0; i<n; ++i)
            output.append(arr[i] + " ");

        return output.toString();
    }
}