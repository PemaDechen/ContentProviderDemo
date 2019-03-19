package com.example.pema.contentproviderdemo;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button single, multiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        single = findViewById(R.id.btn1);
        multiple = findViewById(R.id.btn2);
        single.setOnClickListener(this);
        multiple.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String queryUri = ContractDemo.Content_Uri.toString();
        String[] projection = new String[]{ContractDemo.Content_Path};
        String selectionClause;
        String selectionArgs[];
        String sortOrder = null;
        switch (view.getId()) {
            case R.id.btn2:
                textView.setText(" ");
                selectionClause = null;
                selectionArgs = null;
                break;
            case R.id.btn1:
                textView.setText(" ");
                selectionClause = ContractDemo.Id + " = ?";
                selectionArgs = new String[]{"0"};

                break;
            default:
                selectionClause = null;
                selectionArgs = null;
        }
        Cursor cursor = getContentResolver().query(Uri.parse(queryUri), projection, selectionClause, selectionArgs, sortOrder);
        if(cursor!=null)

        {
            while (cursor.moveToNext())
         {
            int index = cursor.getColumnIndex(projection[0]);
            String word = cursor.getString(index);
            textView.append(word + "\n");
        }} else {

            textView.append("No data" + "\n");


        }//If there is no internal storage we use matrix cursor
    }
}
