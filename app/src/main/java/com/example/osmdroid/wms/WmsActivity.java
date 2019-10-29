package com.example.osmdroid.wms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.osmdroid.R;

import org.osmdroid.views.MapView;
import org.osmdroid.wms.WMSTileSource;

public class WmsActivity extends AppCompatActivity {
    MapView map;
   final static String[] beyonserver = {"http://180.167.113.60:9090/geoserver/beyondb/wms?"};//和田190基图
    WMSTileSource  wmsTileSource = new WMSTileSource("beyonserver", beyonserver, "beyondb%3Aimg_glob_0_7", "1.1.1", "EPSG:4326", "", 256);//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wms);
        map = (MapView) findViewById(R.id.map);
        map.setTileSource(wmsTileSource);//基础瓦片图
    }
    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }
    public void onPause(){
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }
}
