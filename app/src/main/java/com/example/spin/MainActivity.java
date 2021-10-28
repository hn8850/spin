package com.example.spin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Student[] cyber = new Student[10];
    Student[] art = new Student[10];
    Student[] engineering = new Student[10];
    Student[] math = new Student[10];
    String[] cyberNames = new String[10];
    String[] artNames = new String[10];
    String[] engineeringNames = new String[10];
    String[] mathNames = new String[10];
    String grades[] = {"Choose a Class", "Cyber", "Art", "Engineering", "Math"};
    ListView lv;
    ArrayAdapter<String> list_adp;
    Spinner classes;
    TextView name, surName, age, phone;
    int kita = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cyber[0] = new Student("Fernando", "Saunders", "042-8109-643", "1.8.2005");
        cyber[1] = new Student("William", "Lynn", "026-1931-820", "23.11.2005");
        cyber[2] = new Student("Maribeth", "Cox", "022-2489-220", "10.1.2005");
        cyber[3] = new Student("Hallie", "Scontras", "080-7986-518", "9.8.2005");
        cyber[4] = new Student("Brittney", "Bennett", "054-4929-490", "30.9.2005");
        cyber[5] = new Student("John", "Lagrand", "098-1037-402", "1.1.2005");
        cyber[6] = new Student("Roy", "Braddy", "073-7281-394", "2.12.2005");
        cyber[7] = new Student("Numbers", "Mellas", "064-7723-925", "19.7.2005");
        cyber[8] = new Student("Bertha", "Wells", "020-2048-125", "19.9.2005");
        cyber[9] = new Student("Bruce", "Pero", "045-8809-123", "25.5.2005");

        for (int i = 0; i < 10; i++) {
            cyberNames[i] = cyber[i].getName() + " " + cyber[i].getSurname();
        }

        engineering[0] = new Student("Lorna", "Ross", "094-5412-747", "4.1.2005");
        engineering[1] = new Student("David", "Dunn", "056-9856-467", "31.4.2005");
        engineering[2] = new Student("Matthew", "Fawver", "053-2247-125", "29.10.2005");
        engineering[3] = new Student("Cassandra", "Hayden", "074-1453-46", "18.12.2005");
        engineering[4] = new Student("Kathleen", "Daus", "067-2254-939", "12.5.2005");
        engineering[5] = new Student("Herbert", "Moffitt", "075-9943-129", "12.3.2005");
        engineering[6] = new Student("Kim", "Owen", "047-2150-570", "13.5.2005");
        engineering[7] = new Student("Donald", "Hankerson", "00-1524-212", "19.3.2005");
        engineering[8] = new Student("James", "Murray", "066-8408-210", "4.3.2005");
        engineering[9] = new Student("Sharon", "Gillum", "059-7058-200", "30.5.2005");

        for (int i = 0; i < 10; i++) {
            engineeringNames[i] = engineering[i].getName() + " " + engineering[i].getSurname();
        }

        art[0] = new Student("Rosa", "Fleming", "039-8722-598", "24.1.2005");
        art[1] = new Student("Barry", "Martinez", "098-1691-897", "13.3.2005");
        art[2] = new Student("Daniel", "Russo", "092-7070-899", "20.6.2005");
        art[3] = new Student("Therese", "Delapaz", "048-2662-127", "26.10.2005");
        art[4] = new Student("Jeremy", "Butler", "021-3450-896", "25.12.2005");
        art[5] = new Student("Laura", "Malone", "028-6505-197", "24.9.2005");
        art[6] = new Student("Jerry", "Hoffman", "080-2850-542", "8.10.2005");
        art[7] = new Student("John", "Morgan", "067-6276-475", "3.12.2005");
        art[8] = new Student("Helen", "Dalton", "032-4426-504", "26.1.2005");
        art[9] = new Student("Jerry", "Reyes", "068-4331-578", "10.3.2005");

        for (int i = 0; i < 10; i++) {
            artNames[i] = art[i].getName() + " " + art[i].getSurname();
        }

        math[0] = new Student("Patricia", "Haggett", "037-94-221", "23.8.2005");
        math[1] = new Student("Thomas", "Wilds", "045-6957-791", "23.4.2005");
        math[2] = new Student("Opal", "Mclaughlin", "059-4012-316", "22.1.2005");
        math[3] = new Student("Thelma", "Kidd", "057-711-908", "13.3.2005");
        math[4] = new Student("Ruby", "Emch", "038-8277-121", "30.11.2005");
        math[5] = new Student("Howard", "Lewellen", "013-8974-175", "30.2.2005");
        math[6] = new Student("Terrance", "Williams", "055-9242-718", "1.11.2005");
        math[7] = new Student("Margaret", "Rodriquez", "099-7728-332", "8.11.2005");
        math[8] = new Student("Becky", "Rounds", "078-2686-301", "31.7.2005");
        math[9] = new Student("Leslie", "Dupuis", "040-5137-757", "27.2.2005");

        for (int i = 0; i < 10; i++) {
            mathNames[i] = math[i].getName() + " " + math[i].getSurname();
        }


        lv = findViewById(R.id.lv);
        classes = findViewById(R.id.classes);
        name = findViewById(R.id.name);
        surName = findViewById(R.id.surname);
        age = findViewById(R.id.birth);
        phone = findViewById(R.id.phone);

        ArrayAdapter<String> spin_adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, grades);
        classes.setAdapter(spin_adp);
        classes.setOnItemSelectedListener(this);
        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            if (position == 1) {
                kita = 1;
                list_adp = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, cyberNames);
                lv.setAdapter(list_adp);

            } else if (position == 2) {
                kita = 2;
                list_adp = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, artNames);
                lv.setAdapter(list_adp);

            } else if (position == 3) {
                kita = 3;
                list_adp = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, engineeringNames);
                lv.setAdapter(list_adp);

            } else {
                kita = 4;
                list_adp = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, mathNames);
                lv.setAdapter(list_adp);

            }

        }
        else
        {
            lv.setAdapter(null);
            age.setText("");
            surName.setText("");
            name.setText("");
            phone.setText("");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (kita==1)
            {
                name.setText(cyber[position].getName());
                surName.setText(cyber[position].getSurname());
                age.setText(cyber[position].getDate());
                phone.setText(cyber[position].getNumber());
            }
            else if (kita==2)
            {
                name.setText(art[position].getName());
                surName.setText(art[position].getSurname());
                age.setText(art[position].getDate());
                phone.setText(art[position].getNumber());
            }

            else if (kita==3)
            {
                name.setText(engineering[position].getName());
                surName.setText(engineering[position].getSurname());
                age.setText(engineering[position].getDate());
                phone.setText(engineering[position].getNumber());
            }
            else
            {
                name.setText(math[position].getName());
                surName.setText(math[position].getSurname());
                age.setText(math[position].getDate());
                phone.setText(math[position].getNumber());

                }


        }


    }
