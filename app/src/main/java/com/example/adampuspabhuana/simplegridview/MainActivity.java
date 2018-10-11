package com.example.adampuspabhuana.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "http://worldversus.com/img/ironman.jpg",
            "http://worldversus.com/img/hulk.jpg",
            "http://screenrant.com/wp-content/uploads/Captain-America-Glamour.jpg",
            "https://i.ytimg.com/vi/7p7rocHEecE/maxresdefault.jpg",
            "http://images6.fanpop.com/image/photos/39400000/Hawkeye-captain-america-civil-war-39434674-1600-900.jpg",
            "http://images.techtimes.com/data/images/full/90435/black-widow.jpg",
            "http://static4.businessinsider.com/image/5616ee10dd089562288b4630/the-military-is-2-years-away-from-unleashing-its-real-life-iron-man-suit.jpg",
            "http://img.cinemablend.com/cb/7/a/d/e/5/a/7ade5a4267a0b4357f0e66a5b4b0a2d639a7dd4096ae64c101fe2bfb24cf2f85.jpg",
            "http://115.imagebam.com/download/IL2fKxg0D0JmWPyleGF3-g/47900/478995554/Captain%20America%201.jpg",
            "http://img.cinemablend.com/quill/6/2/9/0/3/6/6290368592f1154ca01dc51f12b9eeac4f60c300.jpg"
    };
    private GridView gvItem;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Avengers");
        gvItem = (GridView)findViewById(R.id.gv_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gvItem.setAdapter(itemGridAdapter);
        gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this,

                        images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_staggered) {
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
