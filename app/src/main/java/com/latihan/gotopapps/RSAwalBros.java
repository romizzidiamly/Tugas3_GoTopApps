package com.latihan.gotopapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listAction = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAction));

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
                String notelp = "tel:0761 47333";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(notelp));

            }else if (pilihan.equals("SMS Center")) {
                String smsteks = "Halo, This is Call Center Awal Bros Hospital?";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081266669999"));
                a.putExtra("sms_body", smsteks);

            }else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://www.google.com/maps/place/RS+Awal+Bros+Sudirman/@0.4944556,101.4537525,14.66z/data=!4m5!3m4!1s0x31d5aea46b46e5f1:0xdbacb5fecaf89643!8m2!3d0.4965887!4d101.4562887";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            }else if (pilihan.equals("Website")) {
                String website = "http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            }else if (pilihan.equals("Info")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bros");

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
