package com.example.formprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button dangky;
    String stsodienthoai, stgioitinh, sttrinhdo, sttuoi, stthethao, stamnhac;
    EditText hoten, sodienthoai;
    Switch gioitinh;
    Spinner trinhdo;
    SeekBar tuoi;
    CheckBox thethao;
    RadioButton lofichill, trutinh, vinahouse;



    List<String> profile = new ArrayList<>();
    String[] arrprofile = new String[profile.size()];

    String arrtrinhdo [] = {"Đại Học","Cao đẳng", "Cao Học"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten = (EditText) findViewById(R.id.edHoten);
        sodienthoai = findViewById(R.id.edSodienthoai);
        gioitinh = findViewById(R.id.swGioitinh);
        trinhdo = findViewById(R.id.spTrinhdo);
        tuoi = findViewById(R.id.sbTuoi);
        thethao = findViewById(R.id.cbThethao);
        lofichill = findViewById(R.id.rbLofichill);
        trutinh = findViewById(R.id.rbTrutinh);
        vinahouse = findViewById(R.id.rbVinahouse);
        dangky = findViewById(R.id.btnDangky);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrtrinhdo);
        trinhdo.setAdapter(spinnerAdapter);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lấy họ và tên
                String sthoten = "Họ tên: " + hoten.getText().toString() ;
                profile.add(sthoten);

                //Lấy số điện thoại
                stsodienthoai = "Số điện thoại: " + sodienthoai.getText().toString();
                profile.add(stsodienthoai);

                //Lấy giới tính
                if (gioitinh.isChecked()){
                    stgioitinh = "Giới tính: Nam";
                }else{
                    stgioitinh = "Giới tính: Nữ";
                }
                profile.add(stgioitinh);

                //Lấy trình độ
                sttrinhdo = "Trình độ: " + trinhdo.getSelectedItem().toString();
                profile.add(sttrinhdo);

                //Lấy tuổi
                sttuoi = "Tuổi: "+ String.valueOf(tuoi.getProgress());
                profile.add(sttuoi);

                //Lấy thể thao
                if (thethao.isChecked())
                {
                    stthethao = "Thể thao: có";
                }
                else
                {
                    stthethao = "Thể thao: không";
                }
                profile.add(stthethao);

                //Lấy âm nhạc
                if (lofichill.isChecked()){
                    stamnhac = "Âm nhạc: Lofi";
                }else if (trutinh.isChecked()){
                    stamnhac = "Âm nhạc: Trữ tình";
                }else if (vinahouse.isChecked()){
                    stamnhac = "Âm nhạc: Vinahouse";
                }
                profile.add(stamnhac);

                Intent intent = new Intent(MainActivity.this, MainActivityShow.class);

                arrprofile = profile.toArray(arrprofile);

                intent.putExtra( "showprofile", arrprofile);
                startActivity(intent);

            }
        });
    }
}