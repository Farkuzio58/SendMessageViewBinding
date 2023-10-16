package com.farkuzio58.sendmessageviewbinding;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

/**
 * @author farku
 * @version 1.0
 * Activity para visualizar una carta con nuestra información al abrir el menú
 */
public class AboutActivity extends MaterialAboutActivity {

    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

        MaterialAboutCard.Builder cardBuilder = new MaterialAboutCard.Builder();
        cardBuilder.title(R.string.cardTitle);
        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.miNombre)
                .icon(R.drawable.ic_person)
                .build());
        cardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.forkToGitHub)
                .icon(R.drawable.ic_link)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Farkuzio58"));
                        startActivity(intent);
                    }
                })
                .build());


        cardBuilder.cardColor(Color.parseColor("#34676767"));

        MaterialAboutCard.Builder cardVersion = new MaterialAboutCard.Builder();
        cardVersion.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.version)
                .icon(R.drawable.ic_info)
                .subText("1.0.0")
                .build());
        cardVersion.cardColor(Color.parseColor("#34676767"));



        return new MaterialAboutList(cardBuilder.build(), cardVersion.build());
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.About);
    }
}