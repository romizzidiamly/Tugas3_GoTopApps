package com.latihan.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class University extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listUniversity = new String[] {
                "Universitas Riau",
                "Universitas Islam Riau",
                "UIN Sultan Syarif Kasim Riau",
                "Universitas Muhamadiyah Riau"
        };
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listUniversity));

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
            if (pilihan.equals("Universitas Riau")) {
                a = new Intent(this,Unri.class);

            }else if (pilihan.equals("Universitas Islam Riau")) {
                a = new Intent(this,Uir.class);

            }else if (pilihan.equals("UIN Sultan Syarif Kasim Riau")) {
                a = new Intent(this,UinSuska.class);

            }else if (pilihan.equals("Universitas Muhamadiyah Riau")) {
                a = new Intent(this,Umri.class);

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
