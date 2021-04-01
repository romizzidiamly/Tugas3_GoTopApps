package com.latihan.gotopapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LivingWorldPku extends ListActivity {
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
                String notelp = "tel:0761 6706100";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(notelp));

            }else if (pilihan.equals("SMS Center")) {
                String smsteks = "Halo, This is Call Center Living World";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081266669999"));
                a.putExtra("sms_body", smsteks);

            }else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://www.google.com/maps/place/Living+World+Pekanbaru/@0.4989568,101.4210067,17.34z/data=!4m8!1m2!2m1!1smandiri!3m4!1s0x31d5a9465c4806a5:0x4179ccd027f2df4e!8m2!3d0.5004422!4d101.4198395";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            }else if (pilihan.equals("Website")) {
                String website = "https://livingworldpekanbaru.business.site/?utm_source=gmb&utm_medium=referral/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            }else if (pilihan.equals("Info")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Living World Pekanbaru");

            }
            startActivity(a);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
