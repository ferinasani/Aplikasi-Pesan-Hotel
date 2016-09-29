package id.sch.smktelkom_mlg.tugas01.xirpl5017.aplikasipesanhotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Spinner spJenis;
    EditText etNama;
    CheckBox cbMK, cbRS, cbHK;
    TextView tvHasil;
    int nFas;
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup RGr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spJenis = (Spinner) findViewById(R.id.spinnerJenis);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        etNama = (EditText) findViewById(R.id.editTextNama);
        cbMK = (CheckBox) findViewById(R.id.checkBoxMK);
        cbRS = (CheckBox) findViewById(R.id.checkBoxRS);
        cbHK = (CheckBox) findViewById(R.id.checkBoxHK);
        RGr = (RadioGroup) findViewById(R.id.RG);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        cbMK.setOnCheckedChangeListener(this);
        cbRS.setOnCheckedChangeListener(this);
        cbHK.setOnCheckedChangeListener(this);

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

        }

    private void doClick() {
        int hargaTotal, hargaKamar, lamaInap;
        hargaKamar = hargaTotal = lamaInap = 0;

        StringBuilder muncul = new StringBuilder();
        muncul.append("Nama : " + etNama.getText().toString() + "\n");
        muncul.append("Jenis Kamar : " + spJenis.getSelectedItem().toString() + "\n");

        if (RGr.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(RGr.getCheckedRadioButtonId());
            lamaInap = Integer.parseInt(rb.getText().toString());
        }
        muncul.append("Lama : " + lamaInap + "\n");


        String hasil = "Fasilitas yang dipilih adalah:\n";

        int startlen = hasil.length();
        if (cbMK.isChecked()) {
            hasil += cbMK.getText() + "\n";
            hargaTotal += 200000;
        }
        if (cbRS.isChecked()) {
            hasil += cbRS.getText() + "\n";
            hargaTotal += 100000;
        }
        if (cbHK.isChecked()) {
            hasil += cbHK.getText() + "\n";
            hargaTotal += 50000;
        }

        if (hasil.length() == startlen) hasil += "Tidak ada pada Pilihan";
        else hasil += "Fasilitas yang terpilih : " + nFas;

        if (spJenis.getSelectedItem().toString().equals("Diamond")) {
            hargaKamar = 1000000;
        } else if (spJenis.getSelectedItem().toString().equals("Gold")) {
            hargaKamar = 700000;
        } else if (spJenis.getSelectedItem().toString().equals("Silver")) {
            hargaKamar = 500000;
        } else {
            muncul.append("LOLOLO!!! \n");
        }

        hargaTotal += hargaKamar * lamaInap;


        tvHasil.setText(muncul + hasil + "TOTAL " + hargaTotal);
        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nFas += 1;
        else nFas -= 1;

        String hasil = null;

        if (rb1.isChecked()) {
            hasil = rb1.getText().toString();
        } else if (rb2.isChecked()) {
            hasil = rb2.getText().toString();
        } else if (rb3.isChecked()) {
            hasil = rb3.getText().toString();
        } else if (rb4.isChecked()) {
            hasil = rb4.getText().toString();
        }
    }
    }

