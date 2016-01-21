package com.example.user_.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    int MAX_PAGE=3;                             //View Pager의 총 페이지 갯수를 나타내는 변수 선언
    Fragment cur_fragment=new Fragment();       //현재 Viewpager가 가리키는 Fragment를 받을 변수 선언






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);        //Viewpager 선언 및 초기화
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));     //선언한 viewpager에 adapter를 연결

        TabLayout tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Tab One"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab Two"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab Three"));
        tabLayout.setupWithViewPager(viewPager);

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







    private class adapter extends FragmentPagerAdapter {        //adapter클래스
        public adapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position<0 || MAX_PAGE<=position)        //가리키는 페이지가 0 이하거나 MAX_PAGE보다 많을 시 null로 리턴
                return null;
            switch (position){                          //포지션에 맞는 Fragment찾아서 cur_fragment변수에 대입
                case 0:
                    cur_fragment=new page_1();
                    break;
                case 1:
                    cur_fragment=new page_2();
                    break;
                case 2:
                    cur_fragment=new page_3();
                    break;
            }
            return cur_fragment;
        }
        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }

}
