package com.frandog.a20180115_03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //在上方Tools/Android/Android Device Monitor，在File Explorer可以看data(如果執行時開不了，要在Tools/Android/Enable ADB上打勾)
    TextView tv;
    EditText et,et2;
    SharedPreferences sp,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickWrite(View v)
    {
        sp = getSharedPreferences("mydata",MODE_PRIVATE); //mydata是檔案名稱
        SharedPreferences.Editor editor = sp.edit();
        et = findViewById(R.id.editText);
        editor.putString("data1",et.getText().toString());  //data1是key
        editor.commit();
//        存好的檔案可以在Android Device Monitor/data/data/專案名/shared_prefs裡找到，點右上的pull a file from the device
    }
    public void clickRead(View v)
    {
        tv = findViewById(R.id.textView);
        sp = getSharedPreferences("mydata",MODE_PRIVATE);
        String str = sp.getString("data1","");      //參數2為預設值
        tv.setText(str);
    }
    public void clickWrite2(View v)     //可訂2個以上的key
    {
        sp2 = getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        et2 = findViewById(R.id.editText2);
        editor.putString("data2",et2.getText().toString());
        editor.commit();
    }
    public void clickSetting(View v)        //新開New/Activity/SettingsActivity(parent要選，表示back時要退回哪一頁)
    {
        Intent it = new Intent(MainActivity.this,SettingsActivity.class);
        startActivity(it);
    }
    public void showSetting(View v)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);     //去找預設檔案(也可以直接key"Android Device Monitor/data/data/專案名/預設檔名")
        String str = sp.getString("example_text","");      //可以在res/xml/pref_general.xml看到key的名稱
        TextView tv = findViewById(R.id.textView2);
        tv.setText(str);
    }
}
