package com.latihan.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[] {"Rumah Sakit Awal Bros", "Eka Hospital", "RSUD Arifin Achmad", "Rumah Sakit Islam Ibnu Sina"
        };
        this.setListAdapter(new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1,listRS));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Rumah Sakit Awal Bros")) {
                a = new Intent(this,RSAwalBros.class);

            }else if (pilihan.equals("Eka Hospital")) {
                a = new Intent(this,EkaHospital.class);

            }else if (pilihan.equals("RSUD Arifin Achmad")) {
                a = new Intent(this,RSUD.class);

            }else if (pilihan.equals("Rumah Sakit Islam Ibnu Sina")) {
                a = new Intent(this,RSIbnuSina.class);

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
