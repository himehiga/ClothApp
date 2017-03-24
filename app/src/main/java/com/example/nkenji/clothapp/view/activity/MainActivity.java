package com.example.nkenji.clothapp.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nkenji.clothapp.R;
import com.example.nkenji.clothapp.databinding.ActivityMainBinding;
import com.example.nkenji.clothapp.view.adapter.ClothRecyclerViewAdapter;
import com.example.nkenji.clothapp.viewmodel.Cloth;
import com.example.nkenji.clothapp.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ClothRecyclerViewAdapter mAdapter = null;
    private ActivityMainBinding mBinding = null;
    private List<Cloth> mClothList = null;
    private MainViewModel mMainViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMainViewModel = new MainViewModel();

        mClothList = mMainViewModel.getDB();

        setSupportActionBar(mBinding.toolbar);

        mClothList = mMainViewModel.getDB();
        mAdapter = new ClothRecyclerViewAdapter(this, mClothList);
        mBinding.recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_dress) {
            mClothList = mMainViewModel.getSelectedItems(Cloth.Genre.DRESS);
            mAdapter.resetRecyclerViewItems(mClothList);
            mAdapter.notifyDataSetChanged();

            return true;
        }
        if (id == R.id.search_pants) {
            mClothList = mMainViewModel.getSelectedItems(Cloth.Genre.PANTS);
            mAdapter.resetRecyclerViewItems(mClothList);
            mAdapter.notifyDataSetChanged();
            return true;
        }
        if (id == R.id.search_shirts) {
            mClothList = mMainViewModel.getSelectedItems(Cloth.Genre.SHIRT);
            mAdapter.resetRecyclerViewItems(mClothList);
            mAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
