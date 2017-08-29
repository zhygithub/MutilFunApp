package zhy.scau.com.personalmemo.bussiness.perform.common.calendar

/**
 * Created by ZhengHy on 2017-06-28.
 */
class CalendarCore {

    companion object Instance{
        /**
         * 当前实际年份
         */
        val nowYear : Int = CalendarUtils.getMonth().year

        /**
         * 当前实际月份
         */
        val nowMonth : CalendarMonth = CalendarUtils.getMonth()

        /**
         * 当前实际星期
         */
        val nowWeek : CalendarWeek? = nowMonth.week?.get(nowMonth.hasToday)

        /**
         * 当前实际日期
         */
        val nowDate : CalendarDate? = nowWeek?.dates?.get(nowWeek?.hasToday)


        /**
         * 上个月
         */
        fun preMonth() : CalendarMonth{
            var result : CalendarMonth = CalendarUtils.getMonth(nowYear, nowMonth.month-1, 1)
            return result
        }


        /**
         * 下个月
         */
        fun nextMonth() : CalendarMonth{
            var result : CalendarMonth = CalendarUtils.getMonth(nowYear, nowMonth.month+1, 1)
            return result
        }
    }


}