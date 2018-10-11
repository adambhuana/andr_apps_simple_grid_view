package com.example.adampuspabhuana.simplegridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "http://vignette3.wikia.nocookie.net/vsbattles/images/8/8d/The_Amazing_Spider-Man.png/revision/latest/scale-to-width-down/471?cb=20151017022603",
            "http://www.planwallpaper.com/static/images/Batman-ArkhamKnight-BatsuitRender.png",
            "http://cartoonbros.com/wp-content/uploads/2015/11/Superman-20.jpg",
            "http://4.bp.blogspot.com/-O4K5olr9jIg/VV-tfgHrs1I/AAAAAAAAAx0/o4BOWFAg7f4/s400/Wallpaper%2BSpiderman%2BKeren%2B10.jpg",
            "http://www.tahupedia.com/img/uploaded/post/post_2/daredevil.jpg",
            "http://www.planwallpaper.com/static/images/Character_Poster_-_Batman.jpg",
            "http://www.tahupedia.com/img/uploaded/post/post_2/wolverine.jpg",
            "http://www.tahupedia.com/img/uploaded/post/post_2/the_thing.jpg",
            "http://3.bp.blogspot.com/-qCtqN1BjCJc/VV-ttKToViI/AAAAAAAAAy0/bGIz5s_721U/s400/Wallpaper%2BSpiderman%2BKeren%2B8.jpg",
            "https://www.sideshowtoy.com/wp-content/uploads/2013/06/dc-comics-superman-premium-format-silo-300215.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        getSupportActionBar().setTitle("Marvels");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(MainActivity context){
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
