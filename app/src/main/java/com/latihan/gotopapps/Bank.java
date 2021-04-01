package com.latihan.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Bank extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listMall = new String[] {
                "Bank Central Asia",
                "Bank Rakyat Indonesia",
                "Bank Negara Indonesia",
                "Bank Mandiri"
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
            if (pilihan.equals("Bank Central Asia")) {
                a = new Intent(this,BCA.class);

            }else if (pilihan.equals("Bank Rakyat Indonesia")) {
                a = new Intent(this,BRI.class);

            }else if (pilihan.equals("Bank Negara Indonesia")) {
                a = new Intent(this,BNI.class);

            }else if (pilihan.equals("Bank Mandiri")) {
                a = new Intent(this,Mandiri.class);

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
