package com.latihan.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Mall extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listMall = new String[] {
                "Mall SKA",
                "Mall Ciputra Seraya",
                "Living World Pekanbaru",
                "Transmart Carrefour Pekanbaru"
        };
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listMall));

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
            if (pilihan.equals("Mall SKA")) {
                a = new Intent(this,MallSKA.class);

            }else if (pilihan.equals("Mall Ciputra Seraya")) {
                a = new Intent(this,MallCiputra.class);

            }else if (pilihan.equals("Living World Pekanbaru")) {
                a = new Intent(this,LivingWorldPku.class);

            }else if (pilihan.equals("Transmart Carrefour Pekanbaru")) {
                a = new Intent(this,TransmartPku.class);

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
