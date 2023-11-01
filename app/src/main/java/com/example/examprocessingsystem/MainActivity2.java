package com.example.examprocessingsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private CheckBox dsCheckBox, daaCheckBox, tocCheckBox, dbmsCheckBox, aiCheckBox, oopCheckBox,
            iapCheckBox, mobileAppsCheckBox, computerNetworksCheckBox, computerGraphicsCheckBox;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize CheckBoxes
        dsCheckBox = findViewById(R.id.course_ds_checkbox);
        daaCheckBox = findViewById(R.id.course_daa_checkbox);
        tocCheckBox = findViewById(R.id.course_toc_checkbox);
        dbmsCheckBox = findViewById(R.id.course_dbms_checkbox);
        aiCheckBox = findViewById(R.id.course_ai_checkbox);
        oopCheckBox = findViewById(R.id.course_oop_checkbox);
        iapCheckBox = findViewById(R.id.course_iap_checkbox);
        mobileAppsCheckBox = findViewById(R.id.course_mobile_checkbox);
        computerNetworksCheckBox = findViewById(R.id.course_networks_checkbox);
        computerGraphicsCheckBox = findViewById(R.id.course_graphics_checkbox);

        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform course selection and validation logic
                if (isCourseSelectionValid()) {
                    // Update the cloud database with the selected courses
                    updateDatabaseWithSelectedCourses();
                } else {
                    // Display an error message to inform the user
                    Toast.makeText(MainActivity2.this, "Please select at least 5 courses per semester and 10 courses per academic year.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Implement course selection and validation logic
    private boolean isCourseSelectionValid() {
        int selectedCount = 0;

        if (dsCheckBox.isChecked()) selectedCount++;
        if (daaCheckBox.isChecked()) selectedCount++;
        if (tocCheckBox.isChecked()) selectedCount++;
        if (dbmsCheckBox.isChecked()) selectedCount++;
        if (aiCheckBox.isChecked()) selectedCount++;
        if (oopCheckBox.isChecked()) selectedCount++;
        if (iapCheckBox.isChecked()) selectedCount++;
        if (mobileAppsCheckBox.isChecked()) selectedCount++;
        if (computerNetworksCheckBox.isChecked()) selectedCount++;
        if (computerGraphicsCheckBox.isChecked()) selectedCount++;

        return selectedCount >= 5;  // Minimum 5 courses per semester
    }

    // Implement the logic to update the cloud database with the selected courses
    private void updateDatabaseWithSelectedCourses() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        String studentId = "your_student_id";  // Replace with the actual student's unique identifier

        if (dsCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("Data Structures").setValue(true);
        }

        if (daaCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("DAA").setValue(true);
        }

        if (tocCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("Data Structures").setValue(true);
        }

        if (dbmsCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("DAA").setValue(true);
        }

        if (aiCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("Data Structures").setValue(true);
        }

        if (oopCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("DAA").setValue(true);
        }

        if (iapCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("Data Structures").setValue(true);
        }

        if (mobileAppsCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("DAA").setValue(true);
        }

        if (computerNetworksCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("Data Structures").setValue(true);
        }

        if (computerGraphicsCheckBox.isChecked()) {
            databaseReference.child("students").child(studentId).child("courses").child("DAA").setValue(true);
        }


        // Provide a success message to the user
        Toast.makeText(this, "Courses registered successfully", Toast.LENGTH_SHORT).show();
    }

}
