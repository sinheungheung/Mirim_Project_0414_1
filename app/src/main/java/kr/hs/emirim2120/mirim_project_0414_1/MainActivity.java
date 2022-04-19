package kr.hs.emirim2120.mirim_project_0414_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    CheckBox checkStart;
    ImageView imgv;
    LinearLayout LinearSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearSub = findViewById(R.id.Linear_sub);
        rg = findViewById(R.id.rg);
        checkStart = findViewById(R.id.check_start);
        imgv = findViewById(R.id.imgv);
        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);

        // 체크박스를 선택함에 따라 화면에 나타나고 안 나타나는 것을 표시하기 위해서
        checkStart.setOnCheckedChangeListener(checkListener);
    }
    // 선택한 버튼의 따라 사진이 바뀐다
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        // 선택한 라디오 버튼의 아이디가 반환이 된다
        public void onClick(View view) {
            switch(rg.getCheckedRadioButtonId()){
                case R.id.rb_dog:
                    imgv.setImageResource(R.drawable.dog);
                    break;
                case R.id.rb_cat:
                    imgv.setImageResource(R.drawable.cat);
                    break;
                case R.id.rb_rabbit:
                    imgv.setImageResource(R.drawable.rabbit);
                    break;
            }
        }
    };
    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                LinearSub.setVisibility(View.VISIBLE); // 체크가 되어있으면 보이게 설정
            }else{
                LinearSub.setVisibility(View.INVISIBLE); // 체크가 안 되어있으면 안 보이게 설정
            }
        }
    };
}