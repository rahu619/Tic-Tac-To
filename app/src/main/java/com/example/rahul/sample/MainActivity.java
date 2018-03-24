package com.example.rahul.sample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int _magicSquare=15;
    Button[] _btns=new Button[9];

    boolean _isPlayer1=true;
    String _player1Piece="X",_player2Piece="O";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ControlIdentify();
    }

    public void onStart(View v){
         if(_btns!=null)
         {
             for(Button _btn:_btns){
                 _btn.setText(null);
             }
         }

        _isPlayer1=true;

    }

    void ControlIdentify(){

        int i=0;
        while(i<_btns.length) {
            String _buttonID="btn"+i;
            int resID= getResources().getIdentifier(_buttonID,"id",getPackageName());
            _btns[i]=(Button)findViewById(resID);
            _btns[i].setOnClickListener(this);

         i++;
        }
    }

    public void onClick(View v){

        String _activePiece= _isPlayer1?_player1Piece:_player2Piece;
        String _activeColor=_isPlayer1?"#33cc59":"#ff3300";

        for(int i=0;i< _btns.length;i++){
           if(v.getId() ==  _btns[i].getId()) {
               _btns[i].setText(_activePiece);
               _btns[i].setTextColor(Color.parseColor(_activeColor));

           }
        }

        if(Check())
        {
            String _msg= "Player "+ (_isPlayer1?1:2) +" won!";
            Toast _toast=Toast.makeText(getApplicationContext(),_msg,Toast.LENGTH_LONG);
            _toast.show();
        }

        _isPlayer1=!_isPlayer1;

    }

    boolean Check() {

         boolean _stop=false;

         for(int i=0;i<=6;i++){

                 if (i == 0 || i == 3 || i == 6) {
                     if (_btns[i].getText() == _btns[i + 1].getText() && _btns[i + 1].getText() == _btns[i + 2].getText() && _btns[i].getText().toString()!="") {
                         _stop = true;
                         break;
                     }

                 }
                 if (i == 0 || i == 1 || i == 2) {
                     if (_btns[i].getText() == _btns[i + 3].getText() && _btns[i + 3].getText() == _btns[i + 6].getText() && _btns[i].getText().toString()!="") {
                         _stop = true;
                         break;
                     }

                 }


         }
        if (_btns[0].getText() == _btns[4].getText() && _btns[4].getText() == _btns[8].getText() && _btns[0].getText().toString()!="")
            _stop = true;

        if (_btns[2].getText() == _btns[4].getText() && _btns[4].getText() == _btns[6].getText() && _btns[2].getText().toString()!="")
            _stop = true;


    return _stop;
    }




}
