package com.apps.fab.tris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TrisLib lib=new TrisLib(this);
    static int[] square = new int[9];
    static int[] fixed = new int[9];
    ImageButton[] cells = new ImageButton[9];
    static int n=0;
    int player=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TrisLib.azzeraArray();
        ImageButton cell;

        for (int i=0;i<9;i++)
        {
            String buttonID = "cell" + i;

            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            cells[i] = ((ImageButton) findViewById(resID));
            n= i;
            cells[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int id = (v.getId());
        int x=0;
        switch (id) {
            case (R.id.cell0):
                   x=0;
                   break;
            case (R.id.cell1):
                x=1;
                break;
            case (R.id.cell2):
                x=2;
                break;
            case (R.id.cell3):
                x=3;
                break;
            case (R.id.cell4):
                x=4;
                break;
            case (R.id.cell5):
                x=5;
                break;
            case (R.id.cell6):
                x=6;
                break;
            case (R.id.cell7):
                x=7;
                break;
            case (R.id.cell8):
                x=8;
                break;
        }
        if (fixed[x] == 0)
        {
            if (player%2==0) {
                square[x] = 1;
            }
            else if (player%2==1) {
                square[x] = 2;
            }
            fixed[x] = 1;
            player++;
            aggiornaSfondi();
        }
        if(TrisLib.check(square)!=0)
        {
            end(TrisLib.check(square));
        }
    }

    public void end(int resoconto)
    {
        final TextView testo = (TextView) findViewById(R.id.resocontoTxt);
        switch(resoconto) {
            case (-1):
                testo.setText("PAREGGIO");
                break;
            case(1):
                testo.setText("Ha vinto CROCE");
                break;
            case(2):
                testo.setText("Ha vinto CERCHIO");
                break;
        }
        for (int i=0;i<9;i++) {
            fixed[i]=1;
        }
        ImageButton nuovo = (ImageButton) findViewById(R.id.newGame);
        nuovo.setVisibility(View.VISIBLE);
        nuovo.setClickable(true);
        nuovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrisLib.azzeraArray();
                aggiornaSfondi();
                testo.setText("");
            }
        });
    }

    public void aggiornaSfondi()
    {
        for (int i=0;i<9;i++)
        {
            String buttonID = "cell" + i;

            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            cells[i] = ((ImageButton) findViewById(resID));
            //risetto lo sfondo per ogni image button
            switch(square[i])
            {
                case(0):
                    cells[i].setImageResource(R.mipmap.emptycell);
                    break;
                case(1):
                    cells[i].setImageResource(R.mipmap.xcell);
                    break;
                case(2):
                    cells[i].setImageResource(R.mipmap.ocell);
                    break;
            }
        }
    }


}
