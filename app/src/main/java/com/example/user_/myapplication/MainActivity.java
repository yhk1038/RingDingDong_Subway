package com.example.user_.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu(메뉴를 채우다); 메뉴를  이것은 만약 아이템이 존재한다면 그것을 action bar 에 추가합니다.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will      (action bar item 클릭들을 여기에서 조절합니다.)
        // automatically handle clicks on the Home/Up button, so long   (이 action bar 는 자동적으로 Home/Up 버튼에서 클릭들을 조절할 것입니다.)
        // as you specify a parent activity in AndroidManifest.xml.     (그래서 AndroidManifest.xml 파일에서 한개의 부모 activity 를 특정하게 됩니다.)
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement  (SimplifiableStatement -직역: 단순화 가능 상태(?)- 검사)
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
