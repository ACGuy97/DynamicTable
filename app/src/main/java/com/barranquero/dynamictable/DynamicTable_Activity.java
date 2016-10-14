package com.barranquero.dynamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DynamicTable_Activity extends AppCompatActivity {
    private TableLayout mTblHeader;
    private TableLayout mTblBody;
    private TableRow.LayoutParams mTbrLayoutId;
    private TableRow.LayoutParams mTbrLayoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table);

        mTblHeader = (TableLayout)findViewById(R.id.tblHeader);
        mTblBody = (TableLayout)findViewById(R.id.tblBody);

        mTbrLayoutId = new TableRow.LayoutParams(150, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutId.setMargins(0,10,0,10);
        mTbrLayoutName = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

        createHeader();
        createBody();
    }

    /**
     * Method which sets the Table Header
     */
    private void createHeader() {
        TableRow tbrHeader = new TableRow(this);

        // We create the ID column
        TextView txvId = new TextView(this);
        txvId.setText(R.string.txvId);
        txvId.setLayoutParams(mTbrLayoutId);
        tbrHeader.addView(txvId);

        // We create the Name column
        TextView txvName = new TextView(this);
        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(mTbrLayoutName);
        tbrHeader.addView(txvName);

        // We add both columns (the headers) to the Header TableLayout
        mTblHeader.addView(tbrHeader);
    }

    /**
     * Method which sets the Table Body
     */
    private void createBody() {
        TableRow tbrBody = new TableRow(this);

        TextView txvId = new TextView(this);
        TextView txvName = new TextView(this);

        String[] nameList = getResources().getStringArray(R.array.nameList);

        for (int i = 0; i < nameList.length; i++) {
            txvId.setText(i);
            txvId.setLayoutParams(mTbrLayoutId);
            txvName.setText(nameList[i]);
            txvName.setLayoutParams(mTbrLayoutName);

            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            mTblHeader.addView(tbrBody);
        }
    }
}
