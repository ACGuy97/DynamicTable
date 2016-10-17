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

        // Setting up the appearance of the ID column
        mTbrLayoutId = new TableRow.LayoutParams(150, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutId.setMargins(0,10,0,10);

        // Setting up the appearance of the Name column
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
        txvId.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvId);

        // We create the Name column
        TextView txvName = new TextView(this);
        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(mTbrLayoutName);
        txvName.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvName);

        // We add both columns (the headers) to the Header TableLayout
        mTblHeader.addView(tbrHeader);
    }

    /**
     * Method which sets the Table Body
     */
    private void createBody() {
        TableRow tbrBody;

        TextView txvId;
        TextView txvName;

        // We get the name list from the array declared in the file 'strings.xml'
        String[] nameList = getResources().getStringArray(R.array.nameList);

        for (int i = 0; i < nameList.length; i++) {
            tbrBody = new TableRow(this);   // We create a row for each name

            // For every item, we create two TextViews: one for the ID, one for the name
            txvId = new TextView(this);
            txvName = new TextView(this);

            txvId.setText(" "+ (i + 1) +" ");
            txvId.setLayoutParams(mTbrLayoutId);    // We apply the LayoutParams to the TextView
            txvId.setBackgroundResource(R.drawable.shape_body);     // We apply the shape we created

            txvName.setText(nameList[i]);
            txvName.setLayoutParams(mTbrLayoutName);
            txvName.setBackgroundResource(R.drawable.shape_body);

            // We add both TextViews to the TableRow
            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            // We add the TableRow to the TableLayout
            mTblBody.addView(tbrBody);
        }
    }
}
