package id.taufiq.helper

import android.os.Handler

/**
 * Created By Taufiq on 11/18/2020.
 *
 */

object MyUrl {
    // Todo: Dont forget to change localhost into your IP Address
    const val BASE_URL = "http://10.32.76.85/librarian/"


}


// delaying activity function
fun delayFunction(function: () -> Unit, delay: Long) {
    @Suppress("DEPRECATION")
    Handler().postDelayed(function, delay)
}