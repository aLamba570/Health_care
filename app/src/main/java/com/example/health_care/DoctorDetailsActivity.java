package com.example.health_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String [][] doctor_details1 ={
            { "Doctor Name: Dr. John Smith, Hospital: Memorial, Experience: 10 years, Mobile Number: 555-555-5555, Fee: $200"},
            {"Doctor Name: Dr. Jane Doe, Hospital: St. Mary's, Experience: 15 years, Mobile Number: 555-555-5556, Fee: $250"},
            {"Doctor Name: Dr. Michael Johnson, Hospital: Community, Experience: 5 years, Mobile Number: 555-555-5557, Fee: $150"},
            {"Doctor Name: Dr. Susan Williams, Hospital: General, Experience: 20 years, Mobile Number: 555-555-5558, Fee: $300"},
            {"Doctor Name: Dr. David Brown, Hospital: Children's, Experience: 7 years, Mobile Number: 555-555-5559, Fee: $175", }
    };

    private String [][] doctor_details2 ={
            {"Doctor Name: Dr. Robert Garcia, Hospital: St. Luke's, Experience: 12 years, Mobile Number: 555-555-5560, Fee: $225"},
            {"Doctor Name: Dr. Michael Rodriguez, Hospital: City, Experience: 8 years, Mobile Number: 555-555-5561, Fee: $200"},
            {"Doctor Name: Dr. Susan Martinez, Hospital: Valley, Experience: 18 years, Mobile Number: 555-555-5562, Fee: $275"},
            {"Doctor Name: Dr. David Anderson, Hospital: Community, Experience: 9 years, Mobile Number: 555-555-5563, Fee: $150"},
            {"Doctor Name: Dr. James Thompson, Hospital: General, Experience: 14 years, Mobile Number: 555-555-5564, Fee: $250",}
    };

    private String [][] doctor_details3 ={
            {"Doctor Name: Dr. Christopher Gonzalez, Hospital: Memorial, Experience: 6 years, Mobile Number: 555-555-5565, Fee: $150"},
            {"Doctor Name: Dr. Joseph Lewis, Hospital: Children's, Experience: 15 years, Mobile Number: 555-555-5566, Fee: $250"},
            {"Doctor Name: Dr. Brian Hall, Hospital: St. Mary's, Experience: 8 years, Mobile Number: 555-555-5567, Fee: $200"},
            {"Doctor Name: Dr. Kevin Turner, Hospital: City, Experience: 12 years, Mobile Number: 555-555-5568, Fee: $225"},
            {"Doctor Name: Dr. Jason Perez, Hospital: Valley, Experience: 10 years, Mobile Number: 555-555-5569, Fee: $200",}
    };

    private String [][] doctor_details4 ={
            {"Doctor Name: Dr. Christopher Gonzalez, Hospital: Memorial, Experience: 6 years, Mobile Number: 555-555-5565, Fee: $150"},
            {"Doctor Name: Dr. Joseph Lewis, Hospital: Children's, Experience: 15 years, Mobile Number: 555-555-5566, Fee: $250"},
            {"Doctor Name: Dr. Brian Hall, Hospital: St. Mary's, Experience: 8 years, Mobile Number: 555-555-5567, Fee: $200"},
            {"Doctor Name: Dr. Kevin Turner, Hospital: City, Experience: 12 years, Mobile Number: 555-555-5568, Fee: $225"},
            {"Doctor Name: Dr. Jason Perez, Hospital: Valley, Experience: 10 years, Mobile Number: 555-555-5569, Fee: $200" }
    };


    private String [][] doctor_details5 ={
            {"Doctor Name : Dr. Kevin Turner", "Hospital Address : City Hospital", "Experience : 15years", "Mobile Number : 9876548732 ", "Fees : 800" },
            {"Doctor Name : Dr. William Evans", "Hospital Address : Valley Hospital", "Experience : 12years", "Mobile Number : 9814356732 ", "Fees : 700" },
            {"Doctor Name : Dr. Mark Moore", "Hospital Address : Children Hospital", "Experience : 5years", "Mobile Number : 9235634892 ", "Fees : 700" },
            {"Doctor Name :Dr. Matt Anderson", "Hospital Address : CommunityHospital", "Experience : 15years", "Mobile Number : 98218167452 ", "Fees : 800" },
            {"Doctor Name :Dr. John Robinson", "Hospital Address : General Hospital", "Experience : 5years", "Mobile Number : 9911012161 ", "Fees : 800" }
    };



    TextView tv;
    Button btn;
    String [][] doctor_details ={};
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    HashMap<String, String > item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


        tv= findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent k = getIntent();
        String title = k.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0){
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietician")==0){
            doctor_details=doctor_details2;
        }
        else if(title.compareTo("Surgeon")==0){
            doctor_details=doctor_details3;
        }
        else if(title.compareTo("Dentist")==0){
            doctor_details=doctor_details4;
        }
        else{
            doctor_details=doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        arrayList = new ArrayList<>();
        for(int i =0; i<doctor_details.length; i++){
            item = new HashMap<String, String >();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consulataion Fees: " +doctor_details[i][4] +"/-");
            arrayList.add(item);
        }

        simpleAdapter = new SimpleAdapter(this,arrayList,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e }
        );

        ListView listView = findViewById(R.id.listViewDD);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent k = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                k.putExtra("text1", title);
                k.putExtra("text2", doctor_details[i][0]);
                k.putExtra("text3", doctor_details[i][1]);
                k.putExtra("text4", doctor_details[i][3]);
                k.putExtra("text5", doctor_details[i][4]);
                startActivity(k);
            }
        });

    }
}