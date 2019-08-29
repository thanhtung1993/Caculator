package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
EditText edtGiaTri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int [] idButton={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnKetQua,R.id.btnCham,
                         R.id.btnC,R.id.btnCong,R.id.btnTru,R.id.btnchia,R.id.btnnhan};
        edtGiaTri=findViewById(R.id.edtGiaTri);
        for (int id:idButton)
        {
            View view=findViewById(id);
            view.setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn0:
                edtGiaTri.append("0");
                break;
            case R.id.btn1:
                    edtGiaTri.append("1");
                break;
            case R.id.btn2:
                edtGiaTri.append("2");
                break;
            case R.id.btn3:
                edtGiaTri.append("3");
                break;
            case R.id.btn4:
                edtGiaTri.append("4");

                break;
            case R.id.btn5:
                edtGiaTri.append("5");
                break;
            case R.id.btn6:
                edtGiaTri.append("6");

                break;
            case R.id.btn7:
                edtGiaTri.append("7");
                break;
            case R.id.btn8:
                edtGiaTri.append("8");

                break;
            case R.id.btn9:
                edtGiaTri.append("9");

                break;
            case R.id.btnCham:
                edtGiaTri.append(",");
                break;
            case R.id.btnC:
                edtGiaTri.setText("");
                break;
            case R.id.btnCong:
                edtGiaTri.append("+");
                break;
            case R.id.btnTru:
                edtGiaTri.append("-");
                break;
            case R.id.btnnhan:
                edtGiaTri.append("*");
                break;
            case R.id.btnchia:
                edtGiaTri.append("/");
                break;
            case R.id.btnKetQua:
                double result=0;
                DecimalFormat df = new DecimalFormat("###.#######");
                addOperation(edtGiaTri.getText().toString());
                addNumber(edtGiaTri.getText().toString());
                if (arrOperation.size()>=arrNumber.size() || arrOperation.size()<1)
                {
                    edtGiaTri.setText("Lỗi Định dạng roài !");
                }
                else {
                    //todo:tính giá trị biểu thức
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result += arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result -= arrNumber.get(i + 1);
                                }
                                break;
                            case "*":

                                if (i==0)
                                {
                                     result=arrNumber.get(i)*arrNumber.get(i+1);
                                }
                                else
                                {
                                    result*=arrNumber.get(i+1);
                                }
                                break;

                            case "/":

                                if (i==0)
                                {
                                    result=arrNumber.get(i)/arrNumber.get(i+1);
                                }
                                else
                                {
                                    result/=arrNumber.get(i+1);
                                }
                                break;


                        }
                        edtGiaTri.setText(df.format(result) + "");
                    }


                    break;
                }
                    default:


        }

    }
    //todo:phép tính
    public ArrayList<String> arrOperation;
    //todo:Số
    public ArrayList<Double> arrNumber;

    public int addOperation(String input)
    {
        arrOperation=new ArrayList<>();
        char[] cArray=input.toCharArray();
        for (int i=0;i<cArray.length;i++)
        {
            switch (cArray[i])
            {
                case '+':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '-':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '*':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '/':
                    arrOperation.add(cArray[i]+"");
                    break;
                    default:
                        break;
            }
        }
        return 0;
    }


    //todo: lưu số vào mảng
    public void addNumber(String inputNumber)
    {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(inputNumber);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }


}
