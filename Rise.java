package com.example.Rise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class Rise extends Activity
{
  TextView amount1;
  TextView amount2;
  TextView tt;
  RadioGroup radioOpGroup;
  RadioButton radioOpButton;

  Button calculate;

  Random myRandom;
  int iRandom;

  String sAnswer;

  double x=0;
  double y=0;
  double z=0;


  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      initControls();
  }
  private void initControls()
  {
      amount1=(EditText)findViewById(R.id.amount1);
      amount2=(EditText)findViewById(R.id.amount2);

      /*Code to generate 2 digit random no*/
      myRandom = new Random();
      iRandom = myRandom.nextInt(99 - 10 + 1) + 10;

      amount1.setText(String.valueOf(iRandom));


      /*Code to generate 2 digit random no*/
      myRandom = new Random();
      iRandom = myRandom.nextInt(99 - 10 + 1) + 10;

      amount2.setText(String.valueOf(iRandom));

      tt=(TextView)findViewById(R.id.tt);

      calculate=(Button)findViewById(R.id.calculate);

      calculate.setOnClickListener(new Button.OnClickListener()
      {public void onClick
      (View  v) { calculate();}});
  }
  private void calculate()
  {
	  radioOpGroup = (RadioGroup) findViewById(R.id.Operations);
	  int selectedId = radioOpGroup.getCheckedRadioButtonId();
	  radioOpButton = (RadioButton) findViewById(selectedId);

	  /* Get the Answer text box. If its full then create random no.s in above two textboxes
	  else remove the content of text box and generate random no.s */

	  sAnswer = tt.getText().toString();

	  if(sAnswer.length() > 0)
	  {
		  myRandom = new Random();
		  iRandom = myRandom.nextInt(99 - 10 + 1) + 10;

		  amount1.setText(String.valueOf(iRandom));

		  myRandom = new Random();
		  iRandom = myRandom.nextInt(99 - 10 + 1) + 10;

		  amount2.setText(String.valueOf(iRandom));
		  tt.setText("");
	  }
	  else
	  {
		  switch(radioOpButton.getId()){
		  	case R.id.Addition:
				x=Double.parseDouble(amount1.getText().toString());
				y=Double.parseDouble(amount2.getText().toString());
				z=x+y;
				tt.setText(Double.toString(z));
				break;
		  	case R.id.Subtraction:
				x=Double.parseDouble(amount1.getText().toString());
				y=Double.parseDouble(amount2.getText().toString());
				z=x-y;
				tt.setText(Double.toString(z));
				break;
		  	case R.id.Multiplication:
				x=Double.parseDouble(amount1.getText().toString());
				y=Double.parseDouble(amount2.getText().toString());
				z=x*y;
				tt.setText(Double.toString(z));
				break;
		  	case R.id.Division:
				x=Double.parseDouble(amount1.getText().toString());
				y=Double.parseDouble(amount2.getText().toString());
				z=x/y;
				tt.setText(Double.toString(z));
				break;
	  	  }
      }
  }
}