package np.com.sagardevkota.daggertemplate.utils

import kotlin.experimental.and
import kotlin.experimental.or

/**
 * Created by HP on 10/22/2016.
 */

object Utils {
    fun md5(md5: String): String? {
        try {
            val md = java.security.MessageDigest.getInstance("MD5")
            val array = md.digest(md5.toByteArray())
            val sb = StringBuffer()
            for (i in array.indices) {
                sb.append(Integer.toHexString(array[i].toInt() and 0xFF or 0x100).substring(1, 3))
            }
            return sb.toString()
        } catch (e: java.security.NoSuchAlgorithmException) {
        }

        return null
    }
}
