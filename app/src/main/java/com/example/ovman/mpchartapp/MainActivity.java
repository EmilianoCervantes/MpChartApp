package com.example.ovman.mpchartapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnChartGestureListener,
        OnChartValueSelectedListener{

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = (LineChart)findViewById(R.id.LineChart);
        lineChart.setOnChartGestureListener(this);
        lineChart.setOnChartValueSelectedListener(this);
        //Le quitamos el grid que pinta abajo
        lineChart.setDrawGridBackground(false);

        data();
        Legend legend = lineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);

        Description description = new Description();
        description.setText("Esto es un demo");
        lineChart.setDescription(description);

        lineChart.setNoDataText("No hay datos");
        //Definir un limite
        //Es un tipo de linea que aparece en la grafica
        LimitLine limitLine = new LimitLine(50f, "Máximo");
        limitLine.setLineWidth(6f);
        limitLine.setEnabled(true);
        limitLine.enableDashedLine(10f, 10f, 0f);
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        limitLine.setTextSize(12f);

        LimitLine downLimit = new LimitLine(0f, "Mínimo");
        downLimit.setLineWidth(6f);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.addLimitLine(limitLine);
        yAxis.addLimitLine(downLimit);
        yAxis.setAxisMaximum(60f);
        yAxis.setAxisMinimum(-25f);
        yAxis.enableAxisLineDashedLine(10f,10f,0f);
        yAxis.setDrawZeroLine(false);
        yAxis.setDrawLimitLinesBehindData(false);

        lineChart.getAxisRight().setEnabled(false);
        lineChart.animateX(3000, Easing.EasingOption.EaseInOutQuad);

        //actualizar la grafica
        lineChart.invalidate();
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        //
    }

    public void data(){
        //Cachar
        ArrayList<String> xData = xValues();
        //ArrayList<Entry> yData = yValues();
        //Con esto podemos dar un set de datos inicial
        //LineDataSet set = new LineDataSet(yData,"Data ONE");
        LineDataSet set = new LineDataSet(yValues(),"Data ONE");
        set.setColor(Color.BLACK);
        set.setCircleColor(Color.BLACK);
        set.setLineWidth(2F);
        set.setCircleRadius(3f);
        set.setDrawCircleHole(true);
        set.setValueTextSize(10f);
        set.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set);

        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);
    }

    //Para valores en x
    //Este es el de eqtiquetas
    public ArrayList<String> xValues(){
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        return list;
    }

    //Para valores en y
    //Este es el de datos, hay una clase entry para trabajar con ello
    public ArrayList<Entry> yValues(){
        //Estos datos son fijos, pero tambien pueden ser generados
        //Json, fire, etc.
        ArrayList<Entry> list = new ArrayList<>();
        list.add(new Entry(40, 25));
        list.add(new Entry(55, -5));
        list.add(new Entry(75.2f, 31));
        list.add(new Entry(100, 20));
        list.add(new Entry(150, 48));
        list.add(new Entry(189, 51));
        return list;
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
