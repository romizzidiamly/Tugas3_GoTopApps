package com.latihan.gotopapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TransmartPku extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listAction = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info"};
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listAction));

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
            if (pilihan.equals("Call Center")) {
                String notelp = "tel:082208255195";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(notelp));

            }else if (pilihan.equals("SMS Center")) {
                String smsteks = "Halo, This is Call Center Transmart Pekanbaru";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081266669999"));
                a.putExtra("sms_body", smsteks);

            }else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://www.google.com/maps/place/Transmart+Carrefour+Pekanbaru/@0.5026465,101.4199438,16.25z/data=!4m8!1m2!2m1!1smandiri!3m4!1s0x31d5abe3602661c9:0x60a28e2af0890e0a!8m2!3d0.5033275!4d101.4205939";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            }else if (pilihan.equals("Website")) {
                String website = "http://carrefour.co.id/shop/GO_Pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            }else if (pilihan.equals("Info")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Transmart Pekanbaru");

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
