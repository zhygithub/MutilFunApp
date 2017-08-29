package zhy.scau.com.personalmemo.bussiness.perform.common.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import zhy.scau.com.personalmemo.bussiness.perform.common.CalendarCell

/**
 * Created by ZhengHy on 2017-05-23.
 */
class CalendarPanel (ctx: Context, attrs: AttributeSet?): TableLayout(ctx, attrs){

    constructor (ctx: Context) : this(ctx, null) {
        println("1 params")
    }

    constructor (ctx: Context, year: Int, month:Int, day:Int ) : this(ctx, null) {
        println("1 params")
    }

    init {
        isStretchAllColumns = true
        orientation = TableLayout.VERTICAL

//        var datesData :Array<CalendarWeek> = CalendarUtils.getMonth().week?: emptyArray()

        //获取默认的本月日期组
        var datesData :Array<CalendarWeek> = CalendarCore.nowMonth.week?: emptyArray()
        var tableRow: TableRow? = null
        var cell: CalendarCell? = null

        //获取该月份的事件数组
        var eventList : Array<CalendarEvent?> = obtainEventByMonth(6)

        var cellList: Array<CalendarCell?> = arrayOfNulls<CalendarCell>(42)

        var eventIndex :Int = 0
        var index: Int = 0
        for (weekData in datesData){
            tableRow = TableRow(ctx)
            tableRow.orientation = LinearLayout.HORIZONTAL
            addView(tableRow, TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT))
            for (dateData in weekData.dates?: emptyArray()){
                cell = CalendarCell(ctx)


                cell.text = dateData.day.toString()
                cell.rowNum = weekData.week
                cell.colNum = dateData.week
                if(dateData.month == CalendarCore.nowMonth.month && eventList.get(eventIndex)?.date == dateData.day){
                    cell.mHasEvent = true
                    eventIndex ++
                }

                cell.setOnClickListener {
                    val c = (it as CalendarCell)
                    Toast.makeText(ctx,"第"+c.rowNum+"周，星期"+c.colNum+","+c.text+"号,事件状态："+ c.mHasEvent.toString(), Toast.LENGTH_LONG).show()
                }


                tableRow?.addView(cell,TableRow.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT))
                cellList[index++] = cell
            }
        }

    }

    fun obtainEventByMonth(month :Int):Array<CalendarEvent?>{
        val c1 : CalendarEvent = CalendarEvent(2017,6,3,"test1")
        val c2 : CalendarEvent = CalendarEvent(2017,6,11,"test2")
        val c3 : CalendarEvent = CalendarEvent(2017,6,27,"test3")
        var result :Array<CalendarEvent?> = arrayOf(c1,c2,c3)

        return result
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }



}

