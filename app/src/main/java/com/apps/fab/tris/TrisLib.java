package com.apps.fab.tris;

public class TrisLib {
    private MainActivity main;
    public TrisLib(MainActivity main)
    {
        this.main=main;
    }

    public static void azzeraArray() {
        for (int i=0; i<9;i++)
        {
            MainActivity.square[i]=0;
            MainActivity.fixed[i]=0;

        }
    }

    public static int cercaVuote(int square[])
    {
        for (int i=0; i<9; i++)
        {
                if (square[i]==0)
                {
                    return 1;
                }
            }
        return 0;
    }

    public static int check(int square[])
    {
        int i,j;

        //righe
        if (square[0]==square[1] && square[1]==square[2] && square[0]!=0)
            {
                //controllo che giocatore è (1=x 2=o
                if (square[0]==1) {
                    return 1;
                } else if (square[0]==2) {
                    return 2;
                }
            }
        if (square[3]==square[4] && square[4]==square[5] && square[3]!=0)
        {
            //controllo che giocatore è (1=x 2=o
            if (square[3]==1) {
                return 1;
            } else if (square[3]==2) {
                return 2;
            }
        }
        if (square[6]==square[7] && square[7]==square[8] && square[6]!=0)
        {
            //controllo che giocatore è (1=x 2=o
            if (square[6]==1) {
                return 1;
            } else if (square[6]==2) {
                return 2;
            }
        }



        //colonne
        if (square[0]==square[3] && square[3]==square[6] && square[0]!=0)
        {
            //controllo che giocatore è (1=x 2=o
            if (square[0]==1) {
                return 1;
            } else if (square[0]==2) {
                return 2;
            }
        }
        if (square[1]==square[4] && square[4]==square[7] && square[1]!=0)
        {
            //controllo che giocatore è (1=x 2=o
            if (square[1]==1) {
                return 1;
            } else if (square[1]==2) {
                return 2;
            }
        }
        if (square[2]==square[5] && square[5]==square[8] && square[2]!=0)
        {
            //controllo che giocatore è (1=x 2=o
            if (square[2]==1) {
                return 1;
            } else if (square[2]==2) {
                return 2;
            }
        }


        //diagonali
        if (square[0]==square[4] && square[4]==square[8] && square[0]!=0)
        {
            //controllo che giocatore è (1=x 2=o)
            if (square[0]==1) {
                return 1;
            } else if (square[0]==2) {
                return 2;
            }
        }
        if (square[2]==square[4] && square[4]==square[6] && square[2]!=0)
        {
            if (square[2]==1) {
                return 1;
            } else if (square[2]==2) {
                return 2;
            }
        }

        //pari
        if (cercaVuote(square)==0) {
            return -1;
        }
        //continua
        return 0;

    }

}
