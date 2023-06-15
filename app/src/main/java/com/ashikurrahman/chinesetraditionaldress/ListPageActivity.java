package com.ashikurrahman.chinesetraditionaldress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListPageActivity extends AppCompatActivity {

    private LinearLayout itemContainer;
    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        itemContainer = findViewById(R.id.itemContainer);
        itemList = generateItemList();

        for (ItemModel item : itemList) {
            addItem(item);
        }
    }

    private List<ItemModel> generateItemList() {
        List<ItemModel> itemList = new ArrayList<>();
        itemList.add(new ItemModel("Hanfu - 汉服", getString(R.string.hanfu_description), R.drawable.img1));
        itemList.add(new ItemModel("Cheongsam / Qipao - 旗袍", getString(R.string.cheongsam_description), R.drawable.img2));
        itemList.add(new ItemModel("Tang Suit - 唐装", getString(R.string.tang_suit_description), R.drawable.img3));
        itemList.add(new ItemModel("Zhongshan Suit (Mao Suit) - 中山装", getString(R.string.zhongshan_suit_description), R.drawable.img4));
        itemList.add(new ItemModel("Shenyi - 深衣", getString(R.string.shenyi_description), R.drawable.img5));
        itemList.add(new ItemModel("Pienfu - 便服", getString(R.string.pienfu_description), R.drawable.img6));
        itemList.add(new ItemModel("Chang'ao - 長襖", getString(R.string.changao_description), R.drawable.img7));
        itemList.add(new ItemModel("Ruqun - 襦裙", getString(R.string.ruqun_description), R.drawable.img8));
        itemList.add(new ItemModel("Daxiushan - 大袖衫", getString(R.string.daxiushan_description), R.drawable.img9));
        itemList.add(new ItemModel("Yisan - 曳撒", getString(R.string.yisan_description), R.drawable.img10));
        itemList.add(new ItemModel("Daopao - 道袍", getString(R.string.daopao_description), R.drawable.img11));
        itemList.add(new ItemModel("Banbi - 半臂", getString(R.string.banbi_description), R.drawable.img12));
        itemList.add(new ItemModel("Huadian - 花钿", getString(R.string.huadian_description), R.drawable.img13));
        itemList.add(new ItemModel("Changshan - 長衫", getString(R.string.changshan_description), R.drawable.img14));
        itemList.add(new ItemModel("Aoqun - 襖裙", getString(R.string.aoqun_description), R.drawable.img15));

        return itemList;
    }

    private void addItem(final ItemModel item) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View itemLayout = inflater.inflate(R.layout.item_layout, itemContainer, false);

        ImageView itemThumbnail = itemLayout.findViewById(R.id.itemThumbnail);
        TextView itemTitle = itemLayout.findViewById(R.id.itemTitle);

        itemTitle.setText(item.getTitle());
        itemThumbnail.setImageResource(item.getThumbnailResId());

        itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListPageActivity.this, DetailPageActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        itemContainer.addView(itemLayout);
    }
}