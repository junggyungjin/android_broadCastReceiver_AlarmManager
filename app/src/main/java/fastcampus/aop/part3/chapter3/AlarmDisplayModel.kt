package fastcampus.aop.part3.chapter3

// 데이터 클래스를 만들때 기본적으로 상수로 선언해주는게 좋음
data class AlarmDisplayModel(
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) {

    val timeText: String
        get() {
            val h = "%02d".format(if (hour < 12) hour else hour - 12)
            val m = "%02d".format(minute)

            return "$h:$m"
        }

    val ampmText: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }

    val onOffText: String
        get() {
            return if (onOff) "알람 끄기" else "알람 켜기"
        }

    fun makeDataForDB(): String {
        return "$hour:$minute"
    }
}