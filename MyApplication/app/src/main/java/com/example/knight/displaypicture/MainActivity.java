package com.example.knight.displaypicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewcollection);

        ListView listView=(ListView)findViewById(R.id.lv_listview);

        ArrayList<ItemEntity>  listarry=new ArrayList<>();

        ArrayList<String> listpicture=new ArrayList<>();
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698837_7507.jpg");
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698865_3560.jpg");
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698867_8323.jpg");
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698837_5654.jpg");
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698883_5877.jpg");
        listpicture.add("http://img.my.csdn.net/uploads/201410/19/1413698839_2302.jpg");
        ItemEntity itemEntity=new ItemEntity("http://img.my.csdn.net/uploads/201410/19/1413698865_3560.jpg","张三","真的勇士敢于挑战淋漓的鲜血",listpicture);
        listarry.add(itemEntity);



        ArrayList<String> listpicture01=new ArrayList<>();
        listpicture01.add("http://img.my.csdn.net/uploads/201410/19/1413698837_7507.jpg");
//        listpicture01.add("http://img.my.csdn.net/uploads/201410/19/1413698865_3560.jpg");

        ItemEntity itemEntity01=new ItemEntity("http://img.my.csdn.net/uploads/201410/19/1413698883_5877.jpg","李四","我是李四，就是李四！",listpicture01);

        listarry.add(itemEntity01);


        ListItemAdapter adapter=new ListItemAdapter(getApplication(),listarry);
        listView.setAdapter(adapter);

    }
}
