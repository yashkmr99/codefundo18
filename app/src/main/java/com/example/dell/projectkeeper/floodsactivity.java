package com.example.dell.projectkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class floodsactivity extends AppCompatActivity {


    TextView earthquake;
    String str = "DO’s \n" +
            "\n" +
            "\n" +
            "● Turn off gas valves fed to appliances, water valves and the electricity on the main fuse box. Be aware that surges of electricity during gas leaks can cause violent ignitions.\n" +
            "● Unplug all electrical items and store them away from floodwaters.\n" +
            "● Move all inhabitants and pets to safe locations, ideally in pet carriers. Untie cattle.\n" +
            "● If safely possible, move rugs, furniture and any sentimental or otherwise valuable possessions to a drier location. Big appliances may be raised with bricks.\n" +
            "● Sop up and extract intruding waters when possible.\n" +
            "● To prevent sewage backups, put sandbags in the toilet and obstructions on drain holes.\n" +
            "● Bathe and wash items with clean, preferably safely contained water. Drink only clean water, preferably bottled water. If left without options, boil water for ten minutes before using and drinking.\n" +
            "● Enhance airflows to enhance drying. Bringing the heat down to around 65℉ impedes bacterial growth.\n" +
            "● Wearing mosquito nets can combat the heightened threat of mosquito-borne diseases.\n" +
            "● Look out for snakes, which often go inside flooded homes.\n" +
            "● If trapped, try to contact 911 and stay by a window to attempt to signal someone outside.\n" +
            "● Use a radio and local media for news updates.\n" +
            "● Help neighbors when possible but otherwise avoid walking through floodwaters, as something like a manhole opened due to water pressure could make a situation worse.\n" +
            "● Sturdy work boots and gloves can help with submerged and dangerous debris. The most common injury during a flood is cut feet.\n" +
            "● Beware of and watch for structural damages, such as falling walls and ceilings. Piercing small holes in sagging ceilings can strategically drain them and prevent collapses.\n" +
            "● Strong ropes and a well equipped First Aid Kit can greatly enhance rescue efforts.\n" +
            "\n" +
            "\n" +
            "\n" +
            "DONT'S\n" +
            "\n" +
            "\n" +
            "● Don’t eat or drink anything exposed to the likely contaminated floodwaters.\n" +
            "● Don’t use potentially contaminated water for washing or food preparations.\n" +
            "● Don’t let wet dyes from clothes, books, etc. damage other items and carpets.\n" +
            "● Watch out for and don’t approach downed power lines.\n" +
            "● Don’t drive through floodwaters. If stuck, exit the car and move to higher ground.\n" +
            "● Don’t use open flames in the presence of gas, propane or natural gas. Use flashlights.\n" +
            "● Both floating and sinking littered debris and refuse can both complicate rescue efforts and plug outgoing flows.\n" +
            "● Don’t be careless in a flooded area at night when it’s much harder to see standing and flowing water. Two feet of moving water is deep enough to sweep away a vehicle and six inches can sweep away an adult.\n" +
            "● Touching or approaching wet, plugged-in electronics can lead to electrocution.\n" +
            "● Don’t leave doors and windows unlocked when leaving your property due to high incidences of looting.\n" +
            "\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floodsactivity);


        earthquake =(TextView) findViewById(R.id.earthquake);

        loadText();
    }

    private void loadText(){

        earthquake.setMovementMethod(new ScrollingMovementMethod());
        earthquake.setText(str);

    }

}
