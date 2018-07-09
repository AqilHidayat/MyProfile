package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);
        rgGender = findViewById(R.id.radiogGender);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float GPA = Float.valueOf(etGPA.getText().toString());
        int rb = rgGender.getCheckedRadioButtonId();




        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("Name", strName);
        prefEdit.putFloat("GPA", GPA);
        prefEdit.putInt("radioB", rb);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("Name", "");

        float fGPA = prefs.getFloat("GPA", 0.0f);

        int rb = prefs.getInt("radioB", 0);



        etName.setText(name);
        etGPA.setText(String.valueOf(fGPA));
        rgGender.check(rb);
    }
}
