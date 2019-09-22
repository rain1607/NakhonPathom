package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nakhonpathom.model.Place;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 /*   private String[] mPlaceList = new String[]{ //รายการต่างๆที่อยู่ในลิสต์
            "พระปฐมเจดีย์","บ้านปายนา","พิพิธภัณฑ์รถเก่า","ตลาดท่านา","วัดกลางบางแก้ว"
    };*/

 private List<Place> mPlaceList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        //ทำการอ้างอิงไปยังListViewใน Layout file
        ListView placeListView = findViewById(R.id.place_list_view);

        //สร้างAdepter
        ArrayAdapter<String> adepter = new ArrayAdapter<String>(
                MainActivity.this,
                R.layout.item_place, //ระบุlayout สำหรัยแต่ละ item ใน List
                R.id.place_name_textView, //ระบุวิวที่จะใส่ข้อมุลลงไปสำหรับ
                mPlaceList //แหล่งข้อมูล (data soure) ในที่นี้คือ อาร์เรย์ของ
        );
        //เอา Adepter ไปผูกเก็บ ListView โดยเรียกใช้เมธอด setAdepter ของ Listview
        placeListView.setAdapter(adepter);

        //สร้างListtenerเพื่อรบุโค้กการทำงาน เมื่อแต่ละ Item ถูกเลือก
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //อ่านชื่อสถานที่ของ item ที่ถูกคลิก จากอาร์เรย์mPlaceList มาเก็บลงตัวแปร placeName
                String placeName = mPlaceList[position];
                //แสดงชื่อสถานที่ออกมาใน Toast
                Toast.makeText(MainActivity.this,placeName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateData() {
        Place place = new Place("พระปฐมเจดีย์","เมือง");
        mPlaceList.add(place);

        place = new Place("บ้านปายนา","นครชัยศรี");
        mPlaceList.add(place);

        place = new Place("พิพิธภัณฑ์รถเก่า","นครชัยศรี");
        mPlaceList.add(place);

        place = new Place("ตลาดท่านา","นครชับศรี");
        mPlaceList.add(place);

        place = new Place("วัดกลางบางแก้ว","นครชัยศรี");
        mPlaceList.add(place);

        place = new Place("ตลาดน้ำลำพญา","บางเลน");
        mPlaceList.add(place);

        place = new Place("ตลาดทุ่งบัวแดง","บางเลน");
        mPlaceList.add(place);
    }
}
