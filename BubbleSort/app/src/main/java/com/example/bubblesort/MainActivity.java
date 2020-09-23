package com.example.bubblesort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void sortButton(View view) {
        //get the text from the input field
        String[] enteredNumber = inputNumber.getText().toString().split(" ");
        String output = "";
        // Check for validations
        // If invalid then show toast message
        Boolean validationFlag = checkValidation(enteredNumber);

        if(validationFlag==true)
        {
            // Convert the input array to integers
            int[] numberList = convertToIntArray(enteredNumber);
            output = printArray(numberList);

            if(numberList.length > 2 && numberList.length < 9){
                // Set the input array text
                inputArray.setText("Input Array: " + output);

                bubbleSort(numberList, numberList.length);
            }
            else{
                toastMessage("Please enter minimum 3 numbers and max 8 numbers between 0 - 9 separated by one space");
            }
        }
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

    void toastMessage(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    int[] convertToIntArray(String[] arr){
        int[] numberList = new int[arr.length];

        //convert the string to int array
        for (int i = 0; i < arr.length; i++) {
            try {
                numberList[i] = Integer.parseInt(arr[i]);
            } catch (Exception e) {
                toastMessage("Error converting to integer value");
            }
        }
        return numberList;
    }

    Boolean checkValidation(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            try {
                int num = Integer.parseInt(arr[i]);
                if ( num < 0 || num > 9){
                    toastMessage("Number entered is less than 0 or greater than 9. Please enter numbers between 0 - 9");
                    return false;
                }
            } catch (Exception e) {
                toastMessage("Please enter numbers between 0 - 9 separated by one space");
                return false;
            }
        }
        return true;
    }

}