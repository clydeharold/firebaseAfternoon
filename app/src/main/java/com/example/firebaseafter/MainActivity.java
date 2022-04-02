package com.example.firebaseafter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Students");

    Button cmdAdd;
    EditText etId, etName, etCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refs();

        cmdAdd.setOnClickListener(addStudentRecord);
    }

    View.OnClickListener addStudentRecord = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String id, name, course;

            id = etId.getText().toString();
            name = etName.getText().toString();
            course = etCourse.getText().toString();

            Student student = new Student(id, name, course);

            myRef.child(id).setValue(student);
        }
    };

    public void refs() {
        cmdAdd = findViewById(R.id.cmdAdd);
        etId = findViewById(R.id.txtStudentID);
        etName = findViewById(R.id.txtStudentName);
        etCourse = findViewById(R.id.txtStudentCourse);
    }
}